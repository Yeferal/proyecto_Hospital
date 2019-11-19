/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.caja;

import com.hospital.conexiones.Conexion;
import java.sql.SQLException;

/**
 *
 * @author yefer
 */
public class RegistroPago extends Conexion{
    
    
    public void insertarPagos(String texto){
        conectar();
        try {
            insertar = conect.prepareStatement("UPDATE cuenta SET pagado=1 WHERE nombre_paciente='"+texto+"';");
            insertar.executeUpdate();
        } catch (SQLException e) {
        }
        
        
        desconectar();
    }
    
}
