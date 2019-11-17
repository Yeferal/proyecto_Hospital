<%-- 
    Document   : page-especialistas-rec-hum
    Created on : 8/11/2019, 07:21:09 PM
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
        <%@include file="navegacion/navegacion-recursos-humanos.html" %>
        <div><br>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
            Agregar Especialista a la Planilla
            </button>
            <!-- Modal -->
                        <div class="modal fade" id="exampleModaln" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabeln">Contratar Empleado</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  
                                <form action="Especialistas?tip=0" method="POST">
                                <div class="form-group">
                                    
                                    <label for="recipient-name" class="col-form-label" >Nombre del Empleado:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="nombre" placeholder="Nombre" required><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >CUI del Empleado:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="cui" placeholder="CUI" required><br>
                                      
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
            
            <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>Cui</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
            <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids%></td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getCui()}</td>
                    <td>
                        <form action="Especialistas?tip=1&&id=${dato.getId()}" method="post" >
                            <input type="submit" value="Eliminar" class="btn btn-primary">
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        </div>
        
    </body>
</html>
