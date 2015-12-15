
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<body class="body_back">

<%@ include file="/navigation_top_bar.jsp" %>

<div class="main_web">

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
	
	</div>
</body>
</html>
