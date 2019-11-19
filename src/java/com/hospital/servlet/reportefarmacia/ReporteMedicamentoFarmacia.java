
package com.hospital.servlet.reportefarmacia;

import com.hospital.farmacia.ListaReporte;
import com.hospital.jasper.Jasper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReporteMedicamentoFarmacia", urlPatterns = {"/ReporteMedicamentoFarmacia"})
public class ReporteMedicamentoFarmacia extends HttpServlet {

    ListaReporte reporte = new ListaReporte();
    Jasper documento = new Jasper();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("datos", reporte.listarReporteMedicamentos(""));
        
        System.out.println(getClass().getResourceAsStream("./Farmacia1.jasper"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte1-farmacia.jsp");
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
        
        if(tipo == 0){
            request.setAttribute("texto",request.getParameter("texto"));
            request.setAttribute("datos", reporte.listarReporteMedicamentos(request.getParameter("texto")));
            redireccionar(request, response);
        }else if(tipo == 1){
            request.setAttribute("texto",request.getParameter("texto"));
            request.setAttribute("datos", reporte.listarReporteMedicamentos(request.getParameter("texto")));
            documento.imprimir(reporte.listarReporteMedicamentos(request.getParameter("texto")));
            
            redireccionar(request, response);
        }
    }
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-reporte1-farmacia.jsp");
        dispatcher.forward(request, response);
    }


}
