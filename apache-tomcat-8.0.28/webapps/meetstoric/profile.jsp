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
