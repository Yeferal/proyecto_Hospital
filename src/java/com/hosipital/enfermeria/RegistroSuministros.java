
package com.hosipital.enfermeria;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.INSERT;
import static com.hospital.conexiones.Conexion.VALUES;
import com.mycompany.hospital.Medicamento;
import com.mycompany.hospital.Paciente;
import java.sql.SQLException;

/**
 *
 * @author yefer
 */
public class RegistroSuministros extends Conexion{
    
    
    public void insertarHistorial(String fecha, int idMedicamento, int idPaciente, int cantidad){
        
        conectar();
        Medicamento m = getMedicamento(idMedicamento);
        try {
            insertar = conect.prepareStatement(INSERT+historialMedico+"(id_paciente,descripcion,fecha,tipo,total) "+VALUES+"(?,?,?,?,?);");
            insertar.setInt(1, idPaciente);
            insertar.setString(2, "Se Suministra medicamento: "+m.getNombre());
            insertar.setString(3, fecha);
            insertar.setString(4, "Suministro");
            insertar.setDouble(5, cantidad*m.getPrecio());
            
            insertar.executeUpdate();
            
            insertarCuenta(getNombrePaciente(idPaciente), m.getNombre(), cantidad*m.getPrecio());
            
            desconectar();
        } catch (SQLException e) {
        }
    }
    
    public Medicamento getMedicamento(int id){
        Medicamento m = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM medicamento WHERE id="+id+";");
            resultado.next();
            m= new Medicamento(resultado.getString(2), resultado.getDouble(3), resultado.getDouble(4), 0, 0);
            m.setId(resultado.getInt(1));
            
        } catch (SQLException e) {
        }
        return m;
    }
    public void insertarCuenta(String paciente,String decripcion,double total){
        
        try {
            insertar =conect.prepareStatement("INSERT INTO cuenta (nombre_paciente, descripcion, Total) VALUES (?,?,?)");
            insertar.setString(1, paciente);
            insertar.setString(2, decripcion);
            insertar.setDouble(3, total);
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    
    public String getNombrePaciente(int id){
        String nombre = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT nombre FROM paciente WHERE id="+id+";");
            resultado.next();
            nombre=resultado.getString(1);
            
        } catch (SQLException e) {
        }
        
        return nombre;
    }
    
}
