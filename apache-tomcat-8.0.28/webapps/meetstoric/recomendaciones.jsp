
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="webcitas.*"%>
<%@ page import='java.util.List'%>
<%@ page import='java.util.ArrayList'%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.*"%>

<%
	User user = (User) session.getAttribute("usuario");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Elección de citas</title>

<link rel="stylesheet" href="base_style.css" typ="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
</head>
<body class="body_back">

	<%@ include file="/navigation_top_bar.jsp"%>
	
	<div class="container jumbotron semi_back">
	
	<header class="page-header">
	
	<h2 align="center">Usuarios recomendados para ti:</h2>
	
	</header>

	<div class="container jumbotron table-responsive jumbotron_even">

		

		<%
			boolean recomendados_error = (boolean) request.getAttribute("recomendaciones_error");
			if (recomendados_error) {
		%>

		<h4>No hay usuarios recomendados para ti. Tu horrorífica persona
			ha vencido a nuestro poderoso algoritmo.</h4>

		<%
			} else {
		%>

		<%
			boolean fecha_error = (boolean) request.getAttribute("fecha_error"); // ESTO NO ESTÁ BIEN
				if (fecha_error) {
		%>

		<h4>EH! Pon una fecha bien Marty Macfly. Recuerda que no
			reservamos con más de 14 días de antelación</h4>

		<%
			}
		%>

		<%
			List<User> listaUsuarios = (List<User>) request.getAttribute("listaUsuarios");
				Date hoy = new java.util.Date();
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(hoy);
				calendario.add(Calendar.DAY_OF_YEAR, 14); // Sumamos los días
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		%>

		<%-- HAY QUE COMPROBAR SI HA HABIDO O NO UN ERROR --%>

		<table class="table table-striped">
			<thead>
				<tr class="row">
					<th class="col-md-1">NickName</th>
					<th class="col-md-1">Año de nacimiento</th>
					<th class="col-md-1">Interesado/a en</th>
					<th class="col-md-1">Edad Máxima</th>
					<th class="col-md-1">Edad Mínima</th>
					<th class="col-md-1"></th>
					<th class="col-md-1">Elija una fecha para su cita</th>
				</tr>
			</thead>

			<div class="row">

				<p></p>

			</div>
			<%
				for (User usuario : listaUsuarios) {
			%>
				<tr class="row">
					<td class="col-md-1"><a
						href="<%=response.encodeURL("profile?id=" + usuario.getId())%>"><%=usuario.getNickname()%></a></td>
					<td class="col-md-1"><%=usuario.getYear()%></td>
					<td class="col-md-1"><%=usuario.getDesired_sex()%></td>
					<td class="col-md-1"><%=usuario.getDesired_year_max()%></td>
					<td class="col-md-1"><%=usuario.getDesired_year_min()%></td>
					<td class="col-md-1"><form class="form-group" action="citar" method="get"></td>
					<td class="col-md-1">
						
						<input type="hidden" name="recId"
						value="<%=usuario.getId()%>">
					<input class="input-group" type="date" name="fecha"
						min="<%=df.format(hoy)%>"
						max="<%=df.format(calendario.getTime())%>">
						</td>
					<!-- class="form-control" -->
					<td class="col-md-1"><input class="btn success_button" type="submit" value="Pedir Cita"
						style="font-size: 14px;"></form>
					</td>

				</tr>

			<%
				}
			%>
		</table>

		<%
			}
		%>
	</div>
	</div>

</body>
</html>