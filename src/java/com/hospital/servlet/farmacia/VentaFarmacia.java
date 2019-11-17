/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.farmacia;

import com.hospital.farmacia.ListaFarmacia;
import com.hospital.farmacia.RegistroVenta;
import com.hospital.recursoshumanos.RegistroPago;
import com.mycompany.hospital.Compra;
import com.mycompany.hospital.Medicamento;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yefer
 */
@WebServlet(name = "VentaFarmacia", urlPatterns = {"/VentaFarmacia"})
public class VentaFarmacia extends HttpServlet {

    RegistroPago registro = new RegistroPago();
    ListaFarmacia lista = new ListaFarmacia();
    List<Venta> listaVenta = new ArrayList<>();
    RegistroVenta ventas = new RegistroVenta();
    Usuario usuario = new Usuario("","");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionUser = request.getSession();
        
        usuario.setId(Integer.parseInt(sesionUser.getAttribute("Usuario").toString()));
        usuario = registro.getUsuario(usuario.getId());

            request.setAttribute("empleado", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("page-venta-medicamento.jsp");
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
        int tipo = Integer.parseInt(request.getParameter("tip"));
        
        if(tipo == 1){
            listarDatos(request, response);
            
        }else if(tipo == 2){
            String fecha = (String) request.getParameter("fecha1");

            ventas.insertarVenta(listaVenta, fecha);
            ServletOutputStream stream1 = response.getOutputStream();
            stream1.print("<html><head></head><body onload=\"alert('El total de la compra fue de: "+ventas.calcularTotal(listaVenta)+"'); window.location='page-venta-medicamento.jsp' \"></body></html>");
            stream1.close();
        }else{
            apilarVenta(request, response);
        }
        
        
        
        
    }
    
    
    private void listarDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String fecha = request.getParameter("fecha");
        String cliente = request.getParameter("nombreCliente");
        request.setAttribute("medicamentos", lista.listarMedicamentos());
        request.setAttribute("venta1", 1);
        request.setAttribute("fechaVenta", fecha);
        request.setAttribute("opcion", 1);
        request.setAttribute("clienteVenta", cliente);
        listaVenta = new ArrayList<>();

        RequestDispatcher dispatcher = request.getRequestDispatcher("page-venta-medicamento.jsp");
        dispatcher.forward(request, response);
    }

    private void apilarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("nombre"));
        Medicamento m = lista.getMedicamento(id);
        int cantidad =  Integer.parseInt(request.getParameter("cantidad"));
        double precio = m.getPrecio();
        
        double total = precio*cantidad;
        String fecha = request.getParameter("fecha");
        request.setAttribute("medicamentos", lista.listarMedicamentos());
        request.setAttribute("venta1", 1);
        request.setAttribute("venta2", 1);
        request.setAttribute("fechaVenta", fecha);
        request.setAttribute("opcion", 1);
        request.setAttribute("termina", 1);
        request.setAttribute("clienteVenta", request.getParameter("clienteVenta"));
        
        if(lista.getCantidadMedicamento(id, cantidad)){

            if(request.getAttribute("listado")!=null){
                listaVenta= (List<Venta>) request.getAttribute("listado");
            }

            Venta v = new Venta(usuario.getNombre(),request.getParameter("clienteVenta"),m.getNombre(), precio,cantidad, total);

            listaVenta.add(v);
            
        }else{
            request.setAttribute("activo1", 1);

        }
        request.setAttribute("datos", listaVenta);
            request.setAttribute("totalCompleto",ventas.calcularTotal(listaVenta));

            RequestDispatcher dispatcher = request.getRequestDispatcher("page-venta-medicamento.jsp");
            dispatcher.forward(request, response);
        
        
        
    }

}
