/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.administrador;

import com.hospital.administrador.AdministracionArea;
import com.mycompany.hospital.Area;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AreaAdmin", urlPatterns = {"/AreaAdmin"})
public class AreaAdmin extends HttpServlet {

    AdministracionArea admArea = new AdministracionArea();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("modal-nuevo-area.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("tip"));
        verficacion(request, response, tipo);
//        request.setAttribute("modal1", 1);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-administrador.jsp");
//        dispatcher.forward(request, response);
        
    }
    
    private void verficacion(HttpServletRequest request, HttpServletResponse response, int tipo) throws IOException, ServletException{
        switch (tipo) {
            case 0:
                verificarExistencia(request, response);
                break;
            case 2:
                admArea.eliminarArea(Integer.parseInt(request.getParameter("id")));
                ServletOutputStream stream1 = response.getOutputStream();
                stream1.print("<html><head></head><body onload=\"alert('Se Elimino el Area'); window.location='HomeArea' \"></body></html>");
                stream1.close();
                break;
            case 1:
                {
                    Area area = new Area(request.getParameter("nombres"));
                    area.setId(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("objetoarea", area);
                    request.setAttribute("activo2", 1);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("HomeArea");
                    dispatcher.forward(request, response);
                    break;
                }
            case 3:
                enviarModificacion(request, response);
                break;
            case 5:
                {
                    Area area = new Area(request.getParameter("nombres"));
                    area.setId(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("objeto", area);
                    request.setAttribute("activo1", 1);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("HomeArea");
                    dispatcher.forward(request, response);
                    break;
                }
            default:
                break;
        }
    }
    
    private void verificarExistencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(!admArea.verificarExistencia(request.getParameter("nombreArea"))){
            String nombreArea = request.getParameter("nombreArea");
        
            admArea.insertarArea(nombreArea);
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("HomeArea");
            dispatcher.forward(request, response);
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('El area ya existe'); window.location='HomeArea' \"></body></html>");
             stream1.close();
        }
    }
    
    private void enviarModificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(!admArea.verificarExistencia(request.getParameter("nombreArea"))){
            String nombreArea = request.getParameter("nombreArea");
            
            admArea.modificarArea(Integer.parseInt(request.getParameter("id")),nombreArea);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("HomeArea");
            dispatcher.forward(request, response);
        }else{
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Ya existe un area con ese Nombre'); window.location='HomeArea' \"></body></html>");
             stream1.close();
        }
    }



}
