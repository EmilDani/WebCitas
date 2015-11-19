package bookshop2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import bookshop2.DBManager;  

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	   public void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException
			    {
		   String user=request.getParameter("user");
		   String pass=request.getParameter("password");
		   if("emartinmayor".equals(user)&&"emilio".equals(pass)){
			response(response,"login ok");   
		   }else{
			   response(response,"invalid login");
		   }
		   }
	//Para login.jsp response.sendRedirect(response.encodeRedirectURL("./catalogo.jsp"));
	   private void response( HttpServletResponse response,String msg ) throws IOException{
		   PrintWriter out=  response.getWriter();
		   out.println("<html>");
		   out.println("<body>");
		   out.println("<t1>"+ msg+"</t1>");
		   out.println("</body>");
		   out.println("</html>");
	   }
	   
			    }
	

