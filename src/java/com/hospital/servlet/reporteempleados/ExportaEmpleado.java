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
@WebServlet(name = "ExportaEmpleado", urlPatterns = {"/ExportaEmpleado"})
public class ExportaEmpleado extends HttpServlet {

    ListaReporteEmpleados reporte = new ListaReporteEmpleados();
    ListaRecursosHumanos listas = new ListaRecursosHumanos();
    ExportaReporte exporta = new ExportaReporte();
    
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
        int tipo =  Integer.parseInt(request.getParameter("tip"));
        
        switch (tipo) {
            case 1:
                
                enviarReporte1(request, response);
                
                break;
            case 2:
                enviarReporte2(request, response);
                break;
            case 3:
                enviarReporte3(request, response);
                break;
            default:
                break;
        }
    }
    
    private void enviarReporte1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texto ="";
        String fecha2 = "NOW()";
        String fecha1 = "'0'";
        
        if(!request.getParameter("area").isEmpty()){
           texto = request.getParameter("area"); 
        }
        if(!request.getParameter("fecha1").isEmpty()){
           fecha1 = "'"+request.getParameter("fecha1")+"'"; 
        }
        if(!request.getParameter("fecha2").isEmpty()){
           fecha2 = "'"+request.getParameter("fecha2")+"'"; 
        }
        
        request.setAttribute("fech1", request.getParameter("fecha1"));
        request.setAttribute("fech2", request.getParameter("fecha2"));
        request.setAttribute("texh", texto);
        
        request.setAttribute("objetoarea", listas.listarAreas());
        request.setAttribute("datos", reporte.listarEmpleados(texto, fecha2, fecha1));
        //envair al reporte
        
        exporta.imprimir1(reporte.listarEmpleados(texto, fecha2, fecha1));
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte1-empleados.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarReporte2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texto ="";
        String fecha2 = "NOW()";
        String fecha1 = "'0'";
        
        if(!request.getParameter("area").isEmpty()){
           texto = request.getParameter("area"); 
        }
        if(!request.getParameter("fecha1").isEmpty()){
           fecha1 = "'"+request.getParameter("fecha1")+"'"; 
        }
        if(!request.getParameter("fecha2").isEmpty()){
           fecha2 = "'"+request.getParameter("fecha2")+"'"; 
        }
        
        request.setAttribute("fech1", request.getParameter("fecha1"));
        request.setAttribute("fech2", request.getParameter("fecha2"));
        request.setAttribute("texh", texto);
        
        request.setAttribute("objetoarea", listas.listarAreas());
        request.setAttribute("datos", reporte.listarEmpleadosRetiro(texto, fecha2, fecha1));
        //envair al reporte
        
        exporta.imprimir2(reporte.listarEmpleadosRetiro(texto, fecha2, fecha1));
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte2-empleados.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarReporte3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("opcion").equals("0")){
            exporta.imprimir3(reporte.listarEmpleadosMedicosAsignados());
            request.setAttribute("opti", 0);
            request.setAttribute("datos", reporte.listarEmpleadosMedicosAsignados());
        }else{
            exporta.imprimir3(reporte.listarEmpleadosMedicosDesAsignados());
            request.setAttribute("opti", 1);
            request.setAttribute("datos", reporte.listarEmpleadosMedicosDesAsignados());
        }
        
        //envair al reporte
        
        
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte3-empleados.jsp");
        dispatcher.forward(request, response);
    }



}
