
<%@ page language="java" contentType="text/html; charset=UTF-8"
	errorPage="error-jsp.html"%>
<%@ page import='java.util.*'%>
<%@ page import='webcitas.*'%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.*"%>


<% 
User user = (User) session.getAttribute("usuario");
List<User> amantes = (List<User>) session.getAttribute("amantes");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="base_style.css" typ="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body class="body_back">

<%@ include file="/navigation_top_bar.jsp" %>
	
	<main class="container-fluid jumbotron" id="main1">
	<header class="page-header">

	<!-- <p style="font-weight: bold; font-size: 20px;"> -->
	<h1 id="nombre_perfil" align="center">
		Bienvenido,
		<%= user.getNickname()%>
	</h1>
	
	</header>
	</main>
	
	<div class="main_web">
	
	<div class="container-fluid jumbotron" id="main2">
	
			<div class="row">
			
			<div class="col-md-4 col-md-offset-1 container jumbotron" id="main_citas">
			
			<h3>Estado de las Citas</h3>
			
			<%
		boolean errorCProp = (boolean) request.getAttribute("errorCProp");
		boolean errorCRec = (boolean) request.getAttribute("errorCRec");
		%>
			
				<%
		if (errorCRec && errorCProp) {
			
		%>

	<h4>No han respondido a ninguna de tus citas, pero tampoco tú has
		respondido a ninguna... Ojo por ojo y diente por diente</h4>

	<%
		} else {
			
			List<DinnerDate> citas;
			
			if (errorCRec){
				
				List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
				citas = new ArrayList<DinnerDate>(citasProp);
				
			}else if (errorCProp){
				
				List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
				citas = new ArrayList<DinnerDate>(citasRec);
				
			} else {
				
				List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
				List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
				citas = new ArrayList<DinnerDate>(citasProp);
				citas.addAll(citasRec);
				
			}
		%>

	<table>
		<tbody>
			<%
				for (DinnerDate cita : citas) {
						if (cita.getState() != meetState.PROPUESTA) {
							String icon = "";
							if (cita.getState() == meetState.OTRO_DIA)
								icon = "glyphicon glyphicon-calendar";
							else if (cita.getState() == meetState.RECHAZADA)
								icon = "glyphicon glyphicon-remove-circle";
							else if (cita.getState() == meetState.CONFIRMADA)
								icon = "glyphicon glyphicon-ok-circle";
			%>
			<tr>
				<td><img class="img-rounded cita_pic" src="<%=cita.getProposer().getImgURL()%>"></td>
				<%-- = cita.getProposer().getProfileURL() --%>
				<td><a
					href="<%=response.encodeURL("profile?id=" + cita.getProposer().getId())%>"><%=cita.getProposer().getNickname()%></a></td>
				<!-- <td><%=cita.getProposal_sello()%></td> -->
				<td>-</td>
				<td><img class="img-rounded cita_pic" src="<%=cita.getReceiver().getImgURL()%>"></td>
				<%-- = cita.getProposer().getProfileURL() --%>
				<td><a
					href="<%=response.encodeURL("profile?id=" + cita.getReceiver().getId())%>"><%=cita.getReceiver().getNickname()%></a></td>
				<td><%=cita.getFecha()%></td>
				<td> <%--=cita.getState()--%> <span class="<%=icon %>"></span></td>
			</tr>
			<%
					}
				}
			%>
		</tbody>
	</table>

	<% } %>

			</div>
			<div class="col-md-4 col-md-offset-2 container jumbotron" id="main_me_gusta">

			<%
			
			for (User amante : amantes){
				%>
				
				<tr class="row">
					<td class="col-md-1"><a
						href="<%=response.encodeURL("profile?id=" + amante.getId())%>"><%=amante.getNickname()%></a></td>
					<td class="col-md-1"><%=amante.getYear()%></td>

				</tr>

			<%
				}
			%>
			
			<h3>Notificaciones de "Me gusta"</h3>
			
				</div>
			</div>
	</div>
	
	<div class="container-fluid jumbotron" id="main3">
	
			<div class="container jumbotron table-responsive" id="main_sugerencias">
			
			<h3>Sugerencias</h3>
		
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
	
	</div>
</body>
</html>
