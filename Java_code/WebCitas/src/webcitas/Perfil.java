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
		
		System.out.println("\n [Perfil]:\n");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("usuario");

		if (user==null){
			response.sendRedirect("error-login.html");
		} else {
			try (DBManager manager = new DBManager()){
				
				boolean meGustaParaSiempre=false;
				// Mejor mandar el manager por session?
				String id = request.getParameter("id");
				System.out.println(" id del perfil: "+Integer.parseInt(id));
				User perfil = manager.searchId(Integer.parseInt(id));
				
				request.setAttribute("perfil", perfil);
				System.out.println(" Nombre del perfil: "+perfil.getNickname());

		
				Like mg = new Like();
				//mg.setIdMG(0);
				mg.setRecMG(perfil);
				mg.setPropMG(user);
				
				Like like = manager.searchLike(mg);
				
				//if (like.getIdMG() == 0){
					//manager.gustar(mg);
					//meGustaParaSiempre=true;
				//}
				
				request.setAttribute("tieneLike",like );
				request.setAttribute("meGustaParaSiempre", meGustaParaSiempre);
				
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}


}
