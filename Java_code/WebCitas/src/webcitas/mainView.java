package webcitas;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import javax.naming.NamingException;

@WebServlet("/mainView")

public class mainView extends HttpServlet {


        public void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws IOException, ServletException
        {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("usuario");
                if (user == null){
                        response.sendRedirect("error-login.jsp");
                } else {

                        request.getRequestDispatcher("mainView.jsp").forward(request, response);
                }
}

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws IOException, ServletException
        {
        }


}