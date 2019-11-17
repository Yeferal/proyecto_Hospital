<%-- 
    Document   : page-vacaciones-rec-hum
    Created on : 8/11/2019, 08:05:51 PM
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
        <%@include file="modals/modal-vacaciones.html" %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>Tipo</th>
                    <th>Fecha asignada</th>
                    <th>Fecha Finaliza</th>
                    <th>Opcion</th>
                </tr>
            </thead>
            <tbody>
            <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids%></td>
                    <td>${dato.getNombreEmpleado()}</td>
                    <td>${dato.getTipo()}</td>
                    <td>${dato.getFechaInicio()}</td>
                    <td>${dato.getFechaFinaliza()}</td>
                    <td>
                        
                        <c:if test="${dato.getFechaInicio() == null}">
                            <form action="VacacionesRecHum?tip=0&&id=${dato.getIdEmpleado()}" method="post">
                            <input type="submit" value="Asignar Fecha Vacaciones" class="btn btn-primary">
                        </form><br>
                        <form action="VacacionesRecHum?tip=2&&id=${dato.getIdEmpleado()}" method="POST" >
                            <input type="submit" value="Asignacion Aleatoria" class="btn btn-primary">
                        </form>
                            
                        </c:if>    
                        
                        <c:if test="${dato.getFechaInicio() != null}">
                             <form action="VacacionesRecHum?tip=4&&id=${dato.getIdEmpleado()}" method="post" >
                            <input type="submit" value="Cambiar Fecha de Vacaciones" class="btn btn-primary">
                            </form>
                        </c:if>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
                
            <%@include file="scrpts-vacaciones.html" %>
    </body>
</html>
