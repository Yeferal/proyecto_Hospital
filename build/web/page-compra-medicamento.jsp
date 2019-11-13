<%-- 
    Document   : page-compra-medicamento
    Created on : 12/11/2019, 11:13:48 PM
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
        <%@include file="navegacion-farmacia-jefe.html" %>
        <%@include file="modal-medicamento-jefe.html" %>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Agregar Medicamento
        </button>
        
        
        <h1>Compra</h1>
        
    </body>
</html>
