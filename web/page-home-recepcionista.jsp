<%-- 
    Document   : page-home-recepcionista
    Created on : 9/11/2019, 12:05:42 AM
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
        <%@include file="navegacion-recepcion.html"%>
        
        <br>
        <div>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
            Internar Paciente
        </button>

            <%@include file="modal-ingreso-paciente.html"%>
            <%@include file="modal-asignacion-paciente.html"%>

            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Edad</th>
                        <th>No. Habitacion</th>
                        <th>Fecha Ingreso</th>
                        <th>Asignar</th>
                        <th>Desasignar</th>
                        <th>Medicos</th>
                        <th>Enfermeros</th>
                        <th>Dar de Alta</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                    <tr>
                        <td>${dato.getNombre()}</td>
                        <td>${dato.getEdad()}</td>
                        <td>${dato.getHabitacion()}</td>
                        <td>${dato.getFechaIngreso()}</td>
                        <td>
                            <form action="AsignacionPaciente?tip=1&&id=${dato.getId()}" method="POST">
                                <input type="submit" value="Asignar Medico" class="btn btn-primary">
                            </form>
                            <form action="AsignacionPaciente?tip=3&&id=${dato.getId()}" method="POST">
                                <input type="submit" value="Asignar Enfermero" class="btn btn-primary">
                            </form>
                        </td>
                        <td>
                            <form action="" method="POST">
                                <input type="submit" value="Desasignar Medico" class="btn btn-primary">
                            </form>
                            <form action="#" method="POST">
                                <input type="submit" value="Desasignar Enfermero" class="btn btn-primary">
                            </form>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Lista Medicos
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <c:forEach var="medico" items="${dato.getMedicos()}">
                                <a class="dropdown-item" href="#">${medico}</a>
                                </c:forEach>
                                </div>
                            </div>
                        </td>
                        
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Lista Enfermeros
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <c:forEach var="enfermero" items="${dato.getEnfermeros()}">
                                <a class="dropdown-item" href="#">${enfermero}</a>
                            </c:forEach>
                                </div>
                            </div>
                        </td>
                        <td>
                            <form action="#" method="POST">
                                <input type="submit" value="Dar de Alta" class="btn btn-primary">
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="scripts-asigancion-recepcionista.html"%>
            
            
    </body>
</html>
