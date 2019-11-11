
package com.hospital.servlet.recepcionista;

import com.hospital.conexiones.Conexion;
import com.hospital.recepcionista.RegistroAsignacion;
import com.mycompany.hospital.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsignacionPaciente", urlPatterns = {"/AsignacionPaciente"})
public class AsignacionPaciente extends HttpServlet {

    private RegistroAsignacion registro = new RegistroAsignacion();
    private Conexion c = new Conexion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("tip"));        
        switch (tipo) {
            case 1:
                request.setAttribute("activo1", 1);
                request.setAttribute("idPaciente", request.getParameter("id"));
                redireccionar(request, response);
                
                break;
            case 2:
                enviarMedico(request, response);
                break;
            case 3:
                request.setAttribute("activo2", 1);
                request.setAttribute("idPaciente", request.getParameter("id"));
                redireccionar(request, response);
                break;
            case 4:
                enviarEnfermero(request, response);
                break;
            default:
                break;
        }
        
        
        
        
        
    }
    
    private void enviarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Paciente p = registro.getPaciente(id);
            int idM = Integer.parseInt(request.getParameter("medico"));
            
            registro.asiganaMedico(p, idM);
            
            c.desconectar();
            
            redireccionar(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AsignacionPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void enviarEnfermero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Paciente p = registro.getPaciente(id);
            int idE = Integer.parseInt(request.getParameter("enfermero"));
            
            registro.asiganaEnfermero(p, idE);
            
            c.desconectar();
            
            redireccionar(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AsignacionPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("RecepcionPaciente");
        dispatcher.forward(request, response);
    }

}
