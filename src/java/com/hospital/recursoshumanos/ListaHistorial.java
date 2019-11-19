/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Historial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class ListaHistorial extends Conexion{
    
    
    public List listarHistorial(String texto){
        List<Historial> lista = new ArrayList<>();
        Historial h=null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM historia_laboral WHERE empleado LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                h = new Historial(resultado.getString(2), resultado.getString(3), resultado.getDouble(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));
                h.setId(resultado.getInt(1));
                
                lista.add(h);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        
        return lista;
    }
    
    
}
