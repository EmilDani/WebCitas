/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2015-12-14 18:09:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import webcitas.*;

public final class mainView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("webcitas");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = null;
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error-login", true, 8192, true);
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
      out.write("\n");
 User user = (User) session.getAttribute("usuario"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"base_style.css\" typ=\"text/css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<header class=\"navbar navbar-static-top bs-docs-nav\" id=\"top\" role=\"banner\">\n");
      out.write("\t<div id=\"top_bar\" class=\"top_bar\" style=\"position: relative; top: 0px;\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"container\" style=\"float: left; width: 50%; overflow: hidden; height: 44px\">\n");
      out.write("\n");
      out.write("\t\t\t<a href=\"/meetstoric/mainView\" class=\"top_bottom\" title=\"mainView\">Inicio</a>\n");
      out.write("\t\t\t<a href=\"/meetstoric/citas\" class=\"top_bottom\" title=\"Citas\">Citas</a>\n");
      out.write("\t\t\t<a href=\"/meetstoric/sugerencias\" class=\"top_bottom\"\n");
      out.write("\t\t\t\ttitle=\"Recomendaciones\">Sugerencias</a>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"container\"\n");
      out.write("\t\t\tstyle=\"float: right; width: 200px; overflow: hidden; height: 44px;\">\n");
      out.write("\n");
      out.write("\t\t\t<a href=\"/meetstoric/cierreSesion\" class=\"top_bottom\" onclick=\"\"\n");
      out.write("\t\t\t\ttitle=\"Cerrar Sesión\">Cerrar Sesión</a> <a\n");
      out.write("\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + user.getId()));
      out.write("\"\n");
      out.write("\t\t\t\tclass=\"top_bottom\" onclick=\"\" title=\"Mi perfil\">Mi Perfil</a>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<div>\n");
      out.write("\t\t<header id=\"header style=\"background-image:url(https://cdn.comuniame.com/img/header.jpg)\">\n");
      out.write("\t\t<div id=\"logo\">\n");
      out.write("\t\t\t<a href=\"/\"> <img\n");
      out.write("\t\t\t\tsrc=\"http://www.euroresidentes.com/corazones/imagenes/corazones1.png\">\n");
      out.write("\t\t\t</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<p style=\"font-weight: bold; font-size: 20px;\">\n");
      out.write("\t\tHola,\n");
      out.write("\t\t");
      out.print( user.getNickname());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\n");
      out.write("\t<p style=\"font-size: 10px;\">Estos son tus datos:</p>\n");
      out.write("\t<p style=\"font-size: 10px;\">\n");
      out.write("\t\tDescripcion:\n");
      out.write("\t\t");
      out.print(user.getDtext());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\t<p style=\"font-size: 10px;\">\n");
      out.write("\t\tSexo:\n");
      out.write("\t\t");
      out.print(user.getSex());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\t<p style=\"font-size: 10px;\">\n");
      out.write("\t\tAño de Nacimiento:\n");
      out.write("\t\t");
      out.print(user.getYear());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\t<p style=\"font-size: 10px;\">\n");
      out.write("\t\tInteresado en:\n");
      out.write("\t\t");
      out.print(user.getDesired_sex());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\t<p style=\"font-size: 10px;\">\n");
      out.write("\t\tRango de edad máximo:\n");
      out.write("\t\t");
      out.print(user.getDesired_year_max());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\t<p style=\"font-size: 10px;\">\n");
      out.write("\t\tRango de edad mínimo:\n");
      out.write("\t\t");
      out.print(user.getDesired_year_min());
      out.write("\n");
      out.write("\t</p>\n");
      out.write("\t<!-- <p>\n");
      out.write("\t<form action=\"sugerencias\" method=\"get\">\n");
      out.write("\t\t<td><input type=\"submit\" value=\"Recomendaciones\"\n");
      out.write("\t\t\tstyle=\"font-size: 14px; color: blue;\"></td>\n");
      out.write("\t</form>\n");
      out.write("\t</p> -->\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
