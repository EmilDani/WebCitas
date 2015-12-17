<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- errorPage="error-jsp.html" --%>
<%@ page import='java.util.*'%>
<%@ page import='webcitas.*'%>

<%User user = (User) session.getAttribute("usuario"); %>

<!doctype html>
<html>
<head>
<title>Citas</title>
<meta charset="utf-8" />

<link rel="stylesheet" href="base_style.css" typ="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

</head>

<body class="body_back">

<%@ include file="/navigation_top_bar.jsp" %>

	<%-- User usuario = (User) session.getAttribute("usuario"); --%>
	<%
		boolean errorCProp = (boolean) request.getAttribute("errorCProp");
		boolean errorCRec = (boolean) request.getAttribute("errorCRec");
		%>
		
		<main>
		
		<div class="container-fluid"> 
		
			<div class="container jumbotron ">
	
	<header class="page-header">

	<h1 align="center">Citas</h1>
	
	</header>
	
	<div class="row jumbotron jumbotron_even">
	
	<div class="col-md-6">
	
	<h2>Pendientes de respuesta</h2>
	<%
		if (errorCProp) {
		%>

	<h4>No has propuesto ninguna cita, anímate!</h4>

	<%
		} else {
			List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
		%>

	<table>
		<tbody>
			<% 
			for (DinnerDate cita: citasProp) {
				if (cita.getState() == meetState.PROPUESTA) {
			%>
			<tr>
				<td><img class="img-rounded cita_pic" src="<%= cita.getReceiver().getImgURL()%>"></td>
				<%--= cita.getProposer().getProfileURL()--%>
				<td><a
					href="<%=response.encodeURL("profile?id="+cita.getReceiver().getId()) %>"><%= cita.getReceiver().getNickname() %></a></td>
				<td><%= cita.getProposal_sello()%></td>
				<td><%= cita.getFecha()%></td>
			</tr>
			<% 
				}
			} 
			%>
		</tbody>
	</table>

	<% } %>
	
	</div>
	
	<div class="col-md-6">

	<h2>Propuestas para ti</h2>

	<%
		if (errorCRec) {
		%>

	<h4>No te han propuesto ninguna cita. Aún =)</h4>

	<%
		} else {
			List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
		%>

	<table>
		<tbody>
			<%
				for (DinnerDate cita : citasRec) {
						if (cita.getState() == meetState.PROPUESTA) {
			%>
			<tr>
				<td><img class="img-rounded cita_pic" src="<%=cita.getProposer().getImgURL()%>"></td>
				<%--= cita.getProposer().getProfileURL()--%>
				<td><a
					href="<%=response.encodeURL("profile?id=" + cita.getProposer().getId())%>"><%=cita.getProposer().getNickname()%></a></td>
				<!-- <td><%=cita.getProposal_sello()%></td> -->
				<td><%=cita.getFecha()%></td>
				<td><form action="citar" method="get">
						<input type="hidden" name="citaID" value="<%=cita.getId()%>">
						<input class="btn success_button" type="submit" name="cita_estado" value="Aceptar"> <input
							class="btn fail_button" type="submit" name="cita_estado" value="Rechazar">
						<!-- </td> -->
						<!-- <td><input type="date" name="fecha"> -->
						<!-- <input type="submit" name="cita_estado" value="No puedo"> -->
						<input class="btn btn-default" type="submit" name="cita_estado" value="Otro día">
					</form></td>
			</tr>
			<%
					}
				}
			%>
		</tbody>
	</table>

	<% } %>
	
	</div>
	</div>
	
	<div class="row jumbotron jumbotron_even">
	
	<div class="col-md-6">

	<h2>Recordatorio
	<small>Citas en el Restaurante</small></h2>

	<%
		if (errorCRec && errorCProp) {
			
		%>

	<h4>No tienes ninguna cita en el Restaurante</h4>

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
						if (cita.getState() == meetState.CONFIRMADA) {
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
			</tr>
			<%
					}
				}
			%>
		</tbody>
	</table>

	<% } %>
	
	</div>
	
	<div class="col-md-6">

	<h2>Respondidas</h2>

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
						if (cita.getState() != meetState.CONFIRMADA && cita.getState() != meetState.PROPUESTA) {
							String icon;
							if (cita.getState() == meetState.OTRO_DIA)
								icon = "glyphicon glyphicon-calendar";
							else
								icon = "glyphicon glyphicon-remove-circle";
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
	
	</div>
	</div>
	</div>


</body>
</html>