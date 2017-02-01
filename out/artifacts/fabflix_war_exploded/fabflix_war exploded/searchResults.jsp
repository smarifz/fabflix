
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


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
<%--<table>--%>
    <%--<c:forEach items="${movies}" var="movie">--%>
        <%--<tr>--%>
            <%--<c:out value="${movie.title}"></c:out> <br>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<%--<table>--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th>Title</th>--%>
        <%--<th>Year</th>--%>
        <%--<th>Director</th>--%>
        <%--<th>First Name</th>--%>
        <%--<th>Last Name</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<c:forEach  begin="0" end="100" items="${movies}" var="movie">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${movie.title}"></c:out></td>--%>
            <%--<td><c:out value="${movie.year}"></c:out></td>--%>
            <%--<td><c:out value="${movie.director}"></c:out></td>--%>
            <%--<td><c:out value="${movie.first_name}"></c:out></td>--%>
            <%--<td><c:out value="${movie.last_name}"></c:out></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>


<display:table name="movies" sort="external" defaultsort="1" id="element">
    <display:column property="title" title="title" sortable="true" />
    <display:column property="year" sortable="true"  title="year" />
    <display:column property="director" sortable="true" title="director" />
    <display:column property="first_name" sortable="true" title="first name"/>
    <display:column property="last_name" sortable="true" title="last name"/>
</display:table>


<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>