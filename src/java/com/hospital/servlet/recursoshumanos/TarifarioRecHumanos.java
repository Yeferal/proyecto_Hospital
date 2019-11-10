/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ListaRecursosHumanos;
import com.hospital.recursoshumanos.RegistroTarifario;
import com.mycompany.hospital.Tarifa;
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
@WebServlet(name = "TarifarioRecHumanos", urlPatterns = {"/TarifarioRecHumanos"})
public class TarifarioRecHumanos extends HttpServlet {

    Tarifa t = new Tarifa();
    ListaRecursosHumanos lista = new ListaRecursosHumanos();
    RegistroTarifario registro = new RegistroTarifario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarTarifas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-tarifario-rec-hum.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            t.setTipo(request.getParameter("nombreTipo"));
            t.setPrecio(Double.parseDouble(request.getParameter("precio")));
            t.setCosto(Double.parseDouble(request.getParameter("costo")));
            t.setCuota(Double.parseDouble(request.getParameter("cuota")));
            
            registro.insertarTarifa(t);
            
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('Se agrego la Nueva Tarifa'); window.location='TarifarioRecHumanos' \"></body></html>");
            stream1.close();
    }


}
