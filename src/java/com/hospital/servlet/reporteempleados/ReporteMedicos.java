/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.reporteempleados;

import com.hospital.recursoshumanos.ListaRecursosHumanos;
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
@WebServlet(name = "ReporteMedicos", urlPatterns = {"/ReporteMedicos"})
public class ReporteMedicos extends HttpServlet {

    ListaReporteEmpleados reporte = new ListaReporteEmpleados();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("opti", 0);
        request.setAttribute("datos", reporte.listarEmpleadosMedicosAsignados());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-empleados.jsp");
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
        if(request.getParameter("opcion").equals("0")){
            request.setAttribute("datos", reporte.listarEmpleadosMedicosAsignados());
        }else{
            request.setAttribute("datos", reporte.listarEmpleadosMedicosDesAsignados());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-empleados.jsp");
        dispatcher.forward(request, response);
    }


}
