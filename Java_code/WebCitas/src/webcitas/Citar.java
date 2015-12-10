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
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("usuario");
		
			if (user==null){
				response.sendRedirect("error-login.html");
			} else {
				try (DBManager manager = new DBManager()){
					
				String receiverId = request.getParameter("recId");
				String citaId = request.getParameter("citaID");
				String citaEstado = request.getParameter("cita_estado");
				
				if (receiverId != null) { //CREAR CITA
					
					DinnerDate date= new DinnerDate();
					User receiver = manager.searchId(Integer.parseInt(receiverId));


					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // EL FORMATO QUE DEVUELVE HTML5 ES YYYY-MM-DD, ES ESTO CORRECTO?
					String fecha_recuperada = request.getParameter("fecha");
					boolean fecha_error = false;
					if (fecha_recuperada != null) {
					    Date fecha = new Date(dateFormat.parse(fecha_recuperada).getTime());
					    java.util.Date hoy = new java.util.Date();
					    if (!fecha.before(hoy)){

						date.setProposer(user);
						date.setReceiver(receiver);
						date.setFecha(fecha);
						manager.setDate(date);
					    
						// CAMBIAR BASE DE DATOS PERMITIR QUE FechaResp SEA NULL

//						List<DinnerDate> citas= manager.listDatesPropOf(user);
	//
//						request.setAttribute("citasProp",citas);

						//request.getRequestDispatcher("citas.jsp").forward(request, response);
						response.sendRedirect("citas");
						
					    } else {

						fecha_error = true;
						request.getRequestDispatcher("recomendaciones.jsp").forward(request, response);

					    }
					}
					
				} else if (citaId != null && citaEstado!=null) { //GESTIONAR CITA
					
					DinnerDate toAnswerDate = manager.idToDinnerDate(Integer.parseInt(citaId));
					meetState state;
					System.out.println(citaEstado);
					
					switch (citaEstado){
					
					case "Aceptar":
						state=meetState.CONFIRMADA;
						System.out.println(state.toString());
						break;
					case "Rechazar":
						state=meetState.RECHAZADA;
						break;
//					case "No puedo =(":
//						break;
					case "Otro día":
						state=meetState.OTRO_DIA;
						break;
						default:
							throw new IOException("No se reconoce el estado de la cita.");
					
					}
					toAnswerDate.setState(state);
					manager.answerDate(toAnswerDate);
					response.sendRedirect("mainView");
				
				} else {
					request.getRequestDispatcher("error-login.jsp").forward(request, response);
				}
			} catch (SQLException | NamingException | ParseException e) {
				
				PrintWriter out = response.getWriter();
			    out.println("ERROR "+e);
			    e.printStackTrace();
				
			}
				
			}
		
	}

}
