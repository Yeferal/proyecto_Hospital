/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.farmacia;

import com.hospital.farmacia.ListaFarmacia;
import com.hospital.farmacia.RegistroInventario;
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
@WebServlet(name = "Inventario", urlPatterns = {"/Inventario"})
public class Inventario extends HttpServlet {

    ListaFarmacia lista = new ListaFarmacia();
    RegistroInventario registro = new RegistroInventario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarMedicamentos());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-inventario-farmacia.jsp");
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
        int id = Integer.parseInt(request.getParameter("id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        registro.actualizarInventario(id, cantidad);
        
        request.setAttribute("datos", lista.listarMedicamentos());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-inventario-farmacia.jsp");
        dispatcher.forward(request, response);
        
    }


}
