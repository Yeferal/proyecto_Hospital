/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.paciente;
import com.mycompany.hospital.Paciente;
import java.sql.SQLException;

/**
 *
 * @author yefer
 */
public class RegistroAltaPaciente extends Conexion{
    
    
    public void insertarAlta(Paciente paciente,String fecha){
        double total =getCostoHabitacion(paciente.getHabitacion())*getDiasInternado(paciente.getId(), fecha);
        conectar();
        try {
            insertar = conect.prepareStatement("INSERT INTO historial_medico (id_paciente, descripcion, fecha, tipo, total) VALUES (?,?,?,?,?);");
            insertar.setInt(1, paciente.getId());
            insertar.setString(2, "Se da de alta al Paciente: "+paciente.getNombre());
            insertar.setString(3, fecha);
            insertar.setString(4, "Alta");
            insertar.setDouble(5, total);
            insertar.executeUpdate();
            
            insertarCuenta(paciente.getNombre(), "Dias internado: "+getDiasInternado(paciente.getId(), fecha), total);
            updateAltaPaciente(paciente.getId());

desconectar();
        } catch (Exception e) {
        }
    }
    
    public void insertarCuenta(String paciente,String decripcion,double total){
        conectar();
        try {
            insertar =conect.prepareStatement("INSERT INTO cuenta (nombre_paciente, descripcion, Total) VALUES (?,?,?)");
            insertar.setString(1, paciente);
            insertar.setString(2, decripcion);
            insertar.setDouble(3, total);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    
    public void updateAltaPaciente(int id){
        try {
            insertar =conect.prepareStatement("UPDATE paciente SET alta=1 WHERE id="+id+";");
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
    
    
    /*retorna el paciente agregado*/
    public Paciente getPaciente(int id){
        conectar();
        Paciente p = null;
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+paciente+"WHERE id="+id+";");
            resultado.next();
            
            p = new Paciente(0, resultado.getInt(6), resultado.getString(2), "", "", "");
            p.setId(resultado.getInt(1));
           
            
        } catch (SQLException e) {
        }
        desconectar();
        
        return p;
    }
    
    public double getCostoHabitacion(int id){
        double cuota=0;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM habitacion WHERE id="+id+";");
            resultado.next();
            cuota = resultado.getDouble(5);
            desconectar();
        } catch (SQLException e) {
        }
        return cuota;
    }
    
    public int getDiasInternado(int id, String fecha){
        conectar();
        int dias = 0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT TIMESTAMPDIFF(DAY,'"+fecha+"',fecha) dias , fecha FROM historial_medico WHERE id="+id+" AND tipo='Ingreso Paciente';");
            resultado.next();
            if(resultado.getInt(1)<0){
                dias = resultado.getInt(1)*(-1);
            }else{
                dias = resultado.getInt(1);
            }
            desconectar();
        } catch (SQLException e) {
        }
        return dias;
    }
    
}
