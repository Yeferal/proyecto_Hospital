/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.iniciosesion;

import com.mycompany.hospital.Usuario;
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
@WebServlet(name = "LoginSesion", urlPatterns = {"/LoginSesion"})
public class LoginSesion extends HttpServlet {

    Usuario usuario = new Usuario();
    SesionUsuario sesion = new SesionUsuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cui = request.getParameter("nombre");
        String pass = request.getParameter("passwrd");
        request.getSession().invalidate();
        
        if(sesion.isExisteUsuario(cui) && sesion.isPasswordUsuario(cui, pass)){
            HttpSession sesionUser = request.getSession(true);
            usuario = sesion.setUsuario(cui, pass);
            
            sesionUser.setAttribute("Usuario",usuario.getId());
            System.out.println("dsds");
            RequestDispatcher dispatcher = request.getRequestDispatcher(encontrartipoPagina());
            dispatcher.forward(request, response);
        }else{
            request.setAttribute("error", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("page-login.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private String encontrartipoPagina(){
        System.out.println("Tipo: "+usuario.getTipo());
        switch(usuario.getTipo()){
            case "Administrador":
                return "HomeArea";
            case "":
                
        }
        
            return "";
        
    }

}
