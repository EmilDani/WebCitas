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

	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("usuario");

	if (user==null){
	    response.sendRedirect("error-login.html");
	} else {
	    try (DBManager manager = new DBManager()){
		List<User> usuarios= manager.listRecommendedUsers(user);
		if (usuarios == null)
		session.setAttribute("listaUsuarios",usuarios);


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
