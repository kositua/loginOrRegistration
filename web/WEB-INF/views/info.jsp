<%-- 
    Document   : info
    Created on : Jun 8, 2016, 9:18:05 PM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info</title>
    </head>
    <body>
        <h1>Hello ${username}!</h1>
        <h1>Your's session info:</h1>
        <h1>Your last visit started at: ${sessiontime}, and it was your ${countvisits} visit!</h1>
        <a href="logout">logout</a>
    </body>
</html>
