
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistroContrato extends Conexion{
    
    
    /*Verifica si existe un empleado con el mismo cui */
    public boolean verificarContrato(String cui){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"cui='"+cui+"';");
            
            if(resultado.next()){
                desconectar();
                return true;
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /*Verifica si el empleado ya existe*/
    public boolean verificarEmpleadoExistente(String cui){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"cui='"+cui+"';");
            
            if(resultado.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistroContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /*Inserta el contrato en la base de datos*/
    public void insertarContratoEmpleado(Usuario usuario, String tipoRegistro, String fecha){
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
            
            insertaHistorial(usuario, tipoRegistro, fecha);
            
            desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    /*Inserta los datos en el historial alboral del empleado*/
    public void insertaHistorial(Usuario usuario,String tipoRegistro, String fecha){
        
        
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
