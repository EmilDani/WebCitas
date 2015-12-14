package webcitas;

import java.io.*;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cierreSesion")
public class CerrarSesion extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("\n [CerrarSesion]:\n");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.html");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		System.out.println(" POST");
		
		// Por qué lo has puesto en Post?
				HttpSession session=request.getSession();
				session.invalidate();
				response.sendRedirect("index.html");
			

	}


}