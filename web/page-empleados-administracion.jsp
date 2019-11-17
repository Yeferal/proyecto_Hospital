<%-- 
    Document   : page-empleados-administracion
    Created on : 1/11/2019, 11:50:59 PM
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
        
        <%@include file="navegacion/navegacion-administrador.html" %>
        <br>
        <div>

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
                              Contratar Empleado
                </button>

        </div>
        <%@include file="modals/modal-contratar-administracion.html" %>
        <%@include file="modals/modal-empleado-administracion.html" %>
        <%@include file="scripts-administracion-empleado.html" %>
                        
        <table border="1">
            <thead>
                <tr>
                    <th>ID.</th>
                    <th>Nombre</th>
                    <th>Cui</th>
                    <th>Irtra</th>
                    <th>Igss</th>
                    <th>Salario</th>
                    <th>Tipo</th>
                    <th>Cambio Salario</th>
                    <th>Despedir</th>
                    <th>Renuncia</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
            <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td>${dato.getId()}</td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getCui()}</td>
                    <td>${dato.getIrtra()}</td>
                    <td>${dato.getIgss()}</td>
                    <td>${dato.getSalario()}</td>
                    <td>${dato.getTipo()}</td>
                    <td>
                        <form action="SalarioAdmin?tip=1&&id=${dato.getId()}" method="post">
                            <input type="submit" value="Cambio Salarial" class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <form action="DespidoAdmin?tip=1&&id=${dato.getId()}" method="post" >
                            <input type="submit" value="Despedir" class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <form action="RenunciaAdmin?tip=1&&id=${dato.getId()}" method="POST" >
                            <input type="submit" value="Renuncia" class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <form action="ModificacionAdmin?tip=1&&id=${dato.getId()}" method="post" >
                            <input type="submit" value="Modificar" class="btn btn-primary">
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
