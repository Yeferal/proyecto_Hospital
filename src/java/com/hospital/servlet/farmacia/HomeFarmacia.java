/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.farmacia;

import com.hospital.farmacia.ListaFarmacia;
import com.hospital.recursoshumanos.ListaPersonal;
import com.hospital.recursoshumanos.RegistroPago;
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
@WebServlet(name = "HomeFarmacia", urlPatterns = {"/HomeFarmacia"})
public class HomeFarmacia extends HttpServlet {

    ListaPersonal listaP = new ListaPersonal();
    RegistroPago registro = new RegistroPago();
    ListaFarmacia lista = new ListaFarmacia();
    
    Usuario usuario = new Usuario("","");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionUser = request.getSession();
        
        usuario.setId(Integer.parseInt(sesionUser.getAttribute("Usuario").toString()));
        usuario = registro.getUsuario(usuario.getId());
        
        
        if(usuario.getJefe()==1){
            RequestDispatcher dispatcher = request.getRequestDispatcher("page-compra-medicamento.jsp");
            dispatcher.forward(request, response);
        }else{
            request.setAttribute("empleado", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("page-venta-medicamento.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    

}
