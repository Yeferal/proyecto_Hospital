/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosipital.medico;

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
@WebServlet(name = "HomeMedico", urlPatterns = {"/HomeMedico"})
public class HomeMedico extends HttpServlet {

    ListaMedico lista=  new ListaMedico();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("operaciones", lista.listarTarifas());
        request.setAttribute("pacientes", lista.listarPacientes());
        request.setAttribute("medicos", lista.listarMedicos());
        request.setAttribute("datos", lista.listarOperaciones());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-medico.jsp");
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
        processRequest(request, response);
    }


}
