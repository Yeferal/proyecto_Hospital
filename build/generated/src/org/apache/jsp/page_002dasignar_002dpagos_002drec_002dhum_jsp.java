package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page_002dasignar_002dpagos_002drec_002dhum_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/navegacion-recursos-humanos.html");
    _jspx_dependants.add("/modal-pagos.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Hospital</title>\n");
      out.write("        ");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloMenu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloModal.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloMenu.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<div id=\"menu\" >\n");
      out.write("    <ul class=\"menu2\">\n");
      out.write("        <li><a href=\"HomeRecursosHumanos\">Empleados</a></li>\n");
      out.write("        <li><a href=\"Especialistas\">Especialistas</a></li>\n");
      out.write("        <li><a href=\"TarifarioRecHumanos\">Tarifario</a></li>\n");
      out.write("        <li><a href=\"#\">Asignar Pagos</a></li>\n");
      out.write("        <li><a href=\"#\">Vacaciones</a></li>\n");
      out.write("        <li><a href=\"\" target=\"_Blank\">Reportes</a></li>  \n");
      out.write("        <li><a href=\"CloseSesion\" >Cerrar Sesion</a></li>       \n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <div>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModales\">\n");
      out.write("                Pago de Especialista\n");
      out.write("                </button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModalen\">\n");
      out.write("                Pago de Empleado\n");
      out.write("                </button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModaln\">\n");
      out.write("                Pago de \n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("        ");
      out.write("<!-- Modal pago empleados-->\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModalen\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Pagar Empleado</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  \n");
      out.write("                                <form action=\"EmpleadoAdmin?tip=1\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\">Empleado:</label>\n");
      out.write("                                    <select class=\"custom-select mr-sm-2\" id=\"inlineFormCustomSelect\" name=\"tipoempleado\" required>\n");
      out.write("                                        <option selected ></option>\n");
      out.write("                                        <option value=\"Gerente\">Gerente</option>\n");
      out.write("                                      </select><br><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >CUI del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"cuiempleado\" placeholder=\"CUI\" required><br>\n");
      out.write("\n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Pago de Empleado:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"irtrampleado\"/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Fecha del Pago:</label>\n");
      out.write("                                    <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                    \n");
      out.write("                                    <input type=\"submit\" value=\"Contratar\">\n");
      out.write("                                    \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                              </form>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                \n");
      out.write("                              </div>\n");
      out.write("                            </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("<!-- Modal pago especialista-->\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModales\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Pagar Especialista</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  \n");
      out.write("                                <form action=\"EmpleadoAdmin?tip=1\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\">Especialista:</label>\n");
      out.write("                                    <select class=\"custom-select mr-sm-2\" id=\"inlineFormCustomSelect\" name=\"tipoempleado\" required>\n");
      out.write("                                        <option selected ></option>\n");
      out.write("                                        <option value=\"Gerente\">Gerente</option>\n");
      out.write("                                      </select><br><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >CUI del Especialista:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"cuiempleado\" placeholder=\"CUI\" required><br>\n");
      out.write("\n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Pago de Especialista:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"irtrampleado\"/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Fecha del Pago:</label>\n");
      out.write("                                    <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                    \n");
      out.write("                                    <input type=\"submit\" value=\"Contratar\">\n");
      out.write("                                    \n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                              </form>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                \n");
      out.write("                              </div>\n");
      out.write("                            </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
