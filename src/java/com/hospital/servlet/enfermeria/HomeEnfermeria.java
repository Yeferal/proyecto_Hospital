/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.enfermeria;

import com.hosipital.enfermeria.ListaEnfermeria;
import com.hospital.farmacia.ListaFarmacia;
import com.hospital.farmacia.RegistroVenta;
import com.hospital.recursoshumanos.RegistroPago;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Venta;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author yefer
 */
@WebServlet(name = "HomeEnfermeria", urlPatterns = {"/HomeEnfermeria"})
public class HomeEnfermeria extends HttpServlet {

    ListaEnfermeria lista = new ListaEnfermeria();
    
    RegistroPago registro = new RegistroPago();
    Usuario usuario = new Usuario("","");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesionUser = request.getSession();
        
        usuario.setId(Integer.parseInt(sesionUser.getAttribute("Usuario").toString()));
        usuario = registro.getUsuario(usuario.getId());
        
        request.setAttribute("pacientes", lista.listarPacientes(usuario.getId()));
        request.setAttribute("medicamentos", lista.listarMedicamentos());
        request.setAttribute("datos", lista.getHistoria());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-enfermeria.jsp");
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
        processRequest(request, response);
    }



}
