
package com.hospital.iniciosesion;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SesionUsuario extends Conexion{
    
    Usuario usuario = new Usuario();
    
    public boolean isExisteUsuario(String cui){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"cui='"+cui+"';");
            if(resultado.next()){
                desconectar();
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return false;
    }

    public boolean isPasswordUsuario(String cui,String pass){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"codigo "+FROM+empleado+WHERE+"cui='"+cui+"';");
            while (resultado.next()){                
                if(resultado.getString(1).equals(pass)){
                    desconectar();
                    return true;
                }            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return false;
    }
    
    public Usuario setUsuario(String cui,String pass){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"cui='"+cui+"' AND codigo='"+pass+"';");
            
            while (resultado.next()){ 
                usuario.setId(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCui(resultado.getString(3));
                usuario.setCodigo(resultado.getString(4));
                usuario.setTipo(resultado.getString(8));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return usuario;
    }
    
}
