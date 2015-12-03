<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="webcitas.*" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.NamingException" %>

<% User perfil = (User) request.getAttribute("usuario");%>



<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=perfil.getNickname() %></title>
</head>
<body>

</body>
</html>
