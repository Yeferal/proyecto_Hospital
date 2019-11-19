/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.reporte.administracion;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Compra;
import com.mycompany.hospital.CostosFarmacia;
import com.mycompany.hospital.CostosPago;
import com.mycompany.hospital.IngresoConsulta;
import com.mycompany.hospital.Pago;
import com.mycompany.hospital.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class ListaCostos extends Conexion{
    
    
    
    public CostosFarmacia getCostoFarmacia(String fecha1, String fecha2){
        CostosFarmacia costo = null;
        
        costo=new CostosFarmacia(listarCompras(fecha1, fecha2), getTotalCompra(fecha1, fecha2));
        
        return costo;
    }
    
    public CostosPago getCostosPago(String fecha1,String fecha2){
        CostosPago costo = null;

        costo = new CostosPago(listarPagos(fecha1, fecha2), getTotalPago(fecha1, fecha2));
    

        
        return costo;
        
    }
    
    
    
    
    public List listarCompras(String fecha1, String fecha2){
        List<Compra> lista = new ArrayList<>();
        Compra p = null;
        
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM compra_medicamento WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");

            while (resultado.next()) {                
                p = new Compra(resultado.getString(3), resultado.getDouble(5), 0, resultado.getDouble(7));
                p.setFecha(resultado.getString(4));
                p.setId(resultado.getInt(1));

                lista.add(p);
            }
            desconectar();
            }catch (SQLException e) {
            e.printStackTrace();
        }
            
        
        return lista;
    }
    
    public List listarPagos(String fecha1, String fecha2){
        List<Pago> lista = new ArrayList<>();
        Pago p = null;
        
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM pagos WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");

            while (resultado.next()) {                
                p = new Pago(resultado.getString(2), "", resultado.getString(4), "", 0, "", resultado.getDouble(8));
                p.setFecha(resultado.getString(4));
                p.setId(resultado.getInt(1));

                lista.add(p);
            }
            desconectar();
            }catch (SQLException e) {
            e.printStackTrace();
        }
            
        
        return lista;
    }
    
    
    public double getTotalCompra(String fecha1,String fecha2){
        conectar();
        double total=0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT sum(total) subtotal FROM compra_medicamento WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");
            resultado.next();
            total = resultado.getDouble(1);
            desconectar();
        } catch (Exception e) {
        }
        return total;
    }
    
    public double getTotalPago(String fecha1,String fecha2){
        conectar();
        double total=0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT sum(pago_empleado) subtotal FROM pagos WHERE (fecha<="+fecha2+") AND (fecha>="+fecha1+");");
            resultado.next();
            total = resultado.getDouble(1);
            desconectar();
        } catch (Exception e) {
        }
        return total;
    }
}
