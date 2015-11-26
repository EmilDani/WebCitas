
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<% User user = (User) session.getAttribute("usuario") %>

<p style="font-weight: bold; font-size:20px; ">
Hola, <%= user.getNickname(); %>
</p>

<p style="font-size:10px; ">
Estos son tus datos:
</p>
<p style="font-size:10px; ">
Descripcion: <%=user.getDtext(); %>
</p>
<p style="font-size:10px; ">
Sexo: <%=user.getSex(); %>
</p>
<p style="font-size:10px; ">
AÃ±o de Nacimiento: <%=user.getYear();%>
</p>
<p style="font-size:10px; ">
Interesado en: <%=user.getDesired_sex();%>
</p>
<p style="font-size:10px; ">
Rango de edad máximo: <%=user.getDesired_year_max();%>
</p>
<p style="font-size:10px; ">
Rango de edad mínimo: <%=user.getDesired_year_min();%>
</p>

</body>
</html>
