package webcitas;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import java.util.List;

@WebServlet("/citar")

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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("usuario");
		
			if (user==null){
				response.sendRedirect("error-login.html");
			} else {
				try (DBManager manager = new DBManager()){
				DinnerDate date= new DinnerDate();
				String receiverId = request.getParameter("recId");

				User receiver = manager.searchId(Integer.parseInt(receiverId));


				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // EL FORMATO QUE DEVUELVE HTML5 ES YYYY-MM-DD, ES ESTO CORRECTO?
				Date fecha = new Date(dateFormat.parse(request.getParameter("fecha")).getTime());

				java.util.Date hoy = new java.util.Date();
				boolean fecha_error = false;
				if (fecha.before(hoy)){

				    date.setProposer(user);
				    date.setReceiver(receiver);
				    date.setProposal_sello(fecha);
				    manager.setDate(date);

				    List<DinnerDate> citas= manager.listDatesPropOf(user);

				    request.setAttribute("listaCitasPropuestas",citas);

				    request.getRequestDispatcher("citas.jsp").forward(request, response);
				} else {

				    fecha_error = true;
				    request.getRequestDispatcher("recomendaciones.jsp").forward(request, response);

				}
				
			} catch (SQLException | NamingException | ParseException e) {
				
				PrintWriter out = response.getWriter();
			    out.println("ERROR");
			    e.printStackTrace();
				
			}
				
			}
		
	}

}
