package webcitas;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

@WebServlet("/mainView")

public class mainView extends HttpServlet {


        public void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws IOException, ServletException
        {
        	
        	System.out.println("\n [mainView]:\n");
        	
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("usuario");
                if (user == null){
                        response.sendRedirect("error-login.html");
                } else {
                	
                	try (DBManager manager = new DBManager()){
//        				List<User> usuarios= manager.listRecommendedUsers(user);
//        				session.setAttribute("listaUsuarios",usuarios);
        				
        				boolean errorCProp = false;
        				boolean errorCRec = false;
        				boolean fecha_error;
        				boolean recomendaciones_error = false;
        				
        				List<DinnerDate> citasProp = manager.listDatesPropOf(user);
        				List<DinnerDate> citasRec = manager.listDatesRecOf(user);
        				List<User> usuarios= manager.listRecommendedUsers(user);
        				
        				/* MINI SUGERENCIAS*/
        				
        				if (request.getAttribute("fecha_error") != null)
        					fecha_error = (boolean) request.getAttribute("fecha_error");
        				else 
        					fecha_error = false;
        				System.out.println(" fecha_error: "+fecha_error);
        				
        				if (usuarios == null){
        					recomendaciones_error = true;
        				} else {
        					request.setAttribute("listaUsuarios",usuarios);
        				}
        				
        				request.setAttribute("recomendaciones_error",recomendaciones_error);
        				request.setAttribute("fecha_error", fecha_error);
        				
        				/* MINI ME GUSTA*/
        				
        				
        				
        				/* MINI CITAS*/
        				
        				if (citasProp == null) {
        					errorCProp = true;
        				} else {
        					request.setAttribute("citasProp", citasProp);
        				}
        				
        				if (citasRec == null){
        					errorCRec = true;
        				} else {
        					request.setAttribute("citasRec", citasRec);
        				}
        				System.out.println(" errorCProp: "+errorCProp);
        				System.out.println(" errorCRec: "+errorCRec);
        				request.setAttribute("errorCProp", errorCProp);
        				request.setAttribute("errorCRec", errorCRec);
        				RequestDispatcher rd = request.getRequestDispatcher("mainView.jsp");
        				System.out.println(" Redirección a mainView.jsp");
        				rd.forward(request, response);

        			} catch (SQLException | NamingException e) {

        				PrintWriter out = response.getWriter();
        				out.println("ERROR"+ e);
        				e.printStackTrace();

        			}
                }
}

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws IOException, ServletException
        {
        }


}