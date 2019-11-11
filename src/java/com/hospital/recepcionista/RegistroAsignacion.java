package com.hospital.recepcionista;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.INSERT;
import static com.hospital.conexiones.Conexion.VALUES;
import static com.hospital.conexiones.Conexion.asignacion;
import com.mycompany.hospital.Paciente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroAsignacion extends Conexion{


    /*inserta la asignaciones para el paciente nuevo*/
    public void insertarAsignacion(Paciente paciente,int idMedico, int idEnfemero){
        conectar();
        try {
            asiganaMedico(paciente, idMedico);
            asiganaEnfermero(paciente, idEnfemero);
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    /*asigna el medico para le paciente inserta el registro de este*/
    public void asiganaMedico(Paciente paciente,int id) throws SQLException{
        conectar();
        insertar = conect.prepareStatement(INSERT+asignacion+"(id_paciente,nombre_paciente,id_empleado,nombre_empleado,tipo) "+VALUES+"(?,?,?,?,?);");
        insertar.setInt(1, paciente.getId());
        insertar.setString(2, paciente.getNombre());
        insertar.setInt(3, id);
        insertar.setString(4, getNombreEmpleado(id));
        insertar.setString(5, "Medico");
        insertar.executeUpdate();
    }
    /*asigna el enfermero para le paciente inserta el registro de este*/
    public void asiganaEnfermero(Paciente paciente,int id) throws SQLException{
        conectar();
        insertar = conect.prepareStatement(INSERT+asignacion+"(id_paciente,nombre_paciente,id_empleado,nombre_empleado,tipo) "+VALUES+"(?,?,?,?,?);");
        insertar.setInt(1, paciente.getId());
        insertar.setString(2, paciente.getNombre());
        insertar.setInt(3, id);
        insertar.setString(4, getNombreEmpleado(id));
        insertar.setString(5, "Enfermeria");
        
        insertar.executeUpdate();
    }
    
    
    /*muiestro el nombre del empelado*/
    private String getNombreEmpleado(int id) throws SQLException{
        
        stmt = conect.createStatement();
        resultado = stmt.executeQuery(SELECT+"nombre "+FROM+empleado+WHERE+"id="+id+";");
        resultado.next();
        
        return resultado.getString(1);
    }
    /*retorna el paciente con la busqueda de su id en la DB*/
    public Paciente getPaciente(int id){
        Paciente p= null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+paciente+WHERE+"id="+id+";");
            resultado.next();
            p = new Paciente(resultado.getInt(5), resultado.getInt(6), resultado.getString(2),resultado.getString(3) , resultado.getString(4), resultado.getString(7));
            p.setId(resultado.getInt(1));
            
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return p;
    }
    
}
