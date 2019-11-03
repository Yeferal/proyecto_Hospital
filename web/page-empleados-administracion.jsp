<%-- 
    Document   : page-empleados-administracion
    Created on : 1/11/2019, 11:50:59 PM
    Author     : yefer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospital</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
        <link rel="stylesheet" href="css/stiloModal.css">
        <%@include file="header.html" %>
    </head>
    <body>
        
        <%@include file="navegacion-administrador.html" %>
        <div>

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModaln">
                              Contratar Empleado
                </button>
                <form action="#" method="">
                    <input type="submit" value="Cambio Salarial" class="btn btn-primary">
                </form>
                <form action="#" method="" >
                    <input type="submit" value="Despedir" class="btn btn-primary">
                </form>
                <form action="#" method="" >
                    <input type="submit" value="Renuncia" class="btn btn-primary">
                </form>
                <form action="#" method="" >
                    <input type="submit" value="Aumento Salarial" class="btn btn-primary">
                </form>

    </div>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModaln" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Contratar Empleado</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                  
                                <form action="EmpleadoAdmin?tip=1" method="POST">
                                <div class="form-group">
                                    
                                    <label for="recipient-name" class="col-form-label" >Nombre del Empleado:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="nombreempleado" placeholder="Nombre" required><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >CUI del Empleado:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="cuiempleado" placeholder="CUI" required><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >Codigo del Empleado:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="codigoempleado" placeholder="Codigo" required><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >Porcentaje de Irtra:</label>
                                    <input type="number" step="0.01" name="irtrampleado"/><br>
                                    
                                    <label for="recipient-name" class="col-form-label">Porcentaje de Igss:</label>
                                    <input type="number" step="0.01" name="igssempleado"/><br>
                                    
                                    <label for="recipient-name" class="col-form-label" >Salario:</label>
                                    <input type="number" step="0.01" name="salarioempleado" required/><br>
                                    
                                    <label for="recipient-name" class="col-form-label">Tipo:</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="tipoempleado" required>
                                        <option selected ></option>
                                        <option value="Gerente">Gerente</option>
                                        <option value="Recursos Humanos">Recursos Humanos</option>
                                        <option value="Administrador">Administrador</option>
                                      </select><br><br>
                                      <label for="recipient-name" class="col-form-label" >Fecha de Contratacion:</label>
                                      <input type="date" name="fecha" required/><br><br>
                                      
                                    <input type="submit" value="Contratar">
                                    
                                    </div>
                                    
                              </form>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                              </div>
                            </div>
                          </div>
                        </div>
            
        </div>
    </body>
</html>
