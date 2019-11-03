
package com.hospital.servlet.administrador;

import com.hospital.administrador.ListaAdministracion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yefer
 */
@WebServlet(name = "HomeArea", urlPatterns = {"/HomeArea"})
public class HomeArea extends HttpServlet {

    ListaAdministracion listas = new ListaAdministracion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("datos", listas.listarAreas());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-administrador.jsp");
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
        request.setAttribute("datos", listas.listarAreas());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-home-administrador.jsp");
        dispatcher.forward(request, response);
        
    }
    
    
    
    



}
