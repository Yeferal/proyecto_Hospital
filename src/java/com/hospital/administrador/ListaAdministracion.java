
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.habitacion;
import com.mycompany.hospital.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListaAdministracion extends Conexion{
    
    
    
    public List listarAreas(){
        
        List<Area> lista = new ArrayList<>();
        Area area = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+areas);
            
            while (resultado.next()) {    
                area=new Area();
                area.setId(resultado.getInt(1));
                area.setNombre(resultado.getString(2));
                
                lista.add(area);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
    
    public List listarHabitaciones(){
        List<Habitacion> lista = new ArrayList<>();
        Habitacion habitaciones = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+habitacion);
            
            while (resultado.next()) {    
                habitaciones= new Habitacion();
                habitaciones.setId(resultado.getInt(1));
                habitaciones.setPaciente(resultado.getInt(2));
                habitaciones.setEstado(resultado.getInt(3));
                habitaciones.setCosto(resultado.getDouble(4));
                habitaciones.setCuota(resultado.getDouble(5));
                
                lista.add(habitaciones);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
    
    
    public List listarEmpleadosAdministracion(){
            List<Usuario> lista = new ArrayList<>();
        Usuario usuario = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"tipo='Administrador' OR tipo='Recursos Humanos' OR tipo='Gerente';");
            
            while (resultado.next()) {    
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCui(resultado.getString(3));
                usuario.setCodigo(resultado.getString(4));
                usuario.setIrtra(resultado.getDouble(5));
                usuario.setIgss(resultado.getDouble(6));
                usuario.setSalario(resultado.getDouble(7));
                usuario.setTipo(resultado.getString(8));
                usuario.setJefe(resultado.getInt(9));
                
                lista.add(usuario);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
}
