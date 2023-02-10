<%-- 
    Document   : login
    Created on : Feb 9, 2023, 6:30:13 PM
    Author     : radia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1><b>Login</b></h1>
        <form method="post">
            Username: <input type="text" name="username" id="username" value="${user}"/>
            Password: <input type="text" name="password" id="password" value="${pass}"/>
            <p>${message}</p>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
