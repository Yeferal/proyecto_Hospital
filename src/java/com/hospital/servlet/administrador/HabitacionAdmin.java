/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.administrador;

import com.hospital.administrador.AdministracionHabitacion;
import com.hospital.administrador.ListaAdministracion;
import com.mycompany.hospital.Habitacion;
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
@WebServlet(name = "HabitacionAdmin", urlPatterns = {"/HabitacionAdmin"})
public class HabitacionAdmin extends HttpServlet {

    ListaAdministracion lista = new ListaAdministracion();
    AdministracionHabitacion adminHabitacion = new AdministracionHabitacion();
    Habitacion h = new Habitacion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarHabitaciones() );
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-habitacion-administrador.jsp");
        dispatcher.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int tipo = Integer.parseInt(request.getParameter("tip"));
        verificarTipo(request, response, tipo);
        
    }


    private void verificarTipo(HttpServletRequest request, HttpServletResponse response, int tipo) throws ServletException, IOException{
        
        
        if(tipo==0){
           //verificarExistencia(request, response);
            
        }else if(tipo==1){
            
            enviarRegistro(request, response);
             
        }else if(tipo==2){

            h.setId(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("objetohabitacion", h);
            request.setAttribute("activo1", 1);
            request.setAttribute("datos", lista.listarHabitaciones() );
            RequestDispatcher dispatcher = request.getRequestDispatcher("page-habitacion-administrador.jsp");
            dispatcher.forward(request, response);
            
            
        }else if(tipo==3){
            enviarHabitacionEliminar(request, response);
        }
        else if(tipo==4){
            
        }
        else if(tipo==5){
            
        }
        else if(tipo==6){
            
        }
    }
    
    private void enviarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        h.setEstado(Integer.parseInt(request.getParameter("estadoH")));
        h.setCosto(Double.parseDouble(request.getParameter("costo")));
        h.setCuota(Double.parseDouble(request.getParameter("cuota")));
        System.out.println(h.getEstadoTexto());
        adminHabitacion.insertarHabitacion(h);
        
        request.setAttribute("datos", lista.listarHabitaciones() );
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-habitacion-administrador.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void enviarHabitacionEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(adminHabitacion.verificarExistenciaPaciente(id)){
            adminHabitacion.eliminarHabitacion(id);
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Se Elimino la Habitacion'); window.location='HabitacionAdmin' \"></body></html>");
             stream1.close();
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Esta habitacion no puede ser eliminada ya que esta en uso'); window.location='' \"></body></html>");
             stream1.close();
        }
    }

}
