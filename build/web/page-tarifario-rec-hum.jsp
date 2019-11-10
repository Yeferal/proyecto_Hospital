<%-- 
    Document   : page-tarifario-rec-hum
    Created on : 8/11/2019, 08:23:51 PM
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
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
        Agregar Operacion al Tarifario
        </button>
        <%@include file="modal-tarifario.html" %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Tipo Operacion</th>
                    <th>Precio</th>
                    <th>Costo</th>
                    <th>Cuota Especialista</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
            <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids++%></td>
                    <td>${dato.getTipo()}</td>
                    <td>${dato.getPrecio()}</td>
                    <td>${dato.getCosto()}</td>
                    <td>${dato.getCuota()}</td>
                    <td>
                        <form action="RegistroTarifa?tip=0&&id=${dato.getId()}" method="post" >
                            <input type="submit" value="Eliminar" class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <form action="RegistroTarifa?tip=2&&id=${dato.getId()}" method="post" >
                            <input type="submit" value="Modificar" class="btn btn-primary">
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
