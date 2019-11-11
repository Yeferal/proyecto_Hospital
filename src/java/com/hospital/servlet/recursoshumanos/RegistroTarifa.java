
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ListaRecursosHumanos;
import com.hospital.recursoshumanos.RegistroTarifario;
import com.mycompany.hospital.Tarifa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegistroTarifa", urlPatterns = {"/RegistroTarifa"})
public class RegistroTarifa extends HttpServlet {

    RegistroTarifario registro = new RegistroTarifario();
    Tarifa t = null;
    ListaRecursosHumanos lista = new ListaRecursosHumanos();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", lista.listarTarifas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-tarifario-rec-hum.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("tip"));
        
        switch (tipo) {
            case 0:
                request.setAttribute("activo1", 1);
                redireccionar(request, response);
                break;
            case 1:
                enviarDatoEliminar(request, response);
                break;
            case 2:
                request.setAttribute("activo2", 1);
                redireccionar(request, response);
                break;
            case 3:
                enviarModificacion(request, response);
                break;
            default:
                break;
        }
    }
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        t = registro.getTarifa(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("objetoTarifario", t);
        request.setAttribute("datos", lista.listarTarifas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-tarifario-rec-hum.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarDatoEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        registro.eliminarTarifa(id);
        request.setAttribute("datos", lista.listarTarifas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-tarifario-rec-hum.jsp");
        dispatcher.forward(request, response);
    }
    private void enviarModificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        t = new Tarifa(request.getParameter("nombreTipo"), Double.parseDouble(request.getParameter("precio")), Double.parseDouble(request.getParameter("costo")), Double.parseDouble(request.getParameter("cuota")));
        t.setId(Integer.parseInt(request.getParameter("id")));
        
        registro.modificarTarifa(t);
        
        ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('Se Modifico la Tarifa'); window.location='TarifarioRecHumanos' \"></body></html>");
            stream1.close();
        
    }


}
