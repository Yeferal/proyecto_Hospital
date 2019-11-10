
package com.hospital.servlet.recepcionista;

import com.hospital.recepcionista.ListaRecepcion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RecepcionPaciente", urlPatterns = {"/RecepcionPaciente"})
public class RecepcionPaciente extends HttpServlet {

    ListaRecepcion lista = new ListaRecepcion();
    
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
        redireccionar(request, response);
    }
    
    
    public void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        request.setAttribute("datos", lista.listarPacientes());
        request.setAttribute("enfermeros", lista.listarEnfermeros());
        request.setAttribute("medicos", lista.listarMedicos());
        request.setAttribute("habitaciones", lista.listarHabitacionesDisponibles());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-recepcionista.jsp");
        dispatcher.forward(request, response);
        
    }

}
