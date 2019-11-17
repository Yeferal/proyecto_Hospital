<%-- 
    Document   : page-habitacion-administrador
    Created on : 1/11/2019, 10:42:01 PM
    Author     : yefer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospital</title>
        
        <%@include file="header.html" %>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
        
        <%@include file="navegacion/navegacion-administrador.html" %>
        <div>
            
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
                          Agregar Nueva Habitacion
                        </button>

                        
            <%@include file="modals/modal-nueva-habitacion.html" %>
            
        </div>
            
        <!--        este es el modal para Modificar el area seleccionado-->
            <c:set var="modificararea" value="${objetohabitacionmodificar}"></c:set>
            <div class="modal fade" id="exampleModalmodificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modificar</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  Modificar Habitacion ID: ${modificararea.getId()}
                                <form action="HabitacionAdmin?tip=5&&id=${modificararea.getId()}" method="POST">
                                
                                    <label for="recipient-name" class="col-form-label">Estado de la Habitacion:</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="estadoH" required>
                                        <option selected="${modificararea.getEstado()}">${modificararea.getEstadoTexto()}</option>
                                        <option value="0">Inhabilitado</option>
                                        <option value="1">Habilitado</option>
                                      </select><br>
                                    <label for="recipient-name" class="col-form-label" >Costo:</label>
                                    <input type="number" step="0.01" name="costo" value="${modificararea.getCosto()}" required/><br>
                                    <label for="recipient-name" class="col-form-label">Cuota:</label>
                                    <input type="number" step="0.01" name="cuota" value="${modificararea.getCuota()}" required/><br>
                                  <input type="submit" value="Modificar">
                                </form>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                              </div>
                            </div>
                          </div>
                        </div>
        
<!--        este es el modal para eliminar el area seleccionado-->
            <c:set var="objetohabitacion" value="${objetohabitacioneliminar}"></c:set>
            <div class="modal fade" id="exampleModaleliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Eliminar Area</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  Desea eliminar a No. <B>${objetohabitacion.getId()}</b>
                              </div>
                              
                              <form action="HabitacionAdmin?tip=3&&id=${objetohabitacion.getId()}" method="POST">
                                  <input type="submit" value="Eliminar">
                              </form>
                              
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                
                              </div>
                            </div>
                          </div>
            </div>
        
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>ID.</th>
                    <th>Paciente</th>
                    <th>Estado</th>
                    <th>Costo</th>
                    <th>Cuota</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
                <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td>${dato.getId()}</td>
                    <td>${dato.getPaciente()}</td>
                    <td>${dato.getEstadoTexto()}</td>
                    <td>${dato.getCosto()}</td>
                    <td>${dato.getCuota()}</td>
                    <td>
                        <div>
                            <form action="HabitacionAdmin?tip=2&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Eliminar">
                        </form>
                        </div>
                        </td>    
                    <td>
                            <div>
                                <form action="HabitacionAdmin?tip=4&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Modificar">
                        </form>
                            </div>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
  
                <c:if test="${requestScope['activo1'] != null}">
                    <script type="text/javascript">
                            $(document).ready(function () {
                                $('#exampleModaleliminar').modal('show');
                            });
                    </script>
                </c:if>
                <c:if test="${requestScope['activo2'] != null}">
                    <script type="text/javascript">
                            $(document).ready(function () {
                                $('#exampleModalmodificar').modal('show');
                            });
                    </script>
                </c:if>
                    
                            
    </body>
</html>
