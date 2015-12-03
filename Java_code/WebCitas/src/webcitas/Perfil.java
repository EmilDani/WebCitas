package webcitas;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile")

public class Perfil extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("usuario");

		if (user==null){
			response.sendRedirect("error-login.html");
		} else {
			try (DBManager manager = new DBManager()){
				
				// Mejor mandar el manager por session?
				String id = request.getParameter("id");
				User perfil = manager.searchId(Integer.parseInt(id));
				
				request.setAttribute("perfil", perfil);

				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				System.out.println("\n Redirección a profile.jsp\n");
				rd.forward(request, response);

			} catch (SQLException | NamingException e) {

				PrintWriter out = response.getWriter();
				out.println("ERROR"+ e);
				e.printStackTrace();

			}

		}

	}


}
