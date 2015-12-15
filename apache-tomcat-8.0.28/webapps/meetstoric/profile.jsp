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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=perfil.getNickname()%></title>

<link rel="stylesheet" href="base_style.css" typ="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body class="body_back">

<%@ include file="/navigation_top_bar.jsp" %>

	<main id="presentation" class="container">

	<div class="info_perfil">

		<div class="foto_perfil">

			<img alt="Foto de Perfil" class="img-circle" src="<%=perfil.getImgURL() %>">

		</div>

		<span id="nombre_perfil"><%=perfil.getNickname() %></span> 
		
		<span id="year_perfil"><%=perfil.getYear() %></span> 
		
		<span id="sexo_perfil"><%=perfil.getSex() %></span>

	</div>

	</main>

	<div id="texto_presentation_container" class="container">
		<span id="texto_presentation"><%=perfil.getDtext() %></span>
	</div>

	<div id="gustos_container" class="container">

		<div class="row">
			<div class="col-sm-4">
				<h3>Año de nacimiento mínimo:</h3>
				<span id="min_year"><%=perfil.getDesired_year_min()%></span>
			</div>
			<div class="col-sm-4">
				<h3>Interesado en:</h3>
				<span id="gusto_sexo"><%=perfil.getDesired_sex()%></span>
			</div>
			<div class="col-sm-4">
				<h3>Año de nacimiento máximo:</h3>
				<span id="max_year"><%=perfil.getDesired_year_max()%></span>
			</div>
		</div>
	</div>

</body>
</html>
