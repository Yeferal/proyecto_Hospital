<%-- 
    Document   : page-reporte2-Farmacia
    Created on : 16/11/2019, 09:19:20 PM
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
        <%@include file="navegacion/navegacion-reportes-farmacia.html" %>
        <br>
        <form action="ReporteGanaciaFarmacia" method="POST">
            <label for="recipient-name" class="col-form-label" >Nombre Medicamento:</label>
            <input type="text" name="texto" placeholder="Texto Medicamento" value="${texh}" height="100px" width="100px">
            
            <label for="recipient-name" class="col-form-label" >Fecha minima:</label>
            <input type="date" name="fecha2"  value="${fech1}" height="100px" width="100px">
            
            <label for="recipient-name" class="col-form-label" >Fecha Maxima:</label>
            <input type="date" name="fecha1" value="${fech2}"  height="100px" width="100px">
            
            <input type="submit" value="Filtrar">
        </form>
        <br>
        <h1>Reporte de Ganacias</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>Ver Sub Listado</th>
                    <th>Sub Listado</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="dato" items="${datos}">
                <c:if test="${!dato.getVentas().isEmpty()}">
                <tr>
                    <td>${dato.getId()}</td>
                    <td>${dato.getNombre()}</td>
                    <td><a href="SubLista?nombre=${dato.getNombre()}&&fec1=${fec1}&&fec2=${fec2}&&costo=${dato.getCosto()}" target="_Blank">Listado>
                        
                        </a></td>
                    <td>
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Lista Medicos
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            
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
                                <c:forEach var="venta" items="${dato.getVentas()}">
                                <tr>
                                    <td>${venta.getFecha()}</td>
                                    <td>${venta.getCantidad()}</td>
                                    <td>${venta.getPrecio()}</td>
                                    <td>${venta.getTotal()}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        
                        </div>
                        
                    </td>
                </tr>
                </c:if>
                </c:forEach>
            </tbody>
        </table>

        
        
        
        
    </body>
</html>
