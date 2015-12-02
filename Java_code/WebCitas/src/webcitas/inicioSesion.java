package webcitas;


import java.io.*;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/loginWeb")
public class inicioSesion  extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		try	(DBManager manager = new DBManager()){
			//			
			String usuario=request.getParameter("usuario");
			String password=request.getParameter("password");
			//String texto="Hola me llamo Emilio y estoy probando la app";
			//sex sexo=sex.MALE;
			//SimpleDateFormat year = new SimpleDateFormat("13-11-1994");//La fecha esta mal hay que cambiarla

			User usuarioLogueado= new User();
			usuarioLogueado=manager.searchUser(usuario,password);
			if(usuarioLogueado==null){
				System.out.println("Usuario y contraseña incorrectos");
				response.sendRedirect("error-login.html");
			}else{
				System.out.println("Bienvenido");
				HttpSession session = request.getSession();
				session.setAttribute("usuario",usuarioLogueado);
				response.sendRedirect("mainView");
			}
		} catch(SQLException | NamingException e) {
			e.printStackTrace();
			response.sendRedirect("error-db.html");
		}

	}


}
