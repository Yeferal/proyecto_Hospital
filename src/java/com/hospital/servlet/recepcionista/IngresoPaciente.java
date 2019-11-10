
package com.hospital.servlet.recepcionista;

import com.hospital.recepcionista.RegistroAsignacion;
import com.hospital.recepcionista.RegistroPaciente;
import com.mycompany.hospital.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IngresoPaciente", urlPatterns = {"/IngresoPaciente"})
public class IngresoPaciente extends HttpServlet {

    RegistroAsignacion registroA = new RegistroAsignacion();
    RegistroPaciente registroP = new RegistroPaciente();
    Paciente p = new Paciente();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String cui = request.getParameter("cui");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        int edad = Integer.parseInt(request.getParameter("edad"));
        int habitacion = Integer.parseInt(request.getParameter("habitacion"));
        String fechaIngreso = request.getParameter("fechaIngreso");
        
        p.setDatos(0, edad, habitacion, nombre, cui, fechaNacimiento, fechaIngreso);
        
        registroP.insertarPaciente(p);
        
        p.setId(registroP.getIdUltimoUsuario());
        
        int idMedico = Integer.parseInt(request.getParameter("medico"));
        int idEnfermero = Integer.parseInt(request.getParameter("enfermero"));
        
        
        registroA.insertarAsignacion(p, idMedico, idEnfermero);
        
        
        ServletOutputStream stream1 = response.getOutputStream();
                stream1.print("<html><head></head><body onload=\"alert('Paciente ingresado'); window.location='RecepcionPaciente' \"></body></html>");
             stream1.close();
        
    }


}
