
package com.hospital.servlet.recursoshumanos;

import com.hospital.recursoshumanos.ListaRecursosHumanos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HomeRecursosHumanos", urlPatterns = {"/HomeRecursosHumanos"})
public class HomeRecursosHumanos extends HttpServlet {

    ListaRecursosHumanos listas = new ListaRecursosHumanos();

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
        
        request.setAttribute("datos", listas.listarEmpleadosRecursosHumanos());
        request.setAttribute("objetoarea", listas.listarAreas());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-recursos-humanos.jsp");
        dispatcher.forward(request, response);
        
    }

}
