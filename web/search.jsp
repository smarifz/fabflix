<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<%
    //allow access only if session exists
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login.jsp");
    }
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("fabflix"))
                userName = cookie.getValue();
        }
    }
%>
<h3>Search</h3>
<br>

<form name="searchMovie" action="/search" method="post">
    <table border="0" width="300" align="center" bgcolor="">
        <tr>
            <td colspan=2 style="font-size:12pt;" align="center">
                <h3>Search For Movie</h3></td>
        </tr>
        <tr>
            <td><b>Title:</b></td>
            <td>:
                <input type="text" name="title" id="title">
            </td>
        </tr>
        <tr>
            <td><b>Year:</b></td>
            <td>:
                <input type="text" name="year" id="year">
            </td>
        </tr>
        <tr>
            <td><b>Director:</b></td>
            <td>:
                <input type="text" name="director" id="director">
            </td>
        </tr>
        <tr>
            <td><b>First Name:</b></td>
            <td>:
                <input type="text" name="fname" id="fname">
            </td>
        </tr>
        <tr>
            <td><b>Last Name:</b></td>
            <td>:
                <input type="text" name="lname" id="lname">
            </td>
        </tr>
        <tr>
            <td colspan=2 align="center">
                <input type="submit" name="submit" value="Search"></td>
        </tr>
    </table>
</form>


<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>