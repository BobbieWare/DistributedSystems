<%-- 
    Document   : jsp4
    Created on : Apr 17, 2019, 2:24:26 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>    
    <head>
        <title>New Post</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <h1>New Post</h1>
            <div>
                <form name="postStatus" action="PostService" method="POST">
                    <label>Title: </label><input type="text" name="title" size="20" /><br>

                    <label>Content: </label><input type="text" name="text" value="200" /><br>

                    Share: <label><input type="radio" name="share" value="Public" checked="checked"/> Public</label>
                    <label><input type="radio" name="share" value="Friends" /> Friends</label>
                    <label><input type="radio" name="share" value="Only Me" /> Only Me</label><br>

                    <!-- The php function is used to fill the date with the current date. -->
                    <label>Date: </label><input type="date" name="date" value="<?php echo date('Y-m-d'); ?>" /><br>

                    Permission Type: <label><input type="checkbox" name="likeable" value="ON" /> Allow Like</label>
                    <label><input type="checkbox" name="commentable" value="ON" /> Allow Comment</label>
                    <label><input type="checkbox" name="shareable" value="ON" /> Allow Share</label><br>

                    <input type="submit" value="Post" name="post" />  <input type="reset" value="Reset" name="reset" /><br>

                    <button onclick="location.href = 'index.html'" type="button">Return to Home Page</button>
                </form>
            </div>
        </div>
    </body>
</html>