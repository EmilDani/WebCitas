<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="webcitas.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.SQLException"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.*"%>
<%
	User user = (User) session.getAttribute("usuario");
	User perfil = (User) request.getAttribute("perfil");
%>



<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title><%=perfil.getNickname()%></title>

<link rel="stylesheet" href="base_style.css" typ="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="megusta.js" type="text/javascript"></script>
	<script type="text/javascript" lang="JavaScript">
	function pulsarMeGusta() {

		var usuario = document.getElementById("gustaUsuario");
		//if(usuario.value==pefil.getId())
			alert("Ahora este usuario te gusta.");

	}
</script>
</head>
<body class="body_back">

	<%@ include file="/navigation_top_bar.jsp"%>

	<main id="presentation" class="container-fluid jumbotron" style="background-image: url(<%=perfil.getProfileURL() %>) !important;"> <header
		class="page-header">

		<div class="info_perfil">
		
		<h1 align="center"><span id="nombre_perfil"><%=perfil.getNickname()%></span></h1>

			<div class="foto_perfil" align="center">

 				<img alt="Foto de Perfil" class="img-circle"
					src="<%=perfil.getImgURL()%>">
					<!-- <img alt="Foto de Perfil" class="img-circle"
					src="http://media-2.web.britannica.com/eb-media/58/129958-004-C9B8B89D.jpg">  -->

			</div>
			
			<div class="row">
			
			<div class="col-md-4">
			
			<h2>Fecha de nacimiento</h2>

			<span id="year_perfil" class=""><%=perfil.getYear()%></span> 
			</div>
			
			<div class="col-md-4">
			
				<div class="container">
				
				<div class="row" id="mg_extra_row">
				
				<div class="col-md-4"></div>
				
				
				</div>
			
				<div align="center">
			
				
				
				<% 
				Like like=(Like)request.getAttribute("tieneLike");
				//boolean meGustaParaSiempre=(boolean)request.getAttribute("meGustaParaSiempre");
				String heart ;
				if(user.getId()!=perfil.getId()){
					//System.out.println("dfadsgfasdgasdgasdgasdgasdga"+meGustaParaSiempre);
					if (like.getIdMG() == 0){
					//like.toggleHeart();
				%>
				
				<form action="megusta" onsubmit="return pulsarMeGusta();">
				<input type="hidden" name="recId" value="<%=perfil.getId()%>">
				<button class="btn btn-danger" id="mg_button" type="submit" name="gustar" id="gustaUsuario" value="<%=perfil.getId() %>"><i class=" glyphicon glyphicon-heart" id="corazon"></i></button> <!-- Hay que añadir que con JavaScript se rellene el botón -->
				
						
					<%--  <% heart = "glyphicon glyphicon-heart-empty"; %> --%>
				<%}else{%>
				
					<p>Este usuario te gusta</p>
					<!-- heart = "glyphicon glyphicon-heart";%> -->
				<% }%>
					
				
				<%} %>
					
					
				
				</form>
				
				</div>
				</div>			
			</div>
			
			<div class="col-md-4">
			
			<%
			String icon_perf_sex;
			if(perfil.getSex() == sex.FEMALE)
				icon_perf_sex = "fa fa-female";
			else
				icon_perf_sex = "fa fa-male";
				%>
			
			<h2>Sexo</h2>
			<span id="sexo_perfil" class=""><%--=perfil.getSex()--%><i class="<%=icon_perf_sex %>"></i></span>
				</div>
			</div>

		</div>

	</header> </main>

	<div id="texto_presentation_container" class="container jumbotron jumbotron_even">
		<h3>Descripción:</h3>
		<span id="texto_presentation"><%=perfil.getDtext()%></span>
	</div>

	<div id="gustos_container" class="container jumbotron jumbotron_even">

		<div class="row">
			<div class="col-sm-4">
				<h3>Año de nacimiento mínimo:</h3>
				<span id="min_year"><%=perfil.getDesired_year_min()%></span>
			</div>
			<div class="col-sm-4">
			
				<%
			String icon_des_sex;
			if(perfil.getDesired_sex() == sex.FEMALE)
				icon_des_sex = "fa fa-female";
			else
				icon_des_sex = "fa fa-male";
				%>
			
				<h3>Interesado en:</h3>
				<span id="gusto_sexo"><%--=perfil.getDesired_sex()--%><i class="<%=icon_des_sex %>"></i></span>
			</div>
			<div class="col-sm-4">
				<h3>Año de nacimiento máximo:</h3>
				<span id="max_year"><%=perfil.getDesired_year_max()%></span>
			</div>
		</div>
	</div>
	
	<%if(user.getId()!=perfil.getId()){ %>
	<div id="texto_presentation_container" class="container jumbotron jumbotron_even">
		
		<h3>Pedir Cita:</h3>
		<%
				Date hoy = new java.util.Date();
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(hoy);
				calendario.add(Calendar.DAY_OF_YEAR, 14); // Sumamos los días
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		%>
		
		
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
			
				<tr class="row">
					<td class="col-md-1"><a
						href="<%=response.encodeURL("profile?id=" + perfil.getId())%>"><%=perfil.getNickname()%></a></td>
					<td class="col-md-1"><%=perfil.getYear()%></td>
					<td class="col-md-1"><%=perfil.getDesired_sex()%></td>
					<td class="col-md-1"><%=perfil.getDesired_year_max()%></td>
					<td class="col-md-1"><%=perfil.getDesired_year_min()%></td>
					<td class="col-md-1">
					<form class="form-group" action="citar" method="get"></td>
					<td class="col-md-1">
						
						<input type="hidden" name="recId"
						value="<%=perfil.getId()%>">
					<input class="input-group" type="date" name="fecha"
						min="<%=df.format(hoy)%>"
						max="<%=df.format(calendario.getTime())%>">
						</td>
					<!-- class="form-control" -->
					<td class="col-md-1"><input class="btn success_button" type="submit" value="Pedir Cita"
						style="font-size: 14px;"></form>
					</td>

				</tr>

		</table>
	</div>
	<%} %>
</body>
</html>
