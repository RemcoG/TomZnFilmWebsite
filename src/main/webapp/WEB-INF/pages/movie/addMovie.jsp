<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <div class="jumbotron">
                <div align="center">
                    <form:form class="form-horizontal" modelAttribute="movieSearch" id="form" method="post">
                        <div class="form-group">
                            <label class="control-label col-sm-2">Title</label>
                            <form:input class="form-control" path="title" />
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Released in:</label>
                            <form:input class="form-control" path="releasedYear" />
                        </div>
                        <form:button value="submit">Submit</form:button>
                    </form:form>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>