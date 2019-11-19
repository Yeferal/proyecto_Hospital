/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.reporte.administracion;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Consulta;
import com.mycompany.hospital.IngresoConsulta;
import com.mycompany.hospital.IngresoCuenta;
import com.mycompany.hospital.IngresoFarmacia;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class ListaReporteAdministracion extends Conexion{
    
    
    
    public IngresoFarmacia getIngresosFarmacia(String fecha1,String fecha2){
        IngresoFarmacia ingreso = null;

        ingreso = new IngresoFarmacia(listarReporteVentas(fecha1, fecha2), getTotalFarmacia(fecha1, fecha2));

        return ingreso;
    }
    
    public IngresoConsulta getIngresosConsulta(String fecha1,String fecha2){
        IngresoConsulta ingreso = null;

        ingreso = new IngresoConsulta(listarReporteConsulta(fecha1, fecha2), getTotalConsulta(fecha1, fecha2));

        return ingreso;
        
    }
    public IngresoCuenta getIngresosCuenta(String fecha1,String fecha2){
        IngresoCuenta cuenta = null;
        
        return cuenta;
    }
    
    
    public double getTotalFarmacia(String fecha1,String fecha2){
        conectar();
        double total=0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT sum(total) subtotal FROM venta_medicamento WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");
            resultado.next();
            total = resultado.getDouble(1);
            desconectar();
        } catch (Exception e) {
        }
        return total;
    }
    
    public List listarReporteVentas(String fecha1,String fecha2){
        List<Venta> lista = new ArrayList<>();
        Venta v = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM venta_medicamento WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");

            while (resultado.next()) {                
                v = new Venta("","",resultado.getString(5),0,0, resultado.getDouble(7));
                v.setFecha(resultado.getString(6));
                v.setId(resultado.getInt(1));
                System.out.println(resultado.getInt(1));
                lista.add(v);
                
            }
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    
    public double getTotalConsulta(String fecha1,String fecha2){
        conectar();
        double total=0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT sum(cuota) FROM consulta WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");
            resultado.next();
            total = resultado.getDouble(1);
            desconectar();
        } catch (Exception e) {
        }
        return total;
    }
    
    public List listarReporteConsulta(String fecha1,String fecha2){
        List<Consulta> lista = new ArrayList<>();
        Consulta c = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM consulta WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");

            while (resultado.next()) {                
                c = new Consulta(resultado.getString(2), resultado.getString(3), resultado.getDouble(4));
                
                lista.add(c);
                
            }
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    
}
