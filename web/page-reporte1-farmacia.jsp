<%-- 
    Document   : page-reporte1-farmacia
    Created on : 16/11/2019, 08:22:23 PM
    Author     : yefer
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@include file="navegacion/navegacion-reportes-farmacia.html" %>
        <br>
        <form action="ReporteMedicamentoFarmacia?tip=0" method="POST">
            <label for="recipient-name" class="col-form-label" >Nombre Medicamento:</label>
            <input type="text" name="texto" placeholder="Texto Medicamento" value="${texto}" height="100px" width="100px" required>   
            
            <input type="submit" value="Filtrar">
        </form>
        <br>
        <h1>Reporte de Medicamentos</h1>
        
        <table>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>Cantidad Existente</th>
                    <th>Cantidad Minima</th>
                    <th>Precio Unitario</th>
                    <th>Costo</th>
                </tr>
            </thead>
            <tbody>
            
                <c:forEach var="dato" items="${datos}">
                    <c:if test="${dato.getCantidad() < dato.getMinimo()}">
                        <tr style="background: red">
                    </c:if>
                            
                    <c:if test="${dato.getCantidad() > dato.getMinimo()}}">
                        <tr>
                    </c:if>
                    
                    <td>${dato.getId()}</td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getCantidad()}</td>
                    <td>${dato.getMinimo()}</td>
                    <td>${dato.getPrecio()}</td>
                    <td>${dato.getCosto()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
