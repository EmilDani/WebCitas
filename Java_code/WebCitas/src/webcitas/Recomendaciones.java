package webcitas;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.List;


@WebServlet("/sugerencias")

public class Recomendaciones extends HttpServlet{
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
    	
    	System.out.println("\n [Recomendaciones]:\n");

	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("usuario");
	

	if (user==null){
	    response.sendRedirect("error-login.html");
	} else {
	    try (DBManager manager = new DBManager()){
		List<User> usuarios= manager.listRecommendedUsers(user);
		
		boolean fecha_error;
		if (request.getAttribute("fecha_error") != null)
			fecha_error = (boolean) request.getAttribute("fecha_error");
		else 
			fecha_error = false;
		System.out.println(" fecha_error: "+fecha_error);
		
		boolean recomendaciones_error = false;
		if (usuarios == null){
			recomendaciones_error = true;
		} else {
			request.setAttribute("listaUsuarios",usuarios);
		}
		
		request.setAttribute("recomendaciones_error",recomendaciones_error);
		request.setAttribute("fecha_error", fecha_error);
		request.getRequestDispatcher("recomendaciones.jsp").forward(request, response);

	    } catch (SQLException | NamingException e) {

		PrintWriter out = response.getWriter();
		out.println("ERROR "+ e);
		e.printStackTrace();

	    }

	}

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {



    }

}
