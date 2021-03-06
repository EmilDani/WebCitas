package bookshop2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.List;
import	bookshop2.Book;
import	bookshop2.DBManager;
import java.util.ArrayList;


@WebServlet("/carro")
public class mostrarCarro extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
    {		  
	try {
	    DBManager manager = new DBManager();
	    List<Book> books = manager.listBooks();
	    request.getAttribute("listaCarro");
	    RequestDispatcher rd = request.getRequestDispatcher("carro.jsp");
	    rd.forward(request, response);
	    //  for (Book libro: books) {
	    //    System.out.println(libro);
	    //}
	} catch (SQLException | NamingException e) {
	    e.printStackTrace();
	}
    }
}

