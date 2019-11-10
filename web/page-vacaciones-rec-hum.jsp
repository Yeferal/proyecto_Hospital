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
        <%@include file="navegacion-recursos-humanos.html" %>
        <%@include file="modal-vacaciones.html" %>
        
        
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre</th>
                    <th>Cui</th>
                    <th>Fecha asignada</th>
                    <th>Asignar</th>
                    <th>Cambiar</th>
                    <th>Aleatorio</th>
                </tr>
            </thead>
            <tbody>
            <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids++%></td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getCui()}</td>
                    <td>${dato.getTipo()}</td>
                    <td>
                        <form action="?tip=1&&id=${dato.getId()}" method="post">
                            <input type="submit" value="Asignar Fecha Vacaciones" class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <form action="?tip=1&&id=${dato.getId()}" method="post" >
                            <input type="submit" value="Cambiar Fecha de Vacaciones" class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <form action="?tip=1&&id=${dato.getId()}" method="POST" >
                            <input type="submit" value="Asignacion Aleatoria" class="btn btn-primary">
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
