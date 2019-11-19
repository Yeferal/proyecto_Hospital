<%-- 
    Document   : page-reporte2-administracin
    Created on : 19/11/2019, 06:38:08 AM
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
        <form action="ReporteCostos" method="POST">
            
            <label for="recipient-name" class="col-form-label" >Fecha minima:</label>
            <input type="date" name="fecha1"  value="${fech1}" height="100px" width="100px">
            
            <label for="recipient-name" class="col-form-label" >Fecha Maxima:</label>
            <input type="date" name="fecha2" value="${fech2}"  height="100px" width="100px">
            
            <input type="submit" value="Filtrar">
        </form>
        <br>
        <c:set var="farmacia" value="${datos1}" ></c:set>
        <c:set var="consulta" value="${datos2}" ></c:set>
        <h1>Repote de Costos</h1>
        <table border="1">
            <thead>
            </thead>
            <tbody>
                <td>Reporte de Costos</td>
                    <td>TOTAL: Q ${farmacia.getSubTotal()+consulta.getSubTotal()}</td>
            </tbody>
        </table>

        
        <table border="1">
            <thead>

            </thead>
            <tbody>
            <td>Area Farmacia(Compra)</td>
                    <td></td>
                    <td>SUBTOTAL: Q ${farmacia.getSubTotal()}</td>
                <c:forEach var="dato1" items="${farmacia.getCompra()}">
                    
                <tr>
                    
                    <td>${dato1.getFecha()}</td>
                    <td>${dato1.getNombreMedicamento()}</td>
                    <td>${dato1.getTotal()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
                <br>
        <table border="1">
            <thead>

            </thead>
            <tbody>
            <td>Area Pago Empleados</td>
                    <td></td>
                    <td>SUBTOTAL: Q  ${consulta.getSubTotal()}</td>
                <c:forEach var="dato2" items="${consulta.getPago()}">
                    
                <tr>
                    
                    <td>${dato2.getFecha()}</td>
                    <td>${dato2.getNombreEmpleado()}</td>
                    <td>${dato2.getPago()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
    </body>
</html>
