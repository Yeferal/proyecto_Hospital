<%-- 
    Document   : page-home-cajero
    Created on : 18/11/2019, 03:14:32 AM
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
        <div id="menu" >
        <ul class="menu2">
            <li><a href="HomeCaja">Consulta</a></li>
            <li><a href="CuentaPaciente">Pago Paciente</a></li>
            <li><a href="CloseSesion" >Cerrar Sesion</a></li>       
        </ul>
        </div>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
            Pagar Consulta
        </button>
        
        
        <!-- Modal -->
                        <div class="modal fade" id="exampleModaln" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Contratar Empleado</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  
                                <form action="ConsultaPago" method="POST">
                                <div class="form-group">
                                    
                                    <label for="recipient-name" class="col-form-label" >Nombre del Cliente:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="nombre" placeholder="Nombre" required><br>
                                    
                                    <label for="recipient-name" class="col-form-label">Cuota:</label>
                                    <input type="number" min="0" step="0.01" name="cuota" required/><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >Fecha de Consulta:</label>
                                    <input type="date" name="fecha" required/><br><br>
                                      
                                    <input type="submit" value="Pagar">
                                    
                                    </div>
                                    
                              </form>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                              </div>
                            </div>
                          </div>
                        </div>
        
        <h1>Consultas Recientes</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Cliente</th>
                    <th>Fecha</th>
                    <th>Cuota</th>
                </tr>
            </thead>
            <tbody>
                <%int numero=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%numero++;%>
                    <td><%=numero%></td>
                    <td>${dato.getNombrePaciente()}</td>
                    <td>${dato.getFecha()}</td>
                    <td>${dato.getCuota()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
