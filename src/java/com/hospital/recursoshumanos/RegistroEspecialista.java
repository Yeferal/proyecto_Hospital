
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;

public class RegistroEspecialista extends Conexion{
    
    /*inserta un especialista a la DB*/
    public void insertarEspecialista(Usuario usuario){
        conectar();
        
        try {
            insertar = conect.prepareStatement(INSERT+especialistas+"(nombre,cui) "+VALUES+"(?,?);");
            insertar.setString(1, usuario.getNombre());
            insertar.setString(2, usuario.getCui());
            
            insertar.executeUpdate();
            
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*verifiaca la existencia del especialista*/
    public boolean verficarExistenciaEspecialista(String cui){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+especialistas+WHERE+"cui='"+cui+"';");
            
            if(resultado.next()){
                desconectar();
                return true;
            }
            desconectar();
        } catch (SQLException e) {
        }
    
        
        return false;
    }
    
    /*elimina a un especialista de la DB*/
    public void eliminarEspecialista(int id){
        conectar();
        try {
            insertar =  conect.prepareStatement(DELETE+FROM+especialistas+WHERE+"id="+id+";");
            
            insertar.executeUpdate();
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
}
