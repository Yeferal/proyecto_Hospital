<%-- 
    Document   : page-historial-rec-hum
    Created on : 19/11/2019, 10:56:19 AM
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
        <form action="HistorialRecHum" method="POST">
            <label for="recipient-name" class="col-form-label" >Nombre Medicamento:</label>
            <input type="text" name="texto" placeholder="Texto Medicamento" value="${texto}" height="100px" width="100px" required>   
            
            <input type="submit" value="Filtrar">
        </form>
            <br>
        
        <table>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>CUI</th>
                    <th>Salario</th>
                    <th>Tipo</th>
                    <th>Area</th>
                    <th>Fecha</th>
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
                    <td>${dato.getRegistro()}</td>
                    <td>${dato.getFecha()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
