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

public class vaciarCarro extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		 //Obtenemos la sesion del usuario
    	HttpSession session = request.getSession();
    //creamos un arrayLista llamado carro del que cogemos lo que lleva en listaCarro
    	List<Book> carro =(List<Book>)session.getAttribute("listaCarro");
     //Si el carro esta vacío creamos una arraylist y atribuimos a esa lista el nombre listaCarro
     if (carro == null) {
         carro = new ArrayList<Book>();
         session.setAttribute("listaCarro", carro);
     }
    
    try(DBManager manager= new DBManager()){
    
   
	PrintWriter out = response.getWriter();
    //Array de tipo string con todos los ISBN de los libros     
	String[] values=request.getParameterValues("libros");
        //creamos una lista nueva donde vamos añadiendo esos libros en el caso de que haya 
         List<Book> list = new ArrayList<Book>();
	
        if (values != null) {    
   
        for(int i=0;i<values.length;i++){
	    
          list.remove(manager.searchBook(values[i]));
       }
       }
     //Añadimos esa lista a la cariable listaCarro
        request.setAttribute("listaCarro", list);
   // RequestDispatcher rd = request.getRequestDispatcher("carro.jsp");
   // rd.forward(request, response);
 
    response.sendRedirect(response.encodeRedirectURL("./catalogo"));

     
    } catch (SQLException | NamingException e) {
    PrintWriter out = response.getWriter();
    out.println("ERROR");
            e.printStackTrace();
    }


		    }
}
