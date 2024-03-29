/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.RegistroContrato;
import com.mycompany.hospital.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "Contrato", urlPatterns = {"/Contrato"})
public class Contrato extends HttpServlet {

    RegistroContrato registro = new RegistroContrato();
    Usuario usuario = new Usuario("","");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuario.setNombre(request.getParameter("nombreempleado"));
        usuario.setCui(request.getParameter("cuiempleado"));
        usuario.setCodigo(request.getParameter("codigoempleado"));
        if(request.getParameter("irtrampleado").isEmpty()){
            usuario.setIrtra(0);
        }else{
            usuario.setIrtra(Double.parseDouble(request.getParameter("irtrampleado")));
        }
        
        if(request.getParameter("igssempleado").isEmpty()){
            usuario.setIgss(0);
        }else{
            usuario.setIgss(Double.parseDouble(request.getParameter("igssempleado")));
        }
        usuario.setSalario(Double.parseDouble(request.getParameter("salarioempleado")));
        usuario.setTipo(request.getParameter("tipoempleado"));
        usuario.setJefe(Integer.parseInt(request.getParameter("jefe")));
        String fecha = request.getParameter("fecha");

        if(!registro.verificarContrato(usuario.getCui())){
            registro.insertarContratoEmpleado(usuario, "Contrato", fecha);
            
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Se Agrego el Contrato'); window.location='HomeRecursosHumanos' \"></body></html>");
             stream1.close();
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('El empleado ya tiene un contrato'); window.location='HomeRecursosHumanos' \"></body></html>");
             stream1.close();
        }
    }

}
