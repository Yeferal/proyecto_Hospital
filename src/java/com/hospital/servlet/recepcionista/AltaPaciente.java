/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recepcionista;

import com.hospital.recepcionista.ListaRecepcion;
import com.hospital.recursoshumanos.RegistroAltaPaciente;
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
@WebServlet(name = "AltaPaciente", urlPatterns = {"/AltaPaciente"})
public class AltaPaciente extends HttpServlet {

    ListaRecepcion lista = new ListaRecepcion();
    RegistroAltaPaciente registro = new RegistroAltaPaciente();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redireccionar(request, response);
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
        if(tipo == 1){
            request.setAttribute("idPaciente", request.getParameter("id"));
            request.setAttribute("activo5", 1);
            redireccionar(request, response);
        }else{
            
            
            registro.insertarAlta(registro.getPaciente(Integer.parseInt(request.getParameter("id"))), request.getParameter("fecha"));
            
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('Paciente fue dado de Alta'); window.location='Home' \"></body></html>");
            stream1.close();
            
        }
    }
    
    public void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        request.setAttribute("datos", lista.listarPacientes());
        request.setAttribute("enfermeros", lista.listarEnfermeros());
        request.setAttribute("medicos", lista.listarMedicos());
        request.setAttribute("habitaciones", lista.listarHabitacionesDisponibles());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-recepcionista.jsp");
        dispatcher.forward(request, response);
        
    }

}
