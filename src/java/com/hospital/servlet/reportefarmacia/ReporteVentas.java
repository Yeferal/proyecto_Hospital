/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.reportefarmacia;

import com.hospital.farmacia.ReporteEmpleadosFarmacia;
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
@WebServlet(name = "ReporteVentas", urlPatterns = {"/ReporteVentas"})
public class ReporteVentas extends HttpServlet {

    ReporteEmpleadosFarmacia reporte = new ReporteEmpleadosFarmacia();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("datos", reporte.listarReporteVentas(""));
        
        String texto ="";
        String fecha1 = "NOW()";
        String fecha2 = "0";
        
        request.setAttribute("tex", texto);
        request.setAttribute("fec1", fecha1);
        request.setAttribute("fec2", fecha2);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-farmacia.jsp");
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
        String texto ="";
        
        if(!request.getParameter("texto").isEmpty()){
           texto = request.getParameter("texto"); 
        }

        if(request.getParameter("opcion").equals("0")){
            request.setAttribute("datos", reporte.listarReporteVentas(texto));
        }else{
            request.setAttribute("datos", reporte.listarReporteVentasCUI(texto));
        }
        
        if(request.getParameter("tip")==null){
            request.setAttribute("texh", texto);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-farmacia.jsp");
        dispatcher.forward(request, response);
        }else{
            
        }
        
        
        
    }



}
