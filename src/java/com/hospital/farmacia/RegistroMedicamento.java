
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Medicamento;
import java.sql.SQLException;

public class RegistroMedicamento extends Conexion{
    
    
    
    public void insertarMedicamento(Medicamento medicamento){
        conectar();
        
        try {
            insertar = conect.prepareStatement(INSERT+this.medicamento+"(nombre,precio,costo,cantidad,minimo) "+VALUES+"(?,?,?,?,?);");
            insertar.setString(1, medicamento.getNombre());
            insertar.setDouble(2, medicamento.getPrecio());
            insertar.setDouble(3, medicamento.getCosto());
            insertar.setInt(4, medicamento.getCantidad());
            insertar.setInt(5, medicamento.getMinimo());
            
            insertar.executeUpdate();
            System.out.println("Agrego esa mierda");
            
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public boolean verificarExistencia(String nombre){
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+medicamento+WHERE+"nombre='"+nombre+"';");
            if(resultado.next()){
                desconectar();
                return true;
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
        return false;
    }
}
