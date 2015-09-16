package com.tom.controller.rs;

import com.tom.model.MovieModel;
import com.tom.model.SearchMovieModel;
import com.tom.util.StringToArraylist;
import com.tom.util.StringToDate;
import com.tom.util.UrlToImgUtil;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Tom on 9-9-2015.
 */
@NoArgsConstructor
public class MovieControllerRs {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static MovieModel getMovie(SearchMovieModel model) throws IOException, JSONException {
        InputStream is = null;
        try {
            String url = "http://www.omdbapi.com/?t=" + model.getTitle() + "&type=" + model.getType().getDesc() + "&y=" + model.getReleasedYear() + "&r=json";
            URL myURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            connection.setRequestMethod("GET");
            connection.connect();
            JSONObject json = null;
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK) {
                is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                json = new JSONObject(jsonText);
            }
            return getMovieFromJson(json);
        } finally {
            if(is != null)
                is.close();
        }
    }

    private static MovieModel getMovieFromJson(JSONObject json){
        MovieModel movie = new MovieModel();
        if(json == null || json.has("error")){
            movie = null;
        }else{
            movie.setTitle(json.getString("Title"));
            movie.setImdbID(json.getString("imdbID"));
            movie.setPlot(json.getString("Plot"));
            movie.setPoster(json.getString("Poster"));
            movie.setReleaseDate(StringToDate.stringToDate(json.getString("Released")));
            movie.setRuntime(json.getString("Runtime"));
            movie.setActors(StringToArraylist.stringToArraylist(json.getString("Actors")));
            movie.setDirectors(StringToArraylist.stringToArraylist(json.getString("Director")));
            movie.setGenres(StringToArraylist.stringToArraylist(json.getString("Genre")));
            movie.setImg(UrlToImgUtil.urlToImage(json.getString("Poster")));
            movie.setMetascore(json.getInt("Metascore"));
            movie.setImdbRating(json.getDouble("imdbRating"));
        }
        return movie;
    }


}
