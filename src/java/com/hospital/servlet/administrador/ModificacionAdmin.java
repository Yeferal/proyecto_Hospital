/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.administrador;

import com.hospital.administrador.ListaAdministracion;
import com.hospital.administrador.RegistroModificacion;
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
@WebServlet(name = "ModificacionAdmin", urlPatterns = {"/ModificacionAdmin"})
public class ModificacionAdmin extends HttpServlet {

    RegistroModificacion registro =  new RegistroModificacion();
    Usuario u = new Usuario("","");
    ListaAdministracion lista = new ListaAdministracion();
    
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
                request.setAttribute("objetoModificacion", u);
                request.setAttribute("activo4", 1);
                redireccionar(request, response);
            
        }else if(tipo==2){
            enviarModificacion(request, response);
            
        }
    }
    
    private void enviarModificacion(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        
        u.setNombre(request.getParameter("nombreempleado"));
        u.setCui(request.getParameter("cuiempleado"));
        u.setCodigo(request.getParameter("codigoempleado"));
        if(request.getParameter("irtrampleado").isEmpty()){
            u.setIrtra(0);
        }else{
            u.setIrtra(Double.parseDouble(request.getParameter("irtrampleado")));
        }
        
        if(request.getParameter("igssempleado").isEmpty()){
            u.setIgss(0);
        }else{
            u.setIgss(Double.parseDouble(request.getParameter("igssempleado")));
        }
        u.setSalario(Double.parseDouble(request.getParameter("salarioempleado")));
        u.setTipo(request.getParameter("tipoempleado"));
        u.setJefe(1);
        
        String fecha = request.getParameter("fecha");
        
        registro.modificarEmpleado(u, "Modificacion de datos", fecha);
        
        ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('El empleado fue Modificado'); window.location='ModificacionAdmin' \"></body></html>");
        stream1.close();
        
    }
    
    
    
    public void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("datos", lista.listarEmpleadosAdministracion());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-empleados-administracion.jsp");
        dispatcher.forward(request, response);
    }



}
