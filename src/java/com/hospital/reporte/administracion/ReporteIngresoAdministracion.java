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
@WebServlet(name = "ReporteIngresoAdministracion", urlPatterns = {"/ReporteIngresoAdministracion"})
public class ReporteIngresoAdministracion extends HttpServlet {
ListaReporteAdministracion lista =  new ListaReporteAdministracion();
    
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
        String fecha2 = "NOW()";
        String fecha1 = "0";
        
        if(!request.getParameter("fecha1").isEmpty()){
           fecha1 = "'"+request.getParameter("fecha1")+"'"; 
        }
        if(!request.getParameter("fecha2").isEmpty()){
           fecha2 = "'"+request.getParameter("fecha2")+"'"; 
        }
        
        request.setAttribute("fech1", fecha1);
        request.setAttribute("fech2", fecha2);
        request.setAttribute("datos1", lista.getIngresosFarmacia(fecha1, fecha2));
        request.setAttribute("datos2", lista.getIngresosConsulta(fecha1, fecha2));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte1-administracion.jsp");
        dispatcher.forward(request, response);
    }



}
