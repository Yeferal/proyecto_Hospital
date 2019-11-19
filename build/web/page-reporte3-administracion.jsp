<%-- 
    Document   : page-reporte3-administracion
    Created on : 19/11/2019, 06:38:39 AM
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
        <%@include file="navegacion/navegacion-reporte-administracion.html" %>
        
        <br>
        <form action="ReporteGanaciasAdministracion" method="POST">
            
            <label for="recipient-name" class="col-form-label" >Fecha minima:</label>
            <input type="date" name="fecha1"  value="${fech1}" height="100px" width="100px">
            
            <label for="recipient-name" class="col-form-label" >Fecha Maxima:</label>
            <input type="date" name="fecha2" value="${fech2}"  height="100px" width="100px">
            
            <input type="submit" value="Filtrar">
        </form>
        <br>
        <c:set var="cuenta" value="${datos1}" ></c:set>
        <h1>Repote de Ganacias</h1>
        <table border="1">
            <thead>
            </thead>
            <tbody>
                <td>Reporte de Ganacias</td>
                    <td>TOTAL: Q ${cuenta.getSubTotal()}</td>
            </tbody>
        </table>

        
        <table border="1">
            <thead>

            </thead>
            <tbody>
            <td>Area Farmacia(Compra)</td>
                    <td></td>
                    <td>SUBTOTAL: Q ${cuenta.getSubTotal()}</td>
                <c:forEach var="dato1" items="${cuenta.getCuenta()}">
                    
                <tr>
                    
                    <td>${dato1.getNombrePaciente()}</td>
                    <td>${dato1.getDescripcion()}</td>
                    <td>${dato1.getTotal()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
    </body>
</html>
