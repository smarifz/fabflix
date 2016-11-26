<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Movie List</title>
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
<h3>Browse - Movie List</h3>
<br>

<br><br>


<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Director</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td><c:out value="${movie.id}"></c:out></td>
            <td><c:out value="${movie.title}"></c:out></td>
            <td><c:out value="${movie.year}"></c:out></td>
            <td><c:out value="${movie.director}"></c:out></td>
            <td><c:out value="${movie.first_name}"></c:out></td>
            <td><c:out value="${movie.last_name}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>