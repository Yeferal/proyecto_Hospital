/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.farmacia;

import com.hospital.farmacia.ListaFarmacia;
import com.hospital.farmacia.RegistroCompra;
import com.mycompany.hospital.Compra;
import com.mycompany.hospital.Medicamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CompraFarmacia", urlPatterns = {"/CompraFarmacia"})
public class CompraFarmacia extends HttpServlet {

    ListaFarmacia lista = new ListaFarmacia();
    List<Compra> listaCompra = new ArrayList<>();
    RegistroCompra registro = new RegistroCompra();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-compra-medicamento.jsp");
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
        if(tipo==1){
            listarDatos(request, response);
            
            
        }else if(tipo == 2){
            String fecha = (String) request.getParameter("fecha1");

            registro.insertarCompra(listaCompra, fecha);
        }else{
            apilarCompra(request, response);
        }
    }

    
    private void listarDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String fecha = request.getParameter("fecha");
        request.setAttribute("medicamentos", lista.listarMedicamentos());
        request.setAttribute("compra1", 1);
        request.setAttribute("fechaCompra", fecha);
        request.setAttribute("opcion", 1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-compra-medicamento.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apilarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        
        String fecha = request.getParameter("fecha");
        request.setAttribute("medicamentos", lista.listarMedicamentos());
        request.setAttribute("compra1", 1);
        request.setAttribute("compra2", 1);
        request.setAttribute("fechaCompra", fecha);
        request.setAttribute("opcion", 1);
        request.setAttribute("termina", 1);
        
        int cantidad =  Integer.parseInt(request.getParameter("cantidad"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        double total = precio*cantidad;
        
        if(request.getAttribute("listado")!=null){
            listaCompra = (List<Compra>) request.getAttribute("listado");
        }
        
        
        
        Compra c = new Compra(request.getParameter("nombre"), precio,cantidad, total);
        
        listaCompra.add(c);
        request.setAttribute("datos", listaCompra);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-compra-medicamento.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void registroCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }

}
