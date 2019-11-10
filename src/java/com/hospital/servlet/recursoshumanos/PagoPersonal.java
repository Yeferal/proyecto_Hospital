/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ListaPersonal;
import com.hospital.recursoshumanos.RegistroPago;
import com.mycompany.hospital.Pago;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author yefer
 */
@WebServlet(name = "PagoPersonal", urlPatterns = {"/PagoPersonal"})
public class PagoPersonal extends HttpServlet {

    ListaPersonal listaP = new ListaPersonal();
    RegistroPago registro = new RegistroPago();
    Pago p = new Pago();
    Usuario usuario = new Usuario();
    
    
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
        HttpSession sesionUser = request.getSession();
        
        usuario.setId(Integer.parseInt(sesionUser.getAttribute("Usuario").toString()));
        
        if(tipo == 1){
            enviarDatosEmpleado(request, response);
        }else if(tipo == 2){
            enviarDatosEspecialista(request, response);
        }
    }

    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setAttribute("objetoEmpleados", listaP.listarEmpleados());
        request.setAttribute("objetoEspecialistas", listaP.listarEspecialistas());
        request.setAttribute("datos", listaP.listarPagos());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-asignar-pagos-rec-hum.jsp");
        dispatcher.forward(request, response);
    }
    private void enviarDatosEspecialista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        usuario = registro.getUsuario(usuario.getId());
        int idE = Integer.parseInt(request.getParameter("nombre"));
        Usuario empleado = registro.getEspecialista(idE);
        p.setNombreEmpleado(empleado.getNombre());
        p.setCuiEmpleado(empleado.getCui());
        p.setFecha(request.getParameter("fecha"));
        p.setTipo("Pago Especialista");
        p.setIdGerente(usuario.getId());
        p.setNombreGerente(usuario.getNombre());
        p.setPago(Double.parseDouble(request.getParameter("pago")));
        registro.insertarPago(p);
        
        ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('El pago efectuado'); window.location='PagoPersonal' \"></body></html>");
             stream1.close();
        
        
    }
    
    private void enviarDatosEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        usuario = registro.getUsuario(usuario.getId());
        int idE = Integer.parseInt(request.getParameter("nombre"));
        Usuario empleado = registro.getEmpleado(idE);
        p.setNombreEmpleado(empleado.getNombre());
        p.setCuiEmpleado(empleado.getCui());
        p.setFecha(request.getParameter("fecha"));
        p.setTipo("Pago Empleado");
        p.setIdGerente(usuario.getId());
        p.setNombreGerente(usuario.getNombre());
        p.setPago(Double.parseDouble(request.getParameter("pago")));
        
        registro.insertarPago(p);
        
        ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('El pago efectuado'); window.location='PagoPersonal' \"></body></html>");
             stream1.close();
    }

}
