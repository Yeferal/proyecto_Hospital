
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Tarifa;
import java.sql.SQLException;

public class RegistroTarifario extends Conexion{
    
    
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
    
    public void modificarTarifa(Tarifa tarifa){
        conectar();
        
        try {
            insertar = conect.prepareStatement(UPDATE+this.tarifario+SET+"tipo_operacion='"+tarifa.getTipo()+"', precio="+tarifa.getPrecio()+", costo_operacion="+tarifa.getCosto()+", cuota_especialista="+tarifa.getCuota()+" "+WHERE+"id="+tarifa.getId()+";");

            insertar.executeUpdate();
            desconectar();
        } catch (SQLException e) {
        }
    }
    
    public Tarifa getTarifa(int id){
        Tarifa t = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+tarifario+WHERE+"id="+id+";");
            resultado.next();
            t = new Tarifa();
            t.setId(resultado.getInt(1));
            t.setTipo(resultado.getString(2));
            t.setPrecio(resultado.getDouble(3));
            t.setCosto(resultado.getDouble(4));
            t.setCuota(resultado.getDouble(5));
            
            desconectar();
            
        } catch (SQLException e) {
        }
        
        
        return t;
    }
}
