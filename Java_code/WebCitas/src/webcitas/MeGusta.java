package webcitas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/megusta")

public class MeGusta extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("\n [MeGusta]:\n");
		HttpSession session=request.getSession();
		
		User user = (User) session.getAttribute("usuario");
		
		if (user==null){
			response.sendRedirect("error-login.html");
		} else {
			try (DBManager manager = new DBManager()){
				
				String idRecMG = request.getParameter("recId");
				System.out.println(" idRec"+idRecMG.toString());
				
				User recMG = manager.searchId(Integer.parseInt(idRecMG));
				System.out.println(" usuarioquepidecita"+recMG.getId());
				request.getParameter("gustar");
				
				Like mg = new Like();
				//mg.setIdMG(0);
				mg.setRecMG(recMG);
				mg.setPropMG(user);
				
				Like like = manager.searchLike(mg);
				
				if (like.getIdMG() == 0){
					manager.gustar(like);
					

					}
				
				
				response.sendRedirect("profile?id=" +idRecMG);
				
			} catch (SQLException | NamingException e) {
				
				PrintWriter out = response.getWriter();
			    out.println("ERROR "+e);
			    System.out.println("ERROR "+e);
			    e.printStackTrace();
			    response.sendRedirect("mainView");
				
			}
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
