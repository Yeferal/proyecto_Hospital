/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.CambioSalario;
import com.hospital.recursoshumanos.ListaRecursosHumanos;
import com.mycompany.hospital.Usuario;
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
@WebServlet(name = "Salario", urlPatterns = {"/Salario"})
public class Salario extends HttpServlet {

    ListaRecursosHumanos lista = new ListaRecursosHumanos();
    Usuario u = new Usuario("","");
    CambioSalario registro =  new CambioSalario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redireccionar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    int tipo = Integer.parseInt(request.getParameter("tip"));
        
        
        if(tipo==1){
            u.setId(Integer.parseInt(request.getParameter("id")));
            System.out.println("id:"+u.getId());
            u = registro.getUsuario(u.getId());
                request.setAttribute("objetoSalario", u);
                request.setAttribute("activo1", 1);
                redireccionar(request, response);
            
        }else if(tipo==2){
            enviarSalario(request, response);
        }
    }

    private void enviarSalario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        u.setId(Integer.parseInt(request.getParameter("id")));
        u = registro.getUsuario(u.getId());
        double salario = Double.parseDouble(request.getParameter("salario"));
        String fecha = request.getParameter("fecha");
        u.setSalario(salario);
        
        registro.cambiarSalarioEmpleado(u, "Cambio de Salario", fecha);
        
        ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('Se cambio el salario del Empleado'); window.location='Salario' \"></body></html>");
        stream1.close();
        
    }

    
    
    
    public void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("datos", lista.listarEmpleadosRecursosHumanos());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-recursos-humanos.jsp");
        dispatcher.forward(request, response);
    }



}
