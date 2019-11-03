

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospital</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
        <link rel="stylesheet" href="css/stiloModal.css">
        <%@include file="header.html" %>
    </head>
    <body>
        <%@include file="navegacion-administrador.html" %>
        
        
        
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
                          Agregar Nuevo Area
                        </button>

                        <!-- Modal -->
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
        
        
        
        <c:if test="${requestScope['modal1'] == 1}">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                HOla desea eliminar a ${dato.getNombre()}
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                              </div>
                            </div>
                          </div>
                        </div>
        </c:if>
        
        <c:if test="${requestScope['modal2'] == 1}">
            <c:set var="infor" value="${objeto}"></c:set>
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Eliminar Area</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                Desea eliminar a ${infor.getNombre()}
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                              </div>
                            </div>
                          </div>
                        </div>
        </c:if>
        
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Area</th>
                    <th>Opciones</th>
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
                        <!-- Button trigger modal -->
<!--                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                          Launch demo modal
                        </button>-->

                        <!-- Modal -->
                        <form action="AreaAdmin?tip=5&&nombres=${dato.getNombre()}&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Eliminar">
                        </form>
                        
                        
                        
<!--                        <div>
                            <form action="AreaAdmin?tip=1&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Modificar">
                        </form>
                        </div>
                            <div>
                                <form action="AreaAdmin?tip=2&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Eliminar">
                        </form>
                            </div>-->
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
