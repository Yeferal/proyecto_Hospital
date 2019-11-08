package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page_002dhome_002drecursos_002dhumanos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/navegacion-recursos-humanos.html");
    _jspx_dependants.add("/modal-empleado-recuroshumanos.html");
    _jspx_dependants.add("/scripts-empleado-recursoshumanos.html");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Hospital</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloMenu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloModal.css\">\n");
      out.write("        ");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloMenu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stiloModal.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<div id=\"menu\" >\n");
      out.write("    <ul class=\"menu2\">\n");
      out.write("        <li><a href=\"\">Empleados</a></li>\n");
      out.write("        <li><a href=\"\"></a></li>\n");
      out.write("        <li><a href=\"#\">Vacaciones</a></li> \n");
      out.write("        <li><a href=\"\" target=\"_Blank\">Reportes</a></li>  \n");
      out.write("        <li><a href=\"CloseSesion\" >Cerrar Sesion</a></li>       \n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <div>\n");
      out.write("\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModaln\">\n");
      out.write("                Contratar Empleado\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("<!-- Modal Contratar Empleado -->\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModaln\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Contratar Empleado</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  \n");
      out.write("                                <form action=\"EmpleadoAdmin?tip=1\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Nombre del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"nombreempleado\" placeholder=\"Nombre\" required><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >CUI del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"cuiempleado\" placeholder=\"CUI\" required><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Codigo del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"codigoempleado\" placeholder=\"Codigo\" required><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Porcentaje de Irtra:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"irtrampleado\"/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\">Porcentaje de Igss:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"igssempleado\"/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Salario:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"salarioempleado\" required/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\">Tipo:</label>\n");
      out.write("                                    <select class=\"custom-select mr-sm-2\" id=\"inlineFormCustomSelect\" name=\"tipoempleado\" required>\n");
      out.write("                                        <option selected ></option>\n");
      out.write("                                        <option value=\"Gerente\">Gerente</option>\n");
      out.write("                                        <option value=\"Recursos Humanos\">Recursos Humanos</option>\n");
      out.write("                                        <option value=\"Administrador\">Administrador</option>\n");
      out.write("                                      </select><br><br>\n");
      out.write("                                      <label for=\"recipient-name\" class=\"col-form-label\" >Fecha de Contratacion:</label>\n");
      out.write("                                      <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                      \n");
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
      out.write("\n");
      out.write("\n");
      out.write("<!-- Modal cambio salaria del empleado en administracion-->\n");
      out.write("                        ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModalcambiosalarial\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Nuevo Salario de Empleado</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  Cambiar el salario del empleado: <b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoSalario.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("                                <form action=\"SalarioAdmin?tip=2&&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoSalario.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    salario actual: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoSalario.getSalario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br><br>\n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Salario Nuevo:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"salario\" required/><br>\n");
      out.write("                                    \n");
      out.write("                                      <label for=\"recipient-name\" class=\"col-form-label\" >Fecha de Cambio:</label>\n");
      out.write("                                      <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                      \n");
      out.write("                                    <input type=\"submit\" value=\"Cambiar Salario\">\n");
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
      out.write("<!-- Modal Despedir empleado en administracion-->\n");
      out.write("                        ");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModaldespedir\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModaldespedir\">Despedir Empleado</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  Confirma el Despido del empleado: <b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoDespido.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("                                <form action=\"DespidoAdmin?tip=2&&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoDespido.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Fecha de Despido:</label>\n");
      out.write("                                    <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                      \n");
      out.write("                                    <input type=\"submit\" value=\"Confirmar Despido\">\n");
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
      out.write("<!-- Modal renuncia de empleado en administracion-->\n");
      out.write("                        ");
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModalrenuncia\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalrenuncia\">Renuncia Empleado</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  Confirma la renuncia del empleado: <b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoRenuncia.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("                                <form action=\"RegistroRenuncia?tip=2&&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoRenuncia.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Fecha de Renuncia:</label>\n");
      out.write("                                    <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                      \n");
      out.write("                                    <input type=\"submit\" value=\"Confirmar Renuncia\">\n");
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
      out.write("<!-- Modal Modificar el empleado en administracion-->\n");
      out.write("                        ");
      if (_jspx_meth_c_set_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModalmodificar\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                          <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalmodificar\">Modificar Empleado</h5>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                  <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                </button>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  Modificar al Empleado: <b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("                                <form action=\"ModificacionAdmin?tip=2&&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Nombre del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"nombreempleado\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Nombre\" required><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >CUI del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"cuiempleado\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getCui()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"CUI\" required><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Codigo del Empleado:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"recipient-name\" name=\"codigoempleado\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getCodigo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Codigo\" required><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Porcentaje de Irtra:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getIrtra()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"irtrampleado\"/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\">Porcentaje de Igss:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getIgss()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"igssempleado\"/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\" >Salario:</label>\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" name=\"salarioempleado\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getSalario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required/><br>\n");
      out.write("                                    \n");
      out.write("                                    <label for=\"recipient-name\" class=\"col-form-label\">Tipo:</label>\n");
      out.write("                                    <select class=\"custom-select mr-sm-2\" id=\"inlineFormCustomSelect\" name=\"tipoempleado\" required>\n");
      out.write("                                        <option selected value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getTipo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empleadoModificar.getTipo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                                        <option value=\"Gerente\">Gerente</option>\n");
      out.write("                                        <option value=\"Recursos Humanos\">Recursos Humanos</option>\n");
      out.write("                                        <option value=\"Administrador\">Administrador</option>\n");
      out.write("                                      </select><br><br>\n");
      out.write("                                      <label for=\"recipient-name\" class=\"col-form-label\" >Fecha de Modificacion:</label>\n");
      out.write("                                      <input type=\"date\" name=\"fecha\" required/><br><br>\n");
      out.write("                                      \n");
      out.write("                                    <input type=\"submit\" value=\"Modificar\">\n");
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
      out.write("        ");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write('\n');
      out.write("\n");
      out.write("                        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID.</th>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Cui</th>\n");
      out.write("                    <th>Irtra</th>\n");
      out.write("                    <th>Igss</th>\n");
      out.write("                    <th>Salario</th>\n");
      out.write("                    <th>Tipo</th>\n");
      out.write("                    <th>Cambio Salario</th>\n");
      out.write("                    <th>Despedir</th>\n");
      out.write("                    <th>Renuncia</th>\n");
      out.write("                    <th>Modificar</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
int ids=0;
      out.write("\n");
      out.write("                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setVar("dato");
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("                <tr>\n");
            out.write("                    ");
ids++;
            out.write("\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getCui()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getIrtra()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getIgss()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getSalario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getTipo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\n");
            out.write("                    <td>\n");
            out.write("                        <form action=\"?tip=1&&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" method=\"post\">\n");
            out.write("                            <input type=\"submit\" value=\"Cambio Salarial\" class=\"btn btn-primary\">\n");
            out.write("                        </form>\n");
            out.write("                    </td>\n");
            out.write("                    <td>\n");
            out.write("                        <form action=\"?tip=1&&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" method=\"post\" >\n");
            out.write("                            <input type=\"submit\" value=\"Despedir\" class=\"btn btn-primary\">\n");
            out.write("                        </form>\n");
            out.write("                    </td>\n");
            out.write("                    <td>\n");
            out.write("                        <form action=\"?tip=1&&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" method=\"POST\" >\n");
            out.write("                            <input type=\"submit\" value=\"Renuncia\" class=\"btn btn-primary\">\n");
            out.write("                        </form>\n");
            out.write("                    </td>\n");
            out.write("                    <td>\n");
            out.write("                        <form action=\"?tip=1&&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" method=\"post\" >\n");
            out.write("                            <input type=\"submit\" value=\"Modificar\" class=\"btn btn-primary\">\n");
            out.write("                        </form>\n");
            out.write("                    </td>\n");
            out.write("                </tr>\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("empleadoSalario");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objetoSalario}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("empleadoDespido");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objetoDespido}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("empleadoRenuncia");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objetoRenuncia}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent(null);
    _jspx_th_c_set_3.setVar("empleadoModificar");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${objetoModificacion}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope['activo1'] != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <script type=\"text/javascript\">\n");
        out.write("                            $(document).ready(function () {\n");
        out.write("                                $('#exampleModalcambiosalarial').modal('show');\n");
        out.write("                            });\n");
        out.write("                    </script>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope['activo2'] != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <script type=\"text/javascript\">\n");
        out.write("                            $(document).ready(function () {\n");
        out.write("                                $('#exampleModaldespedir').modal('show');\n");
        out.write("                            });\n");
        out.write("                    </script>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope['activo3'] != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <script type=\"text/javascript\">\n");
        out.write("                            $(document).ready(function () {\n");
        out.write("                                $('#exampleModalrenuncia').modal('show');\n");
        out.write("                            });\n");
        out.write("                    </script>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope['activo4'] != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <script type=\"text/javascript\">\n");
        out.write("                            $(document).ready(function () {\n");
        out.write("                                $('#exampleModalmodificar').modal('show');\n");
        out.write("                            });\n");
        out.write("                    </script>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
