
package webcitas;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/citas")

public class Citas extends HttpServlet{
    
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("usuario");

		if (user==null){
			response.sendRedirect("error-login.html");
		} else {
			try (DBManager manager = new DBManager()){
//				List<User> usuarios= manager.listRecommendedUsers(user);
//				session.setAttribute("listaUsuarios",usuarios);
				
				boolean errorCProp = false;
				boolean errorCRec = false;
				
				List<DinnerDate> citasProp = manager.listDatesPropOf(user);
				List<DinnerDate> citasRec = manager.listDatesRecOf(user);
				if (citasProp == null) {
					errorCProp = true;
				} if (citasRec == null){
					errorCRec = true;
				} else {
					request.setAttribute("citasProp", citasProp);
					request.setAttribute("citasRec", citasRec);
				}
				request.setAttribute("errorCProp", errorCProp);
				request.setAttribute("errorCRec", errorCRec);
				RequestDispatcher rd = request.getRequestDispatcher("citas.jsp");
				System.out.println("\n Redirección a citas.jsp\n");
				rd.forward(request, response);

			} catch (SQLException | NamingException e) {

				PrintWriter out = response.getWriter();
				out.println("ERROR"+ e);
				e.printStackTrace();

			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {



	}
    
}
