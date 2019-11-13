<%-- 
    Document   : page-otros-administracion
    Created on : 11/11/2019, 02:40:39 AM
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
        <%@include file="navegacion-administrador.html" %>
        <c:set var="dato" value="${objeto}"></c:set>
 
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Dias para Vacaciones:</td>
                    <td>${dato}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
                        Modificar
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
                        <div class="modal fade" id="exampleModaln" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalmodificar">Modificar la Leye de dias de Vacaciones</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  La cantidad actual es de: <b>${dato}</b> dias
                                <form action="OtrosAdmin" method="POST">
                                <div class="form-group">
                                    
                                    <label for="recipient-name" class="col-form-label">Nueva cantidad de dias de Vacaciones:</label>
                                    <input type="number" value="${dato}" name="dias" required/><br>
                                      
                                    <input type="submit" value="Modificar">
                                    
                                    </div>
                                    
                              </form>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                              </div>
                            </div>
                          </div>
                        </div>

        
        
        
    </body>
</html>
