
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.DELETE;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.INSERT;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.SET;
import static com.hospital.conexiones.Conexion.UPDATE;
import static com.hospital.conexiones.Conexion.VALUES;
import static com.hospital.conexiones.Conexion.WHERE;
import static com.hospital.conexiones.Conexion.areas;
import com.mycompany.hospital.Habitacion;
import java.sql.SQLException;


public class AdministracionHabitacion extends Conexion{
    
    
    /*Inserta una nueva habitacion en la DB*/
    public void insertarHabitacion(Habitacion habitacion){
        conectar();
        
        try {
            insertar = conect.prepareStatement(INSERT+this.habitacion+"(estado,costo,cuota) "+VALUES+"(?,?,?);");
            
            insertar.setInt(1, habitacion.getEstado());
            insertar.setDouble(2, habitacion.getCosto());
            insertar.setDouble(3, habitacion.getCuota());
            
            insertar.executeUpdate();
            
            desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /*Elimina una habitacion de la DB*/
    public void eliminarHabitacion(int id){
        conectar();
        try {
            insertar = conect.prepareStatement(DELETE+FROM+this.habitacion+WHERE+"id="+id+";");
            insertar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se pudo Modificar");
        }
    }
    
    /*Modifica una habitacion de la DB*/
    public void modificarHabitacion(Habitacion habitacion){
        conectar();
        try {
            insertar = conect.prepareStatement(UPDATE+this.habitacion+SET+"estado="+habitacion.getEstado()+", costo="+habitacion.getCosto()+", cuota="+habitacion.getCuota()+" "+WHERE+"id="+habitacion.getId()+";");
            insertar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se pudo Modificar");
        }
    }
    /*Verifica la existencia de una habitacion*/
    public boolean verificarExistencia(int id){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+habitacion+WHERE+"id="+id+";");
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
    /*Verifica la exsitencia de paciente en una habitacion*/
    public boolean verificarExistenciaPaciente(int id){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+habitacion+WHERE+"id="+id+";");
            resultado.next();
            if(resultado.getInt(2)==0){
                desconectar();
                return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return false;
    }
    /*Retorna una habitacion que fue buscada en la DB*/
    public Habitacion getHabitacion(int id){
        Habitacion h = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+habitacion+WHERE+"id="+id+";");
            resultado.next();
            
            h = new Habitacion(resultado.getInt(3),resultado.getDouble(4),resultado.getDouble(5));
            h.setId(resultado.getInt(1));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        
        return h;
    }
}
