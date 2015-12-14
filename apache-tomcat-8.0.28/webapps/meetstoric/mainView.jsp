
<%@ page language="java" contentType="text/html; charset=utf-8"
	errorPage="error-login"%>
<%@ page import='java.util.*'%>
<%@ page import='webcitas.*'%>


<% User user = (User) session.getAttribute("usuario"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="base_style.css" typ="text/css">
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

	<div>
		<header id="header style="background-image:url(https://cdn.comuniame.com/img/header.jpg)">
		<div id="logo">
			<a href="/"> <img
				src="http://www.euroresidentes.com/corazones/imagenes/corazones1.png">
			</a>
		</div>
		</header>



	</div>


	<p style="font-weight: bold; font-size: 20px;">
		Hola,
		<%= user.getNickname()%>
	</p>

	<p style="font-size: 10px;">Estos son tus datos:</p>
	<p style="font-size: 10px;">
		Descripcion:
		<%=user.getDtext()%>
	</p>
	<p style="font-size: 10px;">
		Sexo:
		<%=user.getSex()%>
	</p>
	<p style="font-size: 10px;">
		Año de Nacimiento:
		<%=user.getYear()%>
	</p>
	<p style="font-size: 10px;">
		Interesado en:
		<%=user.getDesired_sex()%>
	</p>
	<p style="font-size: 10px;">
		Rango de edad máximo:
		<%=user.getDesired_year_max()%>
	</p>
	<p style="font-size: 10px;">
		Rango de edad mínimo:
		<%=user.getDesired_year_min()%>
	</p>
	<!-- <p>
	<form action="sugerencias" method="get">
		<td><input type="submit" value="Recomendaciones"
			style="font-size: 14px; color: blue;"></td>
	</form>
	</p> -->
</body>
</html>
