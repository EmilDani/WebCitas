<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="webcitas.*" %>
<%@ page import='java.util.List' %>
<%@ page import='java.util.ArrayList' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Elección de citas</title>
	</head>
	<body>
		<%  List<User> listaUsuarios= (List<User>) session.getAttribute("listaUsuarios"); %>
		<p>Usuarios cercanos a tu localización:</p>
		<table>
			<thead>
				<tr>
					<td style="font-size:20px; color:green; ">NickName</td>
					<td style="font-size:20px; color:green; ">Año de nacimiento</td>
					<td style="font-size:20px; color:green; ">Interesado/a en</td>
					<td style="font-size:20px; color:green; ">Edad Máxima</td>
					<td style="font-size:20px; color:green; ">Edad Mínima</td>
					<td style="font-size:20px; color:green; ">Elija una fecha para su cita</td>
				</tr>
			</thead>
			<tr>
				<%
				for (User usuario: listaUsuarios) {

				%>
				<td><%= usuario.getNickname()%></td>
				<td><%= usuario.getYear()%></td>
				<td><%= usuario.getDesired_sex()%></td>
				<td><%= usuario.getDesired_year_max()%></td>
				<td><%= usuario.getDesired_year_min()%></td>
				<td><form action="citar" method="get"> </td>
				<td><input type="date" name="fecha"><td>
				  <td><input type="hidden" name="recId" value="<%=usuario.getId() %>">							  	 	       			    <input type="submit" value="Pedir Cita" style=font-size:14px;color:blue; ></td>
				</form></td>
			</tr>
		  <% } %>
		</table>

	</body>
</html>