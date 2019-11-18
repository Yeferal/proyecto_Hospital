<%-- 
    Document   : page-home-enfermeria
    Created on : 17/11/2019, 03:10:35 PM
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
        <li><a href="HomeEnfermeria">Sumintros</a></li>
        <li><a href="CloseSesion" >Cerrar Sesion</a></li>  
    </ul>
</div>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
        Suministrar Medicamento Paciente
        </button>

        <!-- Modal Ingreso Paciente -->
                        <div class="modal fade" id="exampleModaln" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar Suministro Paciente</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  
                                <form action="SuministroPaciente" method="POST">
                                <div class="form-group">
                                      
                                    <label for="recipient-name" class="col-form-label" >Fecha de Suministro:</label>
                                    <input type="date" name="fecha" required/><br><br>
                                    
                                    <label for="recipient-name" class="col-form-label">Paciente:</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="paciente" required>
                                        <c:forEach var="paciente" items="${pacientes}">
                                        <option value="${paciente.getId()}">${paciente.getNombre()}</option>
                                        </c:forEach>
                                    </select><br>
                                    
                                    <label for="recipient-name" class="col-form-label">Medicamento Suministrado:</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="medicamento" required>
                                        <c:forEach var="medicamento" items="${medicamentos}">
                                        <option value="${medicamento.getId()}">${medicamento.getNombre()}</option>
                                        </c:forEach>
                                    </select><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >Cantidad de Medicamento:</label>
                                    <input type="number" min="0" name="cantidad" required/><br>
                                    
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
                    <th>Paciente</th>
                    <th>Fecha</th>
                    <th>Descripcion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getFechaIngreso()}</td>
                    <td>${dato.getFechaNacimiento()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
