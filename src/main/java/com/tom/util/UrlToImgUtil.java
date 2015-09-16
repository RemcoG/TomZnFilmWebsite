package com.tom.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by Tom on 9-9-2015.
 */
public class UrlToImgUtil {

    public static BufferedImage urlToImage(String url){
        try {
            URL urlImage = new URL(url);
            BufferedImage image = ImageIO.read(urlImage);
            return image;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
