/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.reporte.administracion;

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
@WebServlet(name = "ReporteGanaciasAdministracion", urlPatterns = {"/ReporteGanaciasAdministracion"})
public class ReporteGanaciasAdministracion extends HttpServlet {

    ListaGanacia lista = new ListaGanacia();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha2 = "NOW()";
        String fecha1 = "0";

        request.setAttribute("fec1", fecha1);
        request.setAttribute("fec2", fecha2);
        request.setAttribute("datos1", lista.getGananciaCuenta(fecha1, fecha2));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-administracion.jsp");
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
        String fecha2 = "NOW()";
        String fecha1 = "0";

        request.setAttribute("fec1", fecha1);
        request.setAttribute("fec2", fecha2);
        request.setAttribute("datos1", lista.getGananciaCuenta(fecha1, fecha2));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-administracion.jsp");
        dispatcher.forward(request, response);
    }



}
