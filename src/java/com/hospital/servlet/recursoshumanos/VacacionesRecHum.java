
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ControlVacaciones;
import com.hospital.recursoshumanos.ListaPersonal;
import com.hospital.recursoshumanos.RegistroDespido;
import com.hospital.recursoshumanos.RegistroVacaciones;
import com.mycompany.hospital.Vacacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VacacionesRecHum", urlPatterns = {"/VacacionesRecHum"})
public class VacacionesRecHum extends HttpServlet {

    ListaPersonal lista = new ListaPersonal();
    RegistroDespido r = new RegistroDespido();
    RegistroVacaciones registro = new RegistroVacaciones();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redireccionar(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        switch (tipo) {
            case 0:
                
                request.setAttribute("objeto", registro.getVacacion(id));
                request.setAttribute("actual", lista.getFechaActual());
                request.setAttribute("activo1", 1);
                redireccionar(request, response);
                break;
            case 1:
                
                
                enviarFecha(request, response);
                
                break;
            case 2:
                Vacacion vacacion = registro.getVacacion(id);
                vacacion.setFechaInicio(registro.generarFechaAleatoria(lista.getFechaActual()));
                request.setAttribute("objeto", vacacion);
                request.setAttribute("activo2", 1);
                redireccionar(request, response);
                break;
            case 3:
                enviarFecha(request, response);
                
                break;
            case 4:
                request.setAttribute("objeto", registro.getVacacion(id));
                request.setAttribute("actual", lista.getFechaActual());
                request.setAttribute("activo3", 1);
                redireccionar(request, response);
                break;
            case 5:
                enviarModificacion(request, response);
                break;
            default:
                break;
        }
    }
    
    
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("datos", lista.listarVacaciones());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-vacaciones-rec-hum.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
    private void enviarFecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String fechaSeleccionada = request.getParameter("fecha");
        
        registro.insertarVacaciones(r.getUsuario(id), fechaSeleccionada);
        
        ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('Se agrego la fecha de Vacaciones'); window.location='VacacionesRecHum' \"></body></html>");
        stream1.close();
        
    }
    
    
    
    private void enviarModificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(registro.verifiacarFecha(request.getParameter("fecha"))){
            
            registro.modificarFecha(Integer.parseInt(request.getParameter("id")), request.getParameter("fecha"));
            

            ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('Se Cambio la fecha de Vacaciones'); window.location='VacacionesRecHum' \"></body></html>");
        stream1.close();
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('La fecha es muy pronta, debe de ser con una anticipacion de 7 dias'); window.location='VacacionesRecHum' \"></body></html>");
        stream1.close();
        }
    }


}
