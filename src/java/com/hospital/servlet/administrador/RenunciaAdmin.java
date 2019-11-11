
package com.hospital.servlet.administrador;

import com.hospital.administrador.ListaAdministracion;
import com.hospital.administrador.RegistroRenuncia;
import com.mycompany.hospital.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "RenunciaAdmin", urlPatterns = {"/RenunciaAdmin"})
public class RenunciaAdmin extends HttpServlet {

    RegistroRenuncia registro = new RegistroRenuncia();
    Usuario u = new Usuario("","");
    ListaAdministracion lista = new ListaAdministracion();
    
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
        int tipo = Integer.parseInt(request.getParameter("tip"));
        
        if(tipo==1){
            u.setId(Integer.parseInt(request.getParameter("id")));
            u = registro.getUsuario(u.getId());
                request.setAttribute("objetoRenuncia", u);
                request.setAttribute("activo3", 1);
                redireccionar(request, response);
        }else if(tipo==2){
            enviarRenuncia(request, response);
            
        }
        
        
        
    }
    
    
    public void enviarRenuncia(HttpServletRequest request, HttpServletResponse response) throws IOException{
        u.setId(Integer.parseInt(request.getParameter("id")));
        String fecha = request.getParameter("fecha");
        registro.insertarRenunciaEmpleado(u, "Renuncia", fecha);
        
        ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('El empleado Renuncio'); window.location='RenunciaAdmin' \"></body></html>");
             stream1.close();
        
        
    }
    
    public void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("datos", lista.listarEmpleadosAdministracion());
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-empleados-administracion.jsp");
        dispatcher.forward(request, response);
    }


}
