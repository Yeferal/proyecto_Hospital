<%-- 
    Document   : page-pago-cuenta
    Created on : 18/11/2019, 11:29:11 PM
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
        <br>
        <form action="CuentaPaciente?tip=3&&nombre=${nombre}" method="POST"> 
            
            <input type="submit" value="Pagar Cuenta">
        </form>
        <br>
        <h1><b>TOTAL: Q ${total}</b></h1>
            <br>
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Paciente</th>
                        <th>Descripcion</th>
                        <th>SubTotal</th>
                    </tr>
                </thead>
                <tbody>
                <%int numero=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%numero++;%>
                    <td><%=numero%></td>
                    <td>${dato.getNombrePaciente()}</td>
                    <td>${dato.getDescripcion()}</td>
                    <td>${dato.getTotal()}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
    </body>
</html>
