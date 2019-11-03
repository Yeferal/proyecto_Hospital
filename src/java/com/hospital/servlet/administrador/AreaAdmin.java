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
        if(tipo==0){
            verificarExistencia(request, response);
            
        }else if(tipo==2){
            admArea.eliminarArea(Integer.parseInt(request.getParameter("id")));
            
            ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Se Elimino el Area'); window.location='HomeArea' \"></body></html>");
             stream1.close();
             
        }else if(tipo==1){
            
        }else if(tipo==3){
            
        }else if(tipo==5){
            System.out.println("Entro en tipo 5");
            request.setAttribute("modal2", 1);
            Area area = new Area();
            area.setNombre(request.getParameter("nombres"));
            area.setId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("infor", area);
            RequestDispatcher dispatcher = request.getRequestDispatcher("HomeArea");
            dispatcher.forward(request, response);
            
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



}
