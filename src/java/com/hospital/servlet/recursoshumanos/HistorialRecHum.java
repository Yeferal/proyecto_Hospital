/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ListaHistorial;
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
@WebServlet(name = "HistorialRecHum", urlPatterns = {"/HistorialRecHum"})
public class HistorialRecHum extends HttpServlet {

    ListaHistorial lista = new ListaHistorial();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarHistorial(""));

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-historial-rec-hum.jsp");
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
        String texto = "";
        
        if(!request.getParameter("texto").isEmpty()){
            texto =  request.getParameter("texto");
        }
        
        
        request.setAttribute("datos", lista.listarHistorial(texto));
        request.setAttribute("texto", texto);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-historial-rec-hum.jsp");
        dispatcher.forward(request, response);
    }


}
