<%-- 
    Document   : page-sublista-venta-farmacia
    Created on : 17/11/2019, 12:51:07 AM
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
         <table border="1">
                            <thead>
                                <tr>
                                    <th>Fecha</th>
                                    <th>Cantidad</th>
                                    <th>Costo</th>
                                    <th>Ganacia</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:forEach var="venta" items="${datos}">
                                <tr>
                                    <td>${venta.getFecha()}</td>
                                    <td>${venta.getCantidad()}</td>
                                    <td>${venta.getCosto()}</td>
                                    <td>${venta.getGanancia()}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
    </body>
</html>
