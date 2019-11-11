
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdministracionArea extends Conexion{
    
    
    /*Insertar Area*/
    public void insertarArea(String nombre){
        conectar();
        
        try {
            insertar = conect.prepareStatement(INSERT+areas+"(nombre) "+VALUES+"(?);");
            
            insertar.setString(1, nombre);
            
            insertar.executeUpdate();
            
            desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /*elimina una area de la DB*/
    public void eliminarArea(int id){
        conectar();
        try {
            insertar = conect.prepareStatement(DELETE+FROM+areas+WHERE+"id="+id+";");
            insertar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se pudo Modificar");
        }
    }
    
    /*modifica un area de la DB*/
    public void modificarArea(int id, String nombre){
        conectar();
        try {
            insertar = conect.prepareStatement(UPDATE+areas+SET+"nombre='"+nombre+"' "+WHERE+"id="+id+";");
            insertar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se pudo Modificar");
        }
    }
    /*busca la existencia de un area*/
    public boolean verificarExistencia(String nombre){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+areas+WHERE+"nombre='"+nombre+"';");
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
}
