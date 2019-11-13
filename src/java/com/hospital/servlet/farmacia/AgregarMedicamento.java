/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.farmacia;

import com.hospital.farmacia.RegistroMedicamento;
import com.mycompany.hospital.Medicamento;
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
@WebServlet(name = "AgregarMedicamento", urlPatterns = {"/AgregarMedicamento"})
public class AgregarMedicamento extends HttpServlet {

    RegistroMedicamento registro = new RegistroMedicamento();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Medicamento m = new Medicamento(request.getParameter("nombre"), Double.parseDouble(request.getParameter("precio")),Double.parseDouble(request.getParameter("costo")) , Integer.parseInt(request.getParameter("cantidad")), Integer.parseInt(request.getParameter("minimo")));
        
        if(!registro.verificarExistencia(m.getNombre())){
            registro.insertarMedicamento(m);
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('Se agrego el nuevo Medicamento'); window.location='CompraFarmacia' \"></body></html>");
            stream1.close();
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('El medicamento ya existe'); window.location='CompraFarmacia' \"></body></html>");
            stream1.close();
        }
        
    }


}
