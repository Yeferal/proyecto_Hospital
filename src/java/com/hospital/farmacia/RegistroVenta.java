
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Compra;
import com.mycompany.hospital.Venta;
import java.sql.SQLException;
import java.util.List;

public class RegistroVenta extends Conexion{
    
    
    public void insertarVenta(List ventas,String fecha){
        conectar();
        System.out.println("Total: "+calcularTotal(ventas)+" en la fecha de "+fecha+" tamaño: "+ventas.size());
        
        insertarFactura(calcularTotal(ventas), fecha);
        agregarVentas(ventas, fecha);
        
        desconectar();
    }
    
    
    public double calcularTotal(List ventas){
        double total = 0;
        for (int i = 0; i < ventas.size(); i++) {
            Venta v =(Venta) ventas.get(i);
            total += v.getTotal();
        }
        return total;
    }

    private void insertarFactura(double total,String fecha){
        try {
            insertar = conect.prepareStatement("INSERT INTO factura_venta (fecha,total) VALUES (?,?)");
            insertar.setString(1, fecha);
            insertar.setDouble(2, total);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
    
    
    private void insertarVentasMedicamento(Venta venta){
        try {
            insertar = conect.prepareStatement("INSERT INTO venta_medicamento (id_factura, nombre_empleado, nombre_cliente, nombre_medicamento, fecha, precio, cantidad, total) VALUES (?,?,?,?,?,?,?,?);");
            insertar.setInt(1, venta.getIdFactura());
            insertar.setString(2, venta.getNombreEmpleado());
            insertar.setString(3, venta.getNombreCliente());
            insertar.setString(4, venta.getNombreMedicamento());
            insertar.setString(5, venta.getFecha());
            insertar.setDouble(6, venta.getPrecio());
            insertar.setInt(7, venta.getCantidad());
            insertar.setDouble(8, venta.getTotal());
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    private void actualizarInventario(Venta venta){
        
        try {
            
            insertar = conect.prepareStatement("UPDATE medicamento SET cantidad=cantidad-"+venta.getCantidad()+" WHERE nombre='"+venta.getNombreMedicamento()+"';");
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    
    
    private int getFactura(){
        int f = 0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT id FROM factura_venta ORDER by id DESC;");
            resultado.next();
            f=resultado.getInt(1);
            
        } catch (SQLException e) {
        }
        return f;
    }
    
    private void agregarVentas(List ventas,String fecha){
        int factura = getFactura();
        
        for (int i = 0; i < ventas.size(); i++) {
            Venta v =(Venta) ventas.get(i);
            v.setFecha(fecha);
            v.setIdFactura(factura);
            System.out.println(v.getNombreEmpleado());
            System.out.println(v.getNombreCliente());
            System.out.println(v.getNombreMedicamento());
            System.out.println(v.getFecha());
            System.out.println(v.getPrecio());
            
            
            insertarVentasMedicamento(v);
            actualizarInventario(v);
        }
        
    }
}
