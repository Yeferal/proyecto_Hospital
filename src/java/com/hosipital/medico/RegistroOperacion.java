
package com.hosipital.medico;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.INSERT;
import static com.hospital.conexiones.Conexion.VALUES;
import static com.hospital.conexiones.Conexion.historialMedico;
import com.mycompany.hospital.Medicamento;
import com.mycompany.hospital.Operacion;
import com.mycompany.hospital.Paciente;
import com.mycompany.hospital.Tarifa;
import java.sql.SQLException;

public class RegistroOperacion extends Conexion{
    
    
    public void insertar(Operacion operacion,Paciente paciente,Tarifa tarifa){
        conectar();
        
        try {
            System.out.println(operacion.getFecha()+operacion.getCliente()+operacion.getMedico());
            insertar = conect.prepareStatement("INSERT INTO operacion (fecha,cliente,medico,descripcion) VALUES (?,?,?,?);");
            insertar.setString(1, operacion.getFecha());
            insertar.setString(2, operacion.getCliente());
            insertar.setString(3, operacion.getMedico());
            insertar.setString(4, tarifa.getTipo());
            
            insertar.executeUpdate();
            
            insertarHistorial(operacion, paciente, tarifa);
            insertarCuenta(paciente.getNombre(), "Operacion de: "+tarifa.getTipo(), tarifa.getPrecio());
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertarCuenta(String paciente,String decripcion,double total){
        
        try {
            insertar =conect.prepareStatement("INSERT INTO cuenta (nombre_paciente, descripcion, Total) VALUES (?,?,?)");
            insertar.setString(1, paciente);
            insertar.setString(2, decripcion);
            insertar.setDouble(3, total);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void insertarHistorial(Operacion operacion,Paciente paciente,Tarifa tarifa){
        
        try {
            insertar = conect.prepareStatement(INSERT+historialMedico+"(id_paciente,descripcion,fecha,tipo,total) "+VALUES+"(?,?,?,?,?);");
            insertar.setInt(1, paciente.getId());
            insertar.setString(2, "Se opera de: "+tarifa.getTipo());
            insertar.setString(3, operacion.getFecha());
            insertar.setString(4, "Operacion");
            insertar.setDouble(5,  tarifa.getPrecio());
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
