
package com.hospital.servlet.administrador;

import com.hospital.administrador.RegistroNormativo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OtrosAdmin", urlPatterns = {"/OtrosAdmin"})
public class OtrosAdmin extends HttpServlet {
    
    RegistroNormativo registro = new RegistroNormativo();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("objeto", registro.getDiasVacaciones());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-otros-administracion.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dias = Integer.parseInt(request.getParameter("dias"));
        
        
        registro.cambairNormativo(dias);
        
        try (ServletOutputStream stream1 = response.getOutputStream()) {
            stream1.print("<html><head></head><body onload=\"alert('Se cambio el normativo'); window.location='OtrosAdmin' \"></body></html>");
        }
        
    }


}
