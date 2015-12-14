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

import java.util.Calendar;
import java.util.List;

@WebServlet("/citar")

public class Citar extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("\n [Citar]:\n");
		
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
					    Calendar calendario = Calendar.getInstance();
					    calendario.setTime(hoy);
					    calendario.add(Calendar.DAY_OF_YEAR, 14);  // Sumamos los días
					    if (!fecha.before(hoy) && !fecha.after(calendario.getTime())){

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
						request.setAttribute("fecha_error", fecha_error);
						response.sendRedirect("sugerencias");
						//request.getRequestDispatcher("recomendaciones.jsp").forward(request, response);

					    }
					}
					
				} else if (citaId != null && citaEstado!=null) { //GESTIONAR CITA
					
					DinnerDate toAnswerDate = manager.idToDinnerDate(Integer.parseInt(citaId));
					meetState state;
					System.out.println(" citaEstado: "+citaEstado);
					System.out.println(" citaID: "+Integer.parseInt(citaId));
					System.out.println(" ID de cita dentro de la cita de respuesta: "+toAnswerDate.getId());
					
					switch (citaEstado){
					
					case "Aceptar":
						state=meetState.CONFIRMADA;
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
					response.sendRedirect("citas");
				
				} else {
					request.getRequestDispatcher("error-login.jsp").forward(request, response);
				}
			} catch (SQLException | NamingException | ParseException e) {
				
				PrintWriter out = response.getWriter();
			    out.println("ERROR "+e);
			    System.out.println("ERROR "+e);
			    e.printStackTrace();
			    response.sendRedirect("mainView");
				
			}
				
			}
		
	}

}
