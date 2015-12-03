<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="webcitas.*" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.NamingException" %>

<%-- User usuario = (User) session.getAttribute("usuario"); --%>
<%

try (DBManager manager = new DBManager()){
	String id = request.getParameter("id");
	User perfil = manager.searchId(Integer.parseInt(id));

} catch (SQLException | NamingException e) {
	
	

}

%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=perfil.getNickname() %></title>
</head>
<body>

</body>
</html>