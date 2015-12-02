<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error-login"%>
<%@ page import='java.util.*'%>
<%@ page import='webcitas.*'%>

<!doctype html>
<html>
	<head>
		<title>Citas</title>
		<meta charset="utf-8" />
	</head>
	<body>

		<%-- User usuario = (User) session.getAttribute("usuario"); --%>
		<% List<DinnerDate> citas = (List<DinnerDate>) session.getAttribute("citas"); %>

		<h1>Citas</h1>

		<h2>Propuestas para ti</h2>

		<table><tbody>
			<% for(DinnerDate cita : citas) { %>
			<tr>
				<td><img src="<%= cita.getProposer().getImgURL() %>"></td>
				<td><a href="<%= cita.getProposer().getProfileURL() %>"><%= cita.getProposer().getNickname() %></a></td>
				<td><%= cita.getProposal_sello()  %></td>
				<td><%= cita.getFecha() %></td>
				<td><form action="citar" method="get"><input type="submit" value="Aceptar"><form></td>
			</tr>
			<% } %>
		</tbody></table>
		
		<h2>Pendientas de respuesta</h2>

		

	</body>
</html>