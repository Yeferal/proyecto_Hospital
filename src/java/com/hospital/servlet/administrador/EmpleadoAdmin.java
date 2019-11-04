/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.administrador;

import com.hospital.administrador.ListaAdministracion;
import com.hospital.administrador.RegistroContrato;
import com.mycompany.hospital.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "EmpleadoAdmin", urlPatterns = {"/EmpleadoAdmin"})
public class EmpleadoAdmin extends HttpServlet {

    RegistroContrato registro = new RegistroContrato();
    Usuario usuario = new Usuario();
    ListaAdministracion lista = new ListaAdministracion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarEmpleadosAdministracion());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-empleados-administracion.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("tip"));
        verificarTipo(request, response, tipo);
    }
    
    
    private void verificarTipo(HttpServletRequest request, HttpServletResponse response, int tipo){
        if(tipo==0){
            
        }else if(tipo==1){
            enviarContrato(request, response);
        }
    }
    
    private void enviarContrato(HttpServletRequest request, HttpServletResponse response){
        
        usuario.setNombre(request.getParameter("nombreempleado"));
        usuario.setCui(request.getParameter("cuiempleado"));
        usuario.setCodigo(request.getParameter("codigoempleado"));
        if(request.getParameter("irtrampleado").isEmpty()){
            usuario.setIrtra(0);
        }else{
            usuario.setIrtra(Double.parseDouble(request.getParameter("irtrampleado")));
        }
        
        if(request.getParameter("igssempleado").isEmpty()){
            usuario.setIrtra(0);
        }else{
            usuario.setIrtra(Double.parseDouble(request.getParameter("igssempleado")));
        }
        usuario.setSalario(Double.parseDouble(request.getParameter("salarioempleado")));
        usuario.setTipo(request.getParameter("tipoempleado"));
        usuario.setJefe(1);
        String fecha = request.getParameter("fecha");

        registro.insertarContratoEmpleado(usuario, "Contrato", fecha);
        
    }


}
