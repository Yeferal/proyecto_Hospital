

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
        
        
        
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
                          Agregar Nuevo Area
            </button>

                        <!-- Modal nuevo area-->
                        <div class="modal fade" id="exampleModaln" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar Nuevo Area</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                <form action="AreaAdmin?tip=0" method="POST">
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Area:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="nombreArea" placeholder="Area Nueva" required><br>
                                    <input type="submit" value="Agregar">
                                    </div>
                              </form>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                              </div>
                            </div>
                          </div>
                        </div>
        
        
        <!--        este es el modal para Modificar el area seleccionado-->
            <c:set var="modificararea" value="${objetoarea}"></c:set>
            <div class="modal fade" id="exampleModalmodificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                <form action="AreaAdmin?tip=3&&id=${modificararea.getId()}" method="POST">
                                <input type="text" name="nombreArea" value="${modificararea.getNombre()}" required>
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
            <c:set var="infor" value="${objeto}"></c:set>
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
                                  Desea eliminar a  <B>${infor.getNombre()}</b>
                              </div>
                              
                              <form action="AreaAdmin?tip=2&&id=${infor.getId()}" method="POST">
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
                    <th>No.</th>
                    <th>Area</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
                <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids%></td>
                    <td>${dato.getNombre()}</td>
                    <td>
                        <form action="AreaAdmin?tip=5&&nombres=${dato.getNombre()}&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                    <td>
                        <form action="AreaAdmin?tip=1&&nombres=${dato.getNombre()}&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Modificar">
                        </form>
                    </td>
                </tr>
                </c:forEach>
                
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
            </tbody>
        </table>
   
    </body>
</html>
