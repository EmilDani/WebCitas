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
		<%
		boolean errorCProp = (boolean) request.getAttribute("errorCProp");
		boolean errorCRec = (boolean) request.getAttribute("errorCRec");
		%>

		<h1>Citas</h1>

		<h2>Pendientes de respuesta</h2>
		<%
		if (errorCProp) {
		%>
		
		<h3>No tienes ninguna cita</h3>

		<%
		} else {
			List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
		%>
		
		<table><tbody>
			<% for (DinnerDate cita: citasProp) { %>
			<tr>
				<td><img src="<%= cita.getReceiver().getImgURL()%>"></td>
				<%--= cita.getProposer().getProfileURL()--%>
				<td><a href="<%=response.encodeURL("profile?id="+cita.getReceiver().getId()) %>"><%= cita.getReceiver().getNickname() %></a></td>
				<td><%= cita.getProposal_sello()%></td>
				<td><%= cita.getFecha()%></td>
			</tr>
			<% } %>
		</tbody></table>

		<% } %>
		
		<h2>Propuestas para ti</h2>

		<%
		if (errorCRec) {
		%>

			<h3>No te han propuesto ninguna cita. Aún =)</h3>

		<%
		} else {
			List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
		%>

		<table><tbody>
			<% for (DinnerDate cita: citasRec) { %>
				<tr>
					<td><img src="<%= cita.getProposer().getImgURL()%>"></td>
					<%--= cita.getProposer().getProfileURL()--%>
					<td><a href="<%=response.encodeURL("profile?id="+cita.getProposer().getId()) %>"><%= cita.getProposer().getNickname() %></a></td>
					<!-- <td><%= cita.getProposal_sello()%></td> -->
					<td><%= cita.getFecha()%></td>
					<td><form action="citar" method="get">
					<input type="hidden" name="citaID" value="<%=cita.getId() %>">
					<input type="submit" name="cita_estado" value="Aceptar">
					<input type="submit" name="cita_estado" value="Rechazar"><!-- </td> -->
					<!-- <td><input type="date" name="fecha"> -->
					<!-- <input type="submit" name="cita_estado" value="No puedo"> -->
					<input type="submit" name="cita_estado" value="Otro día"></form></td>
				</tr>
			<% } %>
		</tbody></table>
		
		<% } %>
	</body>
</html>