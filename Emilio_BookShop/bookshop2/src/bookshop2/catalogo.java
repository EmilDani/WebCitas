package bookshop2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.List;
import bookshop2.Book;
import bookshop2.DBManager;  /** Crear un paquete que se llame bookshop y dentro metemos DBManager Book y Bookshop **/

/**
 * Servlet que simplemente muestra un mensaje
 * de Â¡Hola Mundo!
 *
 */
@WebServlet("/catalogo")
public class catalogo extends HttpServlet {
	
	
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
    {
    	//response.sendRedirect(response.encodeRedirectURL("./TablaVotos.jsp"));
    	try {
	    DBManager manager = new DBManager();
	    List<Book> books = manager.listBooks();
	    request.setAttribute("libros", books);
	    RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
	    rd.forward(request, response);
	    //  for (Book libro: books) {
	    //    System.out.println(libro);
	    //}
	} catch (SQLException | NamingException e) {
	    e.printStackTrace();
	}
    	
    	//request.setAttribute(nombreLista);
    	//hacer: crear un objaeto db manager para pillar la lista de objetos de la base de datos. 
    	//Con ese objetto temdriamos que hacer un request.setatribute(con el nombre que queramos de la lista)
    	//y hay que meterle algo....en el jsp el get.attribute para conseguir los datos
     
        // establece ContentType y sistema de codificación de caracteres
    }
}
