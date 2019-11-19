/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.caja;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Consulta;
import java.sql.SQLException;

/**
 *
 * @author yefer
 */
public class RegistroConsulta extends Conexion{
    
    
    public void insertarConsulta(Consulta consulta){
        conectar();
        try {
            insertar = conect.prepareStatement("INSERT INTO consulta (nombre_paciente, fecha, cuota) VALUES (?,?,?);");
            insertar.setString(1, consulta.getNombrePaciente());
            insertar.setString(2, consulta.getFecha());
            insertar.setDouble(3, consulta.getCuota());
            
            insertar.executeUpdate();
            
            desconectar();
        } catch (SQLException e) {
        }
    }
}
