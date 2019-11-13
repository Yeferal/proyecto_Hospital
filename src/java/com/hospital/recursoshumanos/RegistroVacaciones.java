
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;

public class RegistroVacaciones extends Conexion{
    
    ControlVacaciones c = new ControlVacaciones();
    
    public void insertarVacaciones(Usuario usuario,String fecha){
        conectar();
        try {
            insertar = conect.prepareStatement(INSERT+vacaciones+"(id_empleado,nombre_empleado,fecha_inicio,fecha_finaliza,dias) "+VALUES+"(?,?,?,?,?);");
            insertar.setInt(1, usuario.getId());
            insertar.setString(2, usuario.getNombre());
            insertar.setString(3, fecha);
            insertar.setString(4, c.obtenerFechaFinalizacion(fecha));
            insertar.setInt(5, c.norma.getDiasVacaciones());
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
    }
    
}
