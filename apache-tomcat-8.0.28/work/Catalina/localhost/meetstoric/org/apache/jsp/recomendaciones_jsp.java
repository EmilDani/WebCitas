/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2015-12-03 12:52:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import webcitas.*;
import java.util.List;
import java.util.ArrayList;

public final class recomendaciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("webcitas");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<title>Elección de citas</title>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t");
  List<User> listaUsuarios = (List<User>) request.getAttribute("listaUsuarios"); 
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<p>Usuarios reomendados para ti:</p>\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<thead>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:20px; color:green; \">NickName</td>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:20px; color:green; \">Año de nacimiento</td>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:20px; color:green; \">Interesado/a en</td>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:20px; color:green; \">Edad Máxima</td>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:20px; color:green; \">Edad Mínima</td>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:20px; color:green; \">Elija una fecha para su cita</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</thead>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t");

				for (User usuario: listaUsuarios) {

				
      out.write("\n");
      out.write("\t\t\t\t<td>");
      out.print( usuario.getNickname());
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print( usuario.getYear());
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print( usuario.getDesired_sex());
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print( usuario.getDesired_year_max());
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print( usuario.getDesired_year_min());
      out.write("</td>\n");
      out.write("\t\t\t\t<td><form action=\"citar\" method=\"get\"> </td>\n");
      out.write("\t\t\t\t<td><input type=\"date\" name=\"fecha\"><td>\n");
      out.write("\t\t\t\t  <td><input type=\"hidden\" name=\"recId\" value=\"");
      out.print(usuario.getId() );
      out.write("\">\n");
      out.write("\t\t\t\t  <input type=\"submit\" value=\"Pedir Cita\" style=font-size:14px;color:blue; ></td>\n");
      out.write("\t\t\t\t</form></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t  ");
 } 
      out.write("\n");
      out.write("\t\t</table>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
