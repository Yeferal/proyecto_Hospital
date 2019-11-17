<%-- 
    Document   : page-reporte3-empleados
    Created on : 17/11/2019, 01:14:33 AM
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
        <%@include file="navegacion/navegacion-reportes-empleados.html" %>
        <br>
        <form action="ReporteMedicos" method="POST">
            <label for="recipient-name" class="col-form-label">Area:</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="opcion">
                                        <option value="0">Asignados</option>
                                        <option value="1">DesAsignados</option>
                                      </select><br>
            
            
            <input type="submit" value="Filtrar">
        </form>
        <br>
        <h1>Reporte de Contratos</h1>
        
        <table>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>CUI</th>
                    <th>Salario</th>
                    <th>Tipo</th>
                </tr>
            </thead>
            <tbody>
            
                <c:forEach var="dato" items="${datos}">
                    
                <tr>
                    
                    <td>${dato.getId()}</td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getCui()}</td>
                    <td>${dato.getSalario()}</td>
                    <td>${dato.getTipo()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
