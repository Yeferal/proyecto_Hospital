/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.caja;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Consulta;
import com.mycompany.hospital.Cuenta;
import com.mycompany.hospital.Paciente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class ListaCaja extends Conexion{
    
    
    public List listarConsultas(){
        List<Consulta> lista = new ArrayList<>();
        Consulta c = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM consulta;");
            while (resultado.next()) {                
                c = new Consulta(resultado.getString(2), resultado.getString(3), resultado.getDouble(4));
                lista.add(c);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public List listarCuenta(String texto){
        List<Cuenta> lista = new ArrayList<>();
        Cuenta c = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM cuenta WHERE pagado=0 AND nombre_paciente LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                c = new Cuenta(resultado.getString(2), resultado.getString(3), resultado.getDouble(4));
                c.setId(resultado.getInt(1));
                lista.add(c);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public List listarPaciente(String texto){
        List<Paciente> lista = new ArrayList<>();
        Paciente p = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM paciente WHERE alta=1 AND nombre LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                p = new Paciente(0,0,resultado.getString(2), "", "","");
                p.setId(resultado.getInt(1));
                lista.add(p);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    
    public double getTotal(String texto){
        double total = 0;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT sum(Total)total FROM cuenta WHERE pagado=0 AND nombre_paciente LIKE '%"+texto+"%';");
            resultado.next();
            total = resultado.getDouble(1);
            desconectar();
        } catch (SQLException e) {
        }
        
        return total;
    }
}
