
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Compra;
import java.sql.SQLException;
import java.util.List;

public class RegistroCompra extends Conexion{
    
    
    
    
    public void insertarCompra(List compras,String fecha){
        conectar();
        System.out.println("Total: "+calcularTotal(compras)+" en la fecha de "+fecha);
        
        insertarFactura(calcularTotal(compras), fecha);
        
        
        desconectar();
    }
    
    
    private double calcularTotal(List compra){
        double total = 0;
        for (int i = 0; i < compra.size(); i++) {
            Compra c =(Compra) compra.get(i);
            total += c.getTotal();
        }
        
        
        return total;
    }
    public void insertarCompra(Compra compra){
        
    }
    private void insertarFactura(double total,String fecha){
        try {
            insertar = conect.prepareStatement("INSERT INTO factura_compra (fecha,total) VALUES (?,?)");
            insertar.setString(1, fecha);
            insertar.setDouble(2, total);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
    
    
    private void insertarCompraMedicamento(Compra compra){
        try {
            insertar = conect.prepareStatement("INSERT INTO compra_medicamento (id_factura, nombre_medicamento, fecha, precio, cantidad, total) VALUES (?,?,?,?,?,?)");
            insertar.setInt(1, compra.getIdFactura());
            insertar.setString(2, compra.getNombreMedicamento());
            insertar.setString(3, compra.getFecha());
            insertar.setDouble(4, compra.getPrecio());
            insertar.setInt(5, compra.getCantidad());
            insertar.setDouble(6, compra.getTotal());
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }

    }
    
    private int getFactura(){
        int f = 0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT id FROM factura_compra;");
            resultado.next();
            f=resultado.getInt(1);
            
        } catch (SQLException e) {
        }
        return f;
    }
}
