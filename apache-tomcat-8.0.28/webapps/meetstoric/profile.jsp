<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="webcitas.*"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="javax.naming.NamingException"%>

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
			<div class="col-md-4 col-md-offset-4">
			
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

</body>
</html>
