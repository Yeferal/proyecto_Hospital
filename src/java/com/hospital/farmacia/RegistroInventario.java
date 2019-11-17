
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import java.sql.SQLException;

public class RegistroInventario extends Conexion{
    
    
    public void actualizarInventario(int id,int cantidad){
        conectar();
        try {
            insertar = conect.prepareStatement("UPDATE medicamento SET cantidad="+cantidad+" WHERE id="+id+";");
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
        
        
        desconectar();
        
    }
    
}
