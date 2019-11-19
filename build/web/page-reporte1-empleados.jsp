<%-- 
    Document   : page-reporte1-empleados
    Created on : 17/11/2019, 01:04:30 AM
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
        <form action="ReporteContrato" method="POST">
            <label for="recipient-name" class="col-form-label">Area:</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="tipoempleado">
                                        <option selected ></option>
                                        <c:forEach var="area" items="${objetoarea}">
                                        <option value="${area}">${area}</option>
                                        </c:forEach>
                                      </select><br>
            
            <label for="recipient-name" class="col-form-label" >Fecha minima:</label>
            <input type="date" name="fecha2"  value="${fech1}" height="100px" width="100px">
            
            <label for="recipient-name" class="col-form-label" >Fecha Maxima:</label>
            <input type="date" name="fecha1" value="${fech2}"  height="100px" width="100px">
            
            <input type="submit" value="Filtrar">
        </form>
        <br>
            <form action="ExportaEmpleado?tip=1&&area=${texh}&&fecha1=${fech1}&&fecha2=${fech2}" method="POST">
            
            <input type="submit" value="Exportar">
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
