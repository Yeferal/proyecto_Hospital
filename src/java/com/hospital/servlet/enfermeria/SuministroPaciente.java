/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.enfermeria;

import com.hosipital.enfermeria.RegistroSuministros;
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
@WebServlet(name = "SuministroPaciente", urlPatterns = {"/SuministroPaciente"})
public class SuministroPaciente extends HttpServlet {

    RegistroSuministros suministro = new RegistroSuministros();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        suministro.insertarHistorial(request.getParameter("fecha"), Integer.parseInt(request.getParameter("paciente")), Integer.parseInt(request.getParameter("medicamento")), Integer.parseInt(request.getParameter("cantidad")));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeEnfermeria");
        dispatcher.forward(request, response);
    }



}
