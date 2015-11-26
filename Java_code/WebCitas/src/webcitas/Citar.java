package webcitas;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.List;

public class Citar extends HttpServlet {
	
//	public void init() throws ServletException {
//		
//	}
//	
//	public void destroy() {
//		
//	}
	
//	public boolean isLogged (HttpSession session, DBManager manager)
//			throws SQLException{
//		boolean logged = false;
//		User user = (User) session.getAttribute("user");
//		if (user != null){
//			// NO SÉ SI El if A CONTINUACIÓN ES REALMENTE ÚTIL
//			if (manager.searchUser(user.getNickuser()) != null)
//				logged = true;
//		}
//		return logged;
//	}
	
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//		
//		HttpSession session = request.getSession();
//		try (DBManager manager = new DBManager()){
//			if (isLogged (session, manager)){
//				
//				DinnerDate date= new DinnerDate();
//				date = (DinnerDate) session.getAttribute("citas");
//			// Variable citas a crear en el JSP de citas (Servlet)
//				
//				manager.setDate(date);
//			}
//
//		} catch (SQLException | NamingException e) {
//			
//			PrintWriter out = response.getWriter();
//		    out.println("ERROR");
//		    e.printStackTrace();
//			
//		}
//		
//	}

}