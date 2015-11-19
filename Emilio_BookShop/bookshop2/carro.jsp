<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import='bookshop2.Book' %>
<%@ page import='bookshop2.DBManager' %>
<%@ page import='java.util.List' %>
<%@ page import='java.util.ArrayList;' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carro de la compra</title>
</head>
<body>
<%  List<Book> listaCarro= (List<Book>) session.getAttribute("listaCarro"); %>
<p>Esta es su lista de la compra:</p>
<table>
      <thead>
        <tr>
          <td>Title</td>
          <td>ISBN</td>
          <td>Year</td>
		  <td>Id</td>
        </tr>
      </thead>
      <tr>
<%
for (Book book: listaCarro) {

%>
<td><%= book.getTitle()%></td>
			  <td><%= book.getIsbn()%></td>
			  <td><%= book.getYear()%></td>
			  <td><%= book.getId()%></td>
		  </tr>
		  <% } %>
	    </table>


</body>
</html>