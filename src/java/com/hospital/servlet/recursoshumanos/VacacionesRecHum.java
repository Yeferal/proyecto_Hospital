
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ControlVacaciones;
import com.hospital.recursoshumanos.RegistroDespido;
import com.hospital.recursoshumanos.RegistroVacaciones;
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

    ControlVacaciones control = new ControlVacaciones();
    RegistroDespido r = new RegistroDespido();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", control.listarVacaciones());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-vacaciones-rec-hum.jsp");
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
            case 0:
                request.setAttribute("actual", control.getFechaActual());
                request.setAttribute("activo1", 1);
                redireccionar(request, response);
                break;
            case 1:
                
                
                enviarFecha(request, response);
                System.out.println("Fecha inicio: "+request.getParameter("fecha")+"    Fecha finaliza:"+control.obtenerFechaFinalizacion(request.getParameter("fecha")));
                
                break;
            case 2:
                request.setAttribute("activo2", 1);
                redireccionar(request, response);
                break;
            case 3:
                break;
            case 4:
                request.setAttribute("actual", control.getFechaActual());
                request.setAttribute("activo3", 1);
                redireccionar(request, response);
                break;
            case 5:
                
                break;
            default:
                break;
        }
    }
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("datos", control.listarVacaciones());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-vacaciones-rec-hum.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarFecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String fechaSeleccionada = request.getParameter("fecha");
        
        control.enviarRegistro(r.getUsuario(id), fechaSeleccionada);
        
        ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('Se agrego la fecha de Vacaciones'); window.location='OtrosAdmin' \"></body></html>");
        stream1.close();
        
    }


}
