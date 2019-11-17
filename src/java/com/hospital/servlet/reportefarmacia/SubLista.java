/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.reportefarmacia;

import com.hospital.farmacia.ListaReporte;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SubLista", urlPatterns = {"/SubLista"})
public class SubLista extends HttpServlet {

    ListaReporte reporte = new ListaReporte();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String texto ="";
        String fecha1 = "NOW()";
        String fecha2 = "0";
        
        if(!request.getParameter("nombre").isEmpty()){
           texto = request.getParameter("nombre");
        }
        if(!request.getParameter("fec1").equalsIgnoreCase("") && !request.getParameter("fec1").equalsIgnoreCase("NOW()")){
           fecha1 = request.getParameter("fec1"); 
        }
        if(!request.getParameter("fec2").isEmpty()){
           fecha2 = request.getParameter("fec2"); 
        }
        
        System.out.println(texto+fecha1+fecha2);
        reporte.conectar();
        request.setAttribute("datos", reporte.getVentas(texto, fecha1, fecha2,Double.parseDouble(request.getParameter("costo"))));
        reporte.desconectar();
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-sublistado-farmacia.jsp");
        dispatcher.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
