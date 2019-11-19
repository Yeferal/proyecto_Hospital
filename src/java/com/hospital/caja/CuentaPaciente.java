/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.caja;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CuentaPaciente", urlPatterns = {"/CuentaPaciente"})
public class CuentaPaciente extends HttpServlet {

    ListaCaja lista = new ListaCaja();
    RegistroPago registro = new RegistroPago();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarPaciente(""));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-cuenta-cajero.jsp");
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
        int tipo = Integer.parseInt(request.getParameter("tip"));
        
        switch (tipo) {
            case 1:
                redireccionar(request, response);
                break;
            case 2:
                enviarDatosCuenta(request, response);
                break;
            case 3:
                enviarPago(request, response);
                break;
            default:
                break;
        }
    }
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String texto = "";
        
        if(!request.getParameter("nombre").isEmpty()){
            texto = request.getParameter("nombre");
        }
        
        request.setAttribute("texto", request.getParameter("nombre"));
        request.setAttribute("datos", lista.listarPaciente(texto));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-cuenta-cajero.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarDatosCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String nombre = request.getParameter("id");
        
        request.setAttribute("nombre", nombre);
        request.setAttribute("total", lista.getTotal(nombre));
        request.setAttribute("datos", lista.listarCuenta(nombre));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-pago-cuenta.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarPago(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String nombre = request.getParameter("nombre");
        registro.insertarPagos(nombre);
        
        ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('El pago fue efectuado'); window.location='CuentaPaciente' \"></body></html>");
        stream1.close();
    }
        


}
