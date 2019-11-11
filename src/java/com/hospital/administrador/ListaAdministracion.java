
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
    
    
    /*Hace una lsita de las area que se encuentran en la base de datos*/
    public List listarAreas(){
        
        List<Area> lista = new ArrayList<>();
        Area area = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+areas);
            
            while (resultado.next()) {    
                area=new Area(resultado.getString(2));
                area.setId(resultado.getInt(1));
                
                lista.add(area);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
    /*Hace una lista de la habitaciones*/
    public List listarHabitaciones(){
        List<Habitacion> lista = new ArrayList<>();
        Habitacion habitaciones = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+habitacion);
            
            while (resultado.next()) {    
                habitaciones= new Habitacion(resultado.getInt(3),resultado.getDouble(4),resultado.getDouble(5));
                habitaciones.setId(resultado.getInt(1));
                habitaciones.setPaciente(resultado.getInt(2));
                
                lista.add(habitaciones);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
    
    /*Hace una lista de los empleados de administracion*/
    public List listarEmpleadosAdministracion(){
            List<Usuario> lista = new ArrayList<>();
        Usuario usuario = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"tipo='Administrador' OR tipo='Recursos Humanos' OR tipo='Gerente';");
            
            while (resultado.next()) {    
                usuario = new Usuario(resultado.getString(2),resultado.getString(3));
                usuario.setId(resultado.getInt(1));
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
