<%-- 
    Document   : page-cuenta-cajero
    Created on : 18/11/2019, 03:27:58 AM
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
        <div id="menu" >
        <ul class="menu2">
            <li><a href="HomeCaja">Consulta</a></li>
            <li><a href="CuentaPaciente">Pago Paciente</a></li>
            <li><a href="CloseSesion" >Cerrar Sesion</a></li>       
        </ul>
        </div>
        
        
        <br>
        <form action="CuentaPaciente?tip=1" method="POST">
            <label for="recipient-name" class="col-form-label" >Paciente:</label>
            <input type="text" name="nombre" placeholder="Nombre del Paciente" value="${texto}" height="100px" width="100px">   
            
            <input type="submit" value="Buscar">
        </form>
        
        <br>
        
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Paciente</th>
                        <th>Pago</th>
                    </tr>
                </thead>
                <tbody>
                <%int numero=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%numero++;%>
                    <td><%=numero%></td>
                    <td>${dato.getNombre()}</td>
                    <td>
                        <form action="CuentaPaciente?tip=2&&id=${dato.getNombre()}" target="_Blank" method="POST">

                            <input type="submit" value="Generar Pago">
                        </form></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        
        
    </body>
</html>
