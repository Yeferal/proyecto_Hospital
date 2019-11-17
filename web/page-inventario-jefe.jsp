<%-- 
    Document   : page-inventario-jefe
    Created on : 13/11/2019, 12:33:45 AM
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
        <%@include file="navegacion/navegacion-farmacia-jefe.html" %>
        
        
        <table border="1" class="fila">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre Medicamento</th>
                    <th>Precio</th>
                    <th>Costo</th>
                    <th>Cantidad Actual</th>
                    <th>Minimo</th>
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
                    
                    <td class="fila">${dato.getId()}</td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getPrecio()}</td>
                    <td>${dato.getCosto()}</td>
                    <td>${dato.getCantidad()}</td>
                    <td>${dato.getMinimo()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
