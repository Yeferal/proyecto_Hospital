/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ListaRecursosHumanos;
import com.hospital.recursoshumanos.RegistroEspecialista;
import com.mycompany.hospital.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Especialistas", urlPatterns = {"/Especialistas"})
public class Especialistas extends HttpServlet {

    ListaRecursosHumanos lista = new ListaRecursosHumanos();
    RegistroEspecialista registro = new RegistroEspecialista();
    Usuario u = new Usuario("","");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarEspecialistas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-especialistas-rec-hum.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("tip"));
        
        if(tipo==0){
            enviarDatosEspecialista(request, response);
        }else if(tipo==1){
            enviarDatosEliminar(request, response);
        }
        
    }
    
    
    private void enviarDatosEspecialista(HttpServletRequest request, HttpServletResponse response) throws IOException{
        u.setNombre(request.getParameter("nombre"));
        u.setCui(request.getParameter("cui"));
        
        if(!registro.verficarExistenciaEspecialista(u.getCui())){
            registro.insertarEspecialista(u);
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('El especialista fue agregado a la planilla'); window.location='Especialistas' \"></body></html>");
            stream1.close();
            
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('El especialista ya esta dentro de la planilla o existe un especialista con el mismo CUI'); window.location='Especialistas' \"></body></html>");
            stream1.close();
        }
    }
    
    private void enviarDatosEliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        registro.eliminarEspecialista(id);
        ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('El especialista fue eliminado de la planilla'); window.location='Especialistas' \"></body></html>");
            stream1.close();
        
    }

    
    


}
