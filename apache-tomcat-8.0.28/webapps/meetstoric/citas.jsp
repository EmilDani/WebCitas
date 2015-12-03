<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%-- errorPage="error-jsp.html" --%>
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
		<% List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("listaCitasPropuestas"); %>

		<h1>Citas</h1>

		<h2>Propuestas para ti</h2>

		<table><tbody>
			<% for (DinnerDate cita: citasProp) { %>
			<tr>
				<td><img src="<%= cita.getProposer().getImgURL()%>"></td>
				<%--= cita.getProposer().getProfileURL()--%>
				<td><a href="<%=response.encodeURL("profile?id="+cita.getProposer().getId()) %>"><%= cita.getProposer().getNickname() %></a></td>
				<td><%= cita.getProposal_sello()%></td>
				<td><%= cita.getFecha()%></td>
				<td><form action="citar" method="get"><input type="submit" value="Aceptar"></form></td>
			</tr>
			<% } %>
		</tbody></table>
		
		<h2>Pendientes de respuesta</h2>

		

	</body>
</html>