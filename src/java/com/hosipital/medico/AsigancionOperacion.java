/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosipital.medico;

import com.mycompany.hospital.Operacion;
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
@WebServlet(name = "AsigancionOperacion", urlPatterns = {"/AsigancionOperacion"})
public class AsigancionOperacion extends HttpServlet {

    ListaMedico lista=  new ListaMedico();
    RegistroOperacion registro = new RegistroOperacion();
    
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
        Operacion operacion = new Operacion(request.getParameter("fecha"), lista.getPaciente(Integer.parseInt(request.getParameter("paciente"))).getNombre(), request.getParameter("medico"));
        
        registro.insertar(operacion, lista.getPaciente(Integer.parseInt(request.getParameter("paciente"))), lista.getTarifas(Integer.parseInt(request.getParameter("operacion"))));
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeMedico");
        dispatcher.forward(request, response);
    }


}
