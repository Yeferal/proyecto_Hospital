<%-- 
    Document   : page-reporte3-farmacia
    Created on : 16/11/2019, 11:46:03 PM
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
        <form action="ReporteVentas" method="POST">

            <label for="recipient-name" class="col-form-label">Tipo de Filtro:</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="opcion" height="100px" width="100px" required>
            <option value="0">Nombre</option>
            <option value="1">CUI</option>
            </select>
            
            <label for="recipient-name" class="col-form-label" >Dato del Empleado:</label>
            <input type="text" name="texto" placeholder="Texto" value="${texh}" height="100px" width="100px">
            
            <input type="submit" value="Filtrar">
        </form>
            <br>
            <form action="ReporteMedicamentoFarmacia?tip=1&&texto=${texto}" method="POST">
            
            <input type="submit" value="Exportar">
        </form>
        <br>
        <h1>Reporte de Ventas</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>Ver Sub Listado</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="dato" items="${datos}">
                <c:if test="${!dato.getVentas().isEmpty()}">
                <tr>
                    <td>${dato.getId()}</td>
                    <td>${dato.getNombre()}</td>
                    <td><a href="SubListaVentas?nombre=${dato.getNombre()}" target="_Blank">Listado></a></td>
                   
                </tr>
                </c:if>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
