/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.caja;

import com.mycompany.hospital.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ConsultaPago", urlPatterns = {"/ConsultaPago"})
public class ConsultaPago extends HttpServlet {

    RegistroConsulta registro = new RegistroConsulta();
    
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
        Consulta consulta =  new Consulta(request.getParameter("nombre"), request.getParameter("fecha"), Double.parseDouble(request.getParameter("cuota")));
        registro.insertarConsulta(consulta);
        
        ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('Se agrego el Pago'); window.location='HomeCaja' \"></body></html>");
            stream1.close();
    }


}
