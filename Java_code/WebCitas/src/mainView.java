
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;

@WebServlet("/mainView")

public class mainView extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{  	
		try {
			DBManager manager = new DBManager();
			//	    List<Book> books = manager.listBooks();
			//	    request.setAttribute("libros", books);
			//	    RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
			//	    rd.forward(request, response);
			//  for (Book libro: books) {
			//    System.out.println(libro);
			//}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}	

}