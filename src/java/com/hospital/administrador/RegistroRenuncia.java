
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.INSERT;
import static com.hospital.conexiones.Conexion.VALUES;
import static com.hospital.conexiones.Conexion.empleado;
import static com.hospital.conexiones.Conexion.historiaLaboral;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;


public class RegistroRenuncia extends Conexion{
    
    
    public void insertarRenunciaEmpleado(Usuario usuario, String tipoRegistro, String fecha){
        conectar();
        try {
            insertar = conect.prepareStatement(INSERT+empleado+"(nombre,cui,codigo,irtra,igss,salario,tipo,jefe) "+VALUES+"(?,?,?,?,?,?,?,?);");
            
            insertar.setString(1, usuario.getNombre());
            insertar.setString(2, usuario.getCui());
            insertar.setString(3, usuario.getCodigo());
            insertar.setDouble(4, usuario.getIrtra());
            insertar.setDouble(5, usuario.getIgss());
            insertar.setDouble(6, usuario.getSalario());
            insertar.setString(7, usuario.getTipo());
            insertar.setInt(8, usuario.getJefe());
            
            insertar.executeUpdate();
            
            insertaRenunciaHistorial(usuario, tipoRegistro, fecha);
            
            desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    public void insertaRenunciaHistorial(Usuario usuario,String tipoRegistro, String fecha){
        
        
        try {
            insertar = conect.prepareStatement(INSERT+historiaLaboral+"(empleado,cui_empleado,salario_empleado,tipo_historial,area_trabajo,fecha_registro) "+VALUES+"(?,?,?,?,?,?);");
            
            insertar.setString(1, usuario.getNombre());
            insertar.setString(2, usuario.getCui());
            insertar.setDouble(3, usuario.getSalario());
            insertar.setString(4, tipoRegistro);
            insertar.setString(5, usuario.getTipo());
            insertar.setString(6, fecha);
            
            insertar.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
