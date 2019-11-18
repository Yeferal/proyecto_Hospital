
package com.hosipital.medico;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.tarifario;
import com.mycompany.hospital.Operacion;
import com.mycompany.hospital.Paciente;
import com.mycompany.hospital.Tarifa;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaMedico extends Conexion{
    
    
    public List listarMedicos(){
        List<Usuario> lista = new ArrayList<>();
        Usuario u= null;
        conectar();
        try {
            insertar = conect.prepareStatement("UPDATE 	vacaciones SET estado=0 WHERE fecha_finaliza<NOW();");
            insertar.executeUpdate();
       
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM empleado WHERE tipo='Medico';");
            while (resultado.next()) {                
                u = new Usuario(resultado.getString(2), resultado.getString(3));
                u.setId(resultado.getInt(1));
                
                lista.add(u);
            }
            desconectar();
            
        } catch (Exception e) {
        }
        
        
        
        return lista;
        
    }
    
    public List listarPacientes(){
        List<Paciente> lista = new ArrayList<>();
        conectar();
        Paciente p = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM paciente;");
            while (resultado.next()) {                
                p = new Paciente(0, 0, resultado.getString(2), "", "", "");
                p.setId(resultado.getInt(1));

                lista.add(p);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public Paciente getPaciente(int id){
        Paciente p = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM paciente WHERE id="+id+";");
            resultado.next();
            p = new Paciente(0, 0, resultado.getString(2), "", "", "");
            p.setId(resultado.getInt(1));
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return p;
    }
    
    /*retorna un listado de tarifas de la DB*/
    public List listarTarifas(){
        List<Tarifa> lista = new ArrayList<>();
        Tarifa tarifa = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+tarifario+";");
            
            while (resultado.next()) {    
                tarifa = new Tarifa(resultado.getString(2),resultado.getDouble(3),resultado.getDouble(4),resultado.getDouble(5));
                tarifa.setId(resultado.getInt(1));
                
                lista.add(tarifa);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
    
    public Tarifa getTarifas(int id){
        Tarifa tarifa = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+tarifario+"WHERE id="+id+";");
            resultado.next();
                tarifa = new Tarifa(resultado.getString(2),resultado.getDouble(3),resultado.getDouble(4),resultado.getDouble(5));
                tarifa.setId(resultado.getInt(1));

            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return tarifa;
    }

    public List listarOperaciones(){
        List<Operacion> lista = new ArrayList<>();
        conectar();
        Operacion o = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM operacion ORDER BY fecha DESC;");
            while (resultado.next()) {                
                o = new Operacion(resultado.getString(2), resultado.getString(3), resultado.getString(4));
                o.setId(resultado.getInt(1));
                o.setDescripcion(resultado.getString(5));
                lista.add(o);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
}
