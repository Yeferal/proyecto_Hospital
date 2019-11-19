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
@WebServlet(name = "ReporteContrato", urlPatterns = {"/ReporteContrato"})
public class ReporteContrato extends HttpServlet {

    ListaReporteEmpleados reporte = new ListaReporteEmpleados();
    ListaRecursosHumanos listas = new ListaRecursosHumanos();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("datos", reporte.listarEmpleados("", "NOW()", "'0'"));
        request.setAttribute("objetoarea", listas.listarAreas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte1-empleados.jsp");
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
        String fecha1 = "NOW()";
        String fecha2 = "'0'";
        
        if(!request.getParameter("tipoempleado").isEmpty()){
           texto = request.getParameter("tipoempleado"); 
        }
        if(!request.getParameter("fecha1").isEmpty()){
           fecha1 = "'"+request.getParameter("fecha1")+"'"; 
        }
        if(!request.getParameter("fecha2").isEmpty()){
           fecha2 = "'"+request.getParameter("fecha2")+"'"; 
        }
        System.out.println(texto+fecha1+fecha2);
        
        request.setAttribute("fech2", request.getParameter("fecha1"));
        request.setAttribute("fech1", request.getParameter("fecha2"));
        request.setAttribute("texh", texto);
        request.setAttribute("area", texto);
        
        request.setAttribute("objetoarea", listas.listarAreas());
        request.setAttribute("datos", reporte.listarEmpleados(texto, fecha1, fecha2));
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte1-empleados.jsp");
        dispatcher.forward(request, response);
    }


}
