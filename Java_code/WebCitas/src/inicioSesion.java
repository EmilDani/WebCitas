
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/inicioSesion")

public class inicioSesion  extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		String user=request.getParameter("user");
		String pass=request.getParameter("password");
		if("emartinmayor".equals(user)&&"emilio".equals(pass)){
			User nuevoUser= new User();
			request.setAttribute("usuarioLogueado", user);
			request.getRequestDispatcher("MainView.jsp").forward(request, response);
			response(response,"login ok");   
		}else{
			response(response,"invalid login");
		}
		//		   RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
		//		    rd.forward(request, response);

		response.sendRedirect("mainView");

	}
	//Para login.jsp response.sendRedirect(response.encodeRedirectURL("./catalogo.jsp"));
	private void response(HttpServletResponse response, String msg ) throws IOException{
		PrintWriter out=  response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>"+ msg+"</t1>");
		out.println("</body>");
		out.println("</html>");
	}


}
