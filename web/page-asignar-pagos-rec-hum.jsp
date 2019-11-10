<%-- 
    Document   : page-asignar-pagos-rec-hum
    Created on : 8/11/2019, 11:27:24 PM
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
        <br>
        <div>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModales">
                Pago de Especialista
                </button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalen">
                Pago de Empleado
                </button>
            </div>
        <%@include file="modal-pagos.html" %>
        
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Nombre Personal</th>
                    <th>Nombre de Usuario</th>
                    <th>Tipo de Pago</th>
                    <th>Fecha</th>
                    <th>Cantidad Pago</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
                <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids%></td>
                    <td>${dato.getNombreEmpleado()}</td>
                    <td>${dato.getNombreGerente()}</td>
                    <td>${dato.getTipo()}</td>
                    <td>${dato.getFecha()}</td>
                    <td>${dato.getPago()}</td>
                    <td>
                        <form action="?tip=5&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                    <td>
                        <form action="?tip=1&&id=${dato.getId()}" method="POST">
                            <input type="submit" value="Modificar">
                        </form>
                    </td>
                </tr>
                </c:forEach>
        
        
    </body>
</html>
