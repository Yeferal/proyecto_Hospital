
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Tarifa;
import java.sql.SQLException;

public class RegistroTarifario extends Conexion{
    
    /*inserta una tarifa a la DB*/
    public void insertarTarifa(Tarifa tarifa){
        conectar();
        
        try {
            insertar = conect.prepareStatement(INSERT+this.tarifario+"(tipo_operacion,precio,costo_operacion,cuota_especialista)"+VALUES+"(?,?,?,?);");
            insertar.setString(1, tarifa.getTipo());
            insertar.setDouble(2, tarifa.getPrecio());
            insertar.setDouble(3, tarifa.getCosto());
            insertar.setDouble(4, tarifa.getCuota());
            
            insertar.executeUpdate();
            
            desconectar();
            
        } catch (SQLException e) {
        }
    }
    /*elimina una tarifa de la DB*/
    public void eliminarTarifa(int id){
        conectar();
        try {
            insertar =  conect.prepareStatement(DELETE+FROM+this.tarifario+WHERE+"id="+id+";");
            
            insertar.executeUpdate();
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*Modifica la tarifa en DB*/
    public void modificarTarifa(Tarifa tarifa){
        conectar();
        
        try {
            insertar = conect.prepareStatement(UPDATE+this.tarifario+SET+"tipo_operacion='"+tarifa.getTipo()+"', precio="+tarifa.getPrecio()+", costo_operacion="+tarifa.getCosto()+", cuota_especialista="+tarifa.getCuota()+" "+WHERE+"id="+tarifa.getId()+";");

            insertar.executeUpdate();
            desconectar();
        } catch (SQLException e) {
        }
    }
    /*retorna una tarifa con la busqueda de su ID en la DB*/
    public Tarifa getTarifa(int id){
        Tarifa t = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+tarifario+WHERE+"id="+id+";");
            resultado.next();
            t = new Tarifa(resultado.getString(2),resultado.getDouble(3),resultado.getDouble(4),resultado.getDouble(5));
            t.setId(resultado.getInt(1));
            
            desconectar();
            
        } catch (SQLException e) {
        }
        
        
        return t;
    }
}
