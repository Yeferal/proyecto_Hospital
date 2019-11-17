<%-- 
    Document   : page-compra-medicamento
    Created on : 12/11/2019, 11:13:48 PM
    Author     : yefer
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@include file="navegacion/navegacion-farmacia-jefe.html" %>
        <%@include file="modals/modal-medicamento-jefe.html" %>
        <c:if test="${requestScope['opcion'] == null}" >
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Agregar Medicamento
        </button>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalfecha">
        Realizar Compra
        </button>
        </c:if>
        
        <c:if test="${requestScope['compra1'] != null}" >
            <%request.setAttribute("listado", request.getParameter("datos"));%>
        <h1>Compra</h1>
        
        <div>
            <form action="CompraFarmacia?tip=0" method="POST">
                <div class="form-group">
                                    
                <label for="recipient-name" class="col-form-label">Nombre Medicamento:</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="nombre" required>
                        <option selected></option>
                        <c:forEach var="medicamento" items="${medicamentos}">
                        <option value="${medicamento.getNombre()}">${medicamento.getNombre()}</option>
                        </c:forEach>
                    </select><br>

                <label for="recipient-name" class="col-form-label" >Precio:</label>
                <input type="number" step="0.01" name="precio" min="0" required/>
                                    
                <label for="recipient-name" class="col-form-label" >Cantidad:</label>
                <input type="number" name="cantidad" min="1" required/>

                <label for="recipient-name" class="col-form-label" >Fecha de Compra:</label>
                <input type="date" value="${fechaCompra}" name="fecha" required readonly/><br><br>
                                   
                <input type="submit" value="Agregar">
                                   
                </div>
            </form>
            
            
            
        </div>
        <c:if test="${requestScope['termina'] != null}" >
        <div>
            <form action="CompraFarmacia?tip=2&&fecha1=${fechaCompra}" method="POST">
                <div class="form-group">
                                                      
                <input type="submit" value="Terminar Compra">
                                   
                </div>
            </form>
        </div>
        </c:if>
                
        
        <c:if test="${requestScope['compra2'] != null}" >
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Medicamento</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <%int ids=0;%>
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <%ids++;%>
                    <td><%=ids%></td>
                    <td>${dato.getNombreMedicamento()}</td>
                    <td>${dato.getPrecio()}</td>
                    <td>${dato.getCantidad()}</td>
                    <td>${dato.getTotal()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
        </c:if>
    </body>
</html>
