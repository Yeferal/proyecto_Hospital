<%-- 
    Document   : page-venta-medicamento
    Created on : 16/11/2019, 02:34:54 PM
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
        <%@include file="navegacion/navegacion-farmacia.html" %>
        <%@include file="modals/modal-medicamento-farmacia.html" %>
        <c:if test="${requestScope['opcion'] == null}" >
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalfecha">
        Realizar Venta
        </button>
        </c:if>
        
        <c:if test="${requestScope['venta1'] != null}" >
            <%request.setAttribute("listado", request.getParameter("datos"));%>
            <%request.setAttribute("cliente", request.getParameter("clienteVenta"));
//              String cliente = request.getAttribute("clienteVenta").toString();
            %>
        <h1>Venta de Medicamentos</h1>
        
        <div>
            <form action="VentaFarmacia?tip=0&&clienteVenta=${clienteVenta}" method="POST">
                <div class="form-group">
                                    
                <label for="recipient-name" class="col-form-label">Nombre Medicamento:</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="nombre" required>
                        <option selected></option>
                        
                        <c:forEach var="medicamento" items="${medicamentos}">
                        <option value="${medicamento.getId()}">${medicamento.getNombre()}</option>
                        </c:forEach>
                    </select><br>
                                    
                <label for="recipient-name" class="col-form-label" >Cantidad:</label>
                <input type="number" min="1" name="cantidad" required/>

                <label for="recipient-name" class="col-form-label" >Fecha de Venta:</label>
                <input type="date" value="${fechaVenta}" name="fecha" required readonly/><br><br>
                                   
                <input type="submit" value="Agregar">
                                   
                </div>
            </form>
            
            
            
        </div>
        <c:if test="${requestScope['termina'] != null}" >
        <div>
            <form action="VentaFarmacia?tip=2&&fecha1=${fechaVenta}" method="POST">
                <div class="form-group">
                                                      
                <input type="submit" value="Terminar Venta">
                                   
                </div>
            </form>
        </div>
        </c:if>
                
        
        <c:if test="${requestScope['venta2'] != null}" >
            <h2><b>Total de Venta = ${totalCompleto}</b></h2><br>
            <h3><b>Cliente: ${clienteVenta}</b></h3><br>
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
