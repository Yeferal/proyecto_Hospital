
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;


public class RegistroSalario extends Conexion{
    
    
    
    /*Cambia el salario del empleado se conecta a la base de datos para esto*/
    public void cambiarSalarioEmpleado(Usuario usuario, String tipoRegistro, String fecha){
        conectar();
        
        try {
            
            insertar = conect.prepareStatement(UPDATE+empleado+SET+"salario="+usuario.getSalario()+" "+WHERE+"id="+usuario.getId()+";");
            insertar.executeUpdate();
            
            //envia la insercion en el historial laboral
            insertarHistorialSalario(usuario, tipoRegistro, fecha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*Inserta los datos o accion en el historial laboral para determinado usuario*/
    public void insertarHistorialSalario(Usuario usuario, String tipoRegistro, String fecha){
        
        try {
            insertar = conect.prepareStatement(INSERT+historiaLaboral+"(empleado,cui_empleado,salario_empleado,tipo_historial,area_trabajo,fecha_registro) "+VALUES+"(?,?,?,?,?,?);");
            
            insertar.setString(1, usuario.getNombre());
            insertar.setString(2, usuario.getCui());
            insertar.setDouble(3, usuario.getSalario());
            insertar.setString(4, tipoRegistro);
            insertar.setString(5, usuario.getTipo());
            insertar.setString(6, fecha);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    /*Retorna un objeto tipo usuario con sus datos obtenidos de la base de datos*/
    public Usuario getUsuario(int id){
        Usuario u = null;
        conectar();
        try {
            stmt=conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"id="+id+";");
            resultado.next();
            u =new Usuario(resultado.getString(2),resultado.getString(3));
            u.setId(resultado.getInt(1));
            u.setCodigo(resultado.getString(4));
            u.setIrtra(resultado.getDouble(5));
            u.setIgss(resultado.getDouble(6));
            u.setSalario(resultado.getDouble(7));
            u.setTipo(resultado.getString(8));
            u.setJefe(resultado.getInt(9));
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        
        return u;
    }
    
}
