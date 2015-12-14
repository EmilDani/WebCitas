
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="webcitas.*"%>
<%@ page import='java.util.List'%>
<%@ page import='java.util.ArrayList'%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.*"%>

<%User user = (User) session.getAttribute("usuario"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Elección de citas</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>

	<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
	<div id="top_bar" class="top_bar" style="position: relative; top: 0px;">

		<div class="container" style="float: left; width: 50%; overflow: hidden; height: 44px">

			<a href="/meetstoric/mainView" class="top_bottom" title="mainView">Inicio</a>
			<a href="/meetstoric/citas" class="top_bottom" title="Citas">Citas</a>
			<a href="/meetstoric/sugerencias" class="top_bottom"
				title="Recomendaciones">Sugerencias</a>

		</div>

		<div class="container"
			style="float: right; width: 200px; overflow: hidden; height: 44px;">

			<a href="/meetstoric/cierreSesion" class="top_bottom" onclick=""
				title="Cerrar Sesión">Cerrar Sesión</a> <a
				href="<%=response.encodeURL("profile?id=" + user.getId())%>"
				class="top_bottom" onclick="" title="Mi perfil">Mi Perfil</a>

		</div>

	</div>
	</header>
	
	<div class="container">

	<h1>Usuarios recomendados para ti:</h1>
	
	<div class="row">
	
	<h1> </h1>
	
	</div>

	<%
		boolean recomendados_error = (boolean) request.getAttribute("recomendaciones_error");
		if (recomendados_error) {
		%>

	<h4>No hay usuarios recomendados para ti. Tu horrorífica persona
		ha vencido a nuestro poderoso algoritmo.</h4>

	<%} else { %>

	<%  
		boolean fecha_error = (boolean) request.getAttribute("fecha_error"); // ESTO NO ESTÁ BIEN
		if (fecha_error) {
		%>

	<h4>EH! Pon una fecha bien Marty Macfly. Recuerda que no
		reservamos con más de 14 días de antelación</h4>

	<%}%>

	<%
		
		List<User> listaUsuarios = (List<User>) request.getAttribute("listaUsuarios");
		Date hoy = new java.util.Date();
	    Calendar calendario = Calendar.getInstance();
	    calendario.setTime(hoy);
	    calendario.add(Calendar.DAY_OF_YEAR, 14);  // Sumamos los días
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		%>

	<%-- HAY QUE COMPROBAR SI HA HABIDO O NO UN ERROR --%>
	

	
	

	<table>
		<thead>
			<tr class="row">
				<td class="col-md-1" style="font-size: 20px; color: green;">NickName</td>
				<td class="col-md-1" style="font-size: 20px; color: green;">Año de nacimiento</td>
				<td class="col-md-1" style="font-size: 20px; color: green;">Interesado/a en</td>
				<td class="col-md-1" style="font-size: 20px; color: green;">Edad Máxima</td>
				<td class="col-md-1" style="font-size: 20px; color: green;">Edad Mínima</td>
				<td class="col-md-1"></td>
				<td class="col-md-1" style="font-size: 20px; color: green;">Elija una fecha para
					su cita</td>
			</tr>
		</thead>
		
			<div class="row">
	
	<p> </p>
	
	</div>
			<%
				for (User usuario: listaUsuarios) {

				%>
		<tr class="row">
			<td class="col-md-1"><a href="<%=response.encodeURL("profile?id=" + usuario.getId())%>"><%= usuario.getNickname()%></td>
			<td class="col-md-1"><%= usuario.getYear()%></td>
			<td class="col-md-1"><%= usuario.getDesired_sex()%></td>
			<td class="col-md-1"><%= usuario.getDesired_year_max()%></td>
			<td class="col-md-1"><%= usuario.getDesired_year_min()%></td>
			<td class="col-md-1"><form class="form-group" action="citar" method="get"></td>
			<td class="col-md-1"><input type="date" name="fecha" min="<%= df.format(hoy)%>"
				max="<%=df.format(calendario.getTime())%>"><!-- class="form-control" -->
			<td><input type="hidden" name="recId"
				value="<%=usuario.getId() %>"> <input class="btn btn-success" type="submit"
				value="Pedir Cita" style="font-size: 14px; color: blue;"></td>
			</form>
		</tr>
		<% } %>
	</table>
	
	<%} %>
	</div>
	
	
</body>
</html>