/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2015-12-18 13:25:30 UTC
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

public final class citas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/navigation_top_bar.jsp", Long.valueOf(1450444099000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("webcitas");
    _jspx_imports_packages.add("javax.servlet.jsp");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
User user = (User) session.getAttribute("usuario"); 
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Citas</title>\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"base_style.css\" typ=\"text/css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\" href=\"path/to/font-awesome/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"body_back\">\n");
      out.write("\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\r\n");
      out.write("\t<nav class=\"navbar navbar-fixed-top bs-docs-nav\" role=\"banner\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"collapse\" data-target=\"#arrejunto\"\r\n");
      out.write("\t\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\">Meetstoric</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\t\tid=\"arrejunto\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"/meetstoric/mainView\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"top_button\" title=\"mainView\">Inicio<span class=\"sr-only\">(current)</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/meetstoric/citas\" class=\"top_button\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Citas\">Citas</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/meetstoric/sugerencias\" class=\"top_button\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Recomendaciones\">Sugerencias</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/meetstoric/cierreSesion\" class=\"top_button\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"\" title=\"Cerrar Sesión\">Cerrar Sesión</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a\r\n");
      out.write("\t\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + user.getId()));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"top_button\" onclick=\"\" title=\"Mi perfil\">Mi Perfil</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</nav>\r\n");
      out.write("</header>");
      out.write('\n');
      out.write('\n');
      out.write('	');
      out.write('\n');
      out.write('	');

		boolean errorCProp = (boolean) request.getAttribute("errorCProp");
		boolean errorCRec = (boolean) request.getAttribute("errorCRec");
		
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<main>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"container-fluid\"> \n");
      out.write("\t\t\n");
      out.write("\t\t\t<div class=\"container jumbotron \">\n");
      out.write("\t\n");
      out.write("\t<header class=\"page-header\">\n");
      out.write("\n");
      out.write("\t<h1 align=\"center\">Citas</h1>\n");
      out.write("\t\n");
      out.write("\t</header>\n");
      out.write("\t\n");
      out.write("\t<div class=\"row jumbotron jumbotron_even\">\n");
      out.write("\t\n");
      out.write("\t<div class=\"col-md-6\">\n");
      out.write("\t\n");
      out.write("\t<h2>Pendientes de respuesta</h2>\n");
      out.write("\t");

		if (errorCProp) {
		
      out.write("\n");
      out.write("\n");
      out.write("\t<h4>No has propuesto ninguna cita, anímate!</h4>\n");
      out.write("\n");
      out.write("\t");

		} else {
			List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
		
      out.write("\n");
      out.write("\n");
      out.write("\t<table>\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t");
 
			for (DinnerDate cita: citasProp) {
				if (cita.getState() == meetState.PROPUESTA) {
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><img class=\"img-rounded cita_pic\" src=\"");
      out.print( cita.getReceiver().getImgURL());
      out.write("\"></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id="+cita.getReceiver().getId()) );
      out.write('"');
      out.write('>');
      out.print( cita.getReceiver().getNickname() );
      out.write("</a></td>\n");
      out.write("\t\t\t\t<td>");
      out.print( cita.getProposal_sello());
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print( cita.getFecha());
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t");
 
				}
			} 
			
      out.write("\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("\t");
 } 
      out.write("\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("\t<h2>Propuestas para ti</h2>\n");
      out.write("\n");
      out.write("\t");

		if (errorCRec) {
		
      out.write("\n");
      out.write("\n");
      out.write("\t<h4>No te han propuesto ninguna cita. Aún =)</h4>\n");
      out.write("\n");
      out.write("\t");

		} else {
			List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
		
      out.write("\n");
      out.write("\n");
      out.write("\t<table>\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t");

				for (DinnerDate cita : citasRec) {
						if (cita.getState() == meetState.PROPUESTA) {
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><img class=\"img-rounded cita_pic\" src=\"");
      out.print(cita.getProposer().getImgURL());
      out.write("\"></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + cita.getProposer().getId()));
      out.write('"');
      out.write('>');
      out.print(cita.getProposer().getNickname());
      out.write("</a></td>\n");
      out.write("\t\t\t\t<!-- <td>");
      out.print(cita.getProposal_sello());
      out.write("</td> -->\n");
      out.write("\t\t\t\t<td>");
      out.print(cita.getFecha());
      out.write("</td>\n");
      out.write("\t\t\t\t<td><form action=\"citar\" method=\"get\">\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"citaID\" value=\"");
      out.print(cita.getId());
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<input class=\"btn success_button\" type=\"submit\" name=\"cita_estado\" value=\"Aceptar\"> <input\n");
      out.write("\t\t\t\t\t\t\tclass=\"btn fail_button\" type=\"submit\" name=\"cita_estado\" value=\"Rechazar\">\n");
      out.write("\t\t\t\t\t\t<!-- </td> -->\n");
      out.write("\t\t\t\t\t\t<!-- <td><input type=\"date\" name=\"fecha\"> -->\n");
      out.write("\t\t\t\t\t\t<!-- <input type=\"submit\" name=\"cita_estado\" value=\"No puedo\"> -->\n");
      out.write("\t\t\t\t\t\t<input class=\"btn btn-default\" type=\"submit\" name=\"cita_estado\" value=\"Otro día\">\n");
      out.write("\t\t\t\t\t</form></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t");

					}
				}
			
      out.write("\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("\t");
 } 
      out.write("\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"row jumbotron jumbotron_even\">\n");
      out.write("\t\n");
      out.write("\t<div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("\t<h2>Recordatorio\n");
      out.write("\t<small>Citas en el Restaurante</small></h2>\n");
      out.write("\n");
      out.write("\t");

		if (errorCRec && errorCProp) {
			
		
      out.write("\n");
      out.write("\n");
      out.write("\t<h4>No tienes ninguna cita en el Restaurante</h4>\n");
      out.write("\n");
      out.write("\t");

		} else {
			
			List<DinnerDate> citas;
			
			if (errorCRec){
				
				List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
				citas = new ArrayList<DinnerDate>(citasProp);
				
			}else if (errorCProp){
				
				List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
				citas = new ArrayList<DinnerDate>(citasRec);
				
			} else {
				
				List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
				List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
				citas = new ArrayList<DinnerDate>(citasProp);
				citas.addAll(citasRec);
				
			}
		
      out.write("\n");
      out.write("\n");
      out.write("\t<table>\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t");

				for (DinnerDate cita : citas) {
						if (cita.getState() == meetState.CONFIRMADA) {
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><img class=\"img-rounded cita_pic\" src=\"");
      out.print(cita.getProposer().getImgURL());
      out.write("\"></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + cita.getProposer().getId()));
      out.write('"');
      out.write('>');
      out.print(cita.getProposer().getNickname());
      out.write("</a></td>\n");
      out.write("\t\t\t\t<!-- <td>");
      out.print(cita.getProposal_sello());
      out.write("</td> -->\n");
      out.write("\t\t\t\t<td>-</td>\n");
      out.write("\t\t\t\t<td><img class=\"img-rounded cita_pic\" src=\"");
      out.print(cita.getReceiver().getImgURL());
      out.write("\"></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + cita.getReceiver().getId()));
      out.write('"');
      out.write('>');
      out.print(cita.getReceiver().getNickname());
      out.write("</a></td>\n");
      out.write("\t\t\t\t<td>");
      out.print(cita.getFecha());
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t");

					}
				}
			
      out.write("\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("\t");
 } 
      out.write("\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("\t<h2>Respondidas</h2>\n");
      out.write("\n");
      out.write("\t");

		if (errorCRec && errorCProp) {
			
		
      out.write("\n");
      out.write("\n");
      out.write("\t<h4>No han respondido a ninguna de tus citas, pero tampoco tú has\n");
      out.write("\t\trespondido a ninguna... Ojo por ojo y diente por diente</h4>\n");
      out.write("\n");
      out.write("\t");

		} else {
			
			List<DinnerDate> citas;
			
			if (errorCRec){
				
				List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
				citas = new ArrayList<DinnerDate>(citasProp);
				
			}else if (errorCProp){
				
				List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
				citas = new ArrayList<DinnerDate>(citasRec);
				
			} else {
				
				List<DinnerDate> citasRec = (List<DinnerDate>) request.getAttribute("citasRec");
				List<DinnerDate> citasProp = (List<DinnerDate>) request.getAttribute("citasProp");
				citas = new ArrayList<DinnerDate>(citasProp);
				citas.addAll(citasRec);
				
			}
		
      out.write("\n");
      out.write("\n");
      out.write("\t<table>\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t");

				for (DinnerDate cita : citas) {
						if (cita.getState() != meetState.CONFIRMADA && cita.getState() != meetState.PROPUESTA) {
							String icon;
							if (cita.getState() == meetState.OTRO_DIA)
								icon = "glyphicon glyphicon-calendar";
							else
								icon = "glyphicon glyphicon-remove-circle";
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><img class=\"img-rounded cita_pic\" src=\"");
      out.print(cita.getProposer().getImgURL());
      out.write("\"></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + cita.getProposer().getId()));
      out.write('"');
      out.write('>');
      out.print(cita.getProposer().getNickname());
      out.write("</a></td>\n");
      out.write("\t\t\t\t<!-- <td>");
      out.print(cita.getProposal_sello());
      out.write("</td> -->\n");
      out.write("\t\t\t\t<td>-</td>\n");
      out.write("\t\t\t\t<td><img class=\"img-rounded cita_pic\" src=\"");
      out.print(cita.getReceiver().getImgURL());
      out.write("\"></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(response.encodeURL("profile?id=" + cita.getReceiver().getId()));
      out.write('"');
      out.write('>');
      out.print(cita.getReceiver().getNickname());
      out.write("</a></td>\n");
      out.write("\t\t\t\t<td>");
      out.print(cita.getFecha());
      out.write("</td>\n");
      out.write("\t\t\t\t<td> ");
      out.write(" <span class=\"");
      out.print(icon );
      out.write("\"></span></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t");

					}
				}
			
      out.write("\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("\t");
 } 
      out.write("\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
