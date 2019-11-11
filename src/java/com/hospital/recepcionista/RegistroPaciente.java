
package com.hospital.recepcionista;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Paciente;
import java.sql.SQLException;


public class RegistroPaciente extends Conexion{
    
    
    /*inserta un paciente en la DB*/
    public void insertarPaciente(Paciente paciente){
        conectar();
        try {
            insertar = conect.prepareStatement(INSERT+this.paciente+"(nombre,cui,fecha_nacimiento,edad,no_habitacion,fecha_ingreso) "+VALUES+"(?,?,?,?,?,?);");
            insertar.setString(1, paciente.getNombre());
            insertar.setString(2, paciente.getCui());
            insertar.setString(3, paciente.getFechaNacimiento());
            insertar.setInt(4, paciente.getEdad());
            insertar.setInt(5, paciente.getHabitacion());
            insertar.setString(6, paciente.getFechaIngreso());
            
            insertar.executeUpdate();
            paciente.setId(getIdUltimoUsuario());
            
            insertarHistorialMedico(paciente);
            insertarHabitacion(paciente.getHabitacion());
            
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*Inserta el historial del Paciente*/
    public void insertarHistorialMedico(Paciente paciente){
        try {
            insertar = conect.prepareStatement(INSERT+historialMedico+"(id_paciente,descripcion,fecha,tipo,total) "+VALUES+"(?,?,?,?,?);");
            insertar.setInt(1, paciente.getId());
            insertar.setString(2, "Se interna al cliente: "+paciente.getNombre());
            insertar.setString(3, paciente.getFechaIngreso());
            insertar.setString(4, "Ingreso Paciente");
            insertar.setInt(5, 0);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    /*inserta la habitacion que usara el paciente*/
    private void insertarHabitacion(int id) throws SQLException{
        insertar = conect.prepareStatement(UPDATE+habitacion+SET+"paciente=1 "+WHERE+"id="+id+";");
            
            insertar.executeUpdate();
    }
    
    
    /*retorna el id del ultimo paciente agregado*/
    public int getIdUltimoUsuario(){
        conectar();
        int id = 0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"id "+FROM+paciente+"ORDER BY id DESC;");
            resultado.next();
            id = resultado.getInt(1);
        } catch (SQLException e) {
        }
        
        
        return id;
    }
    
}
