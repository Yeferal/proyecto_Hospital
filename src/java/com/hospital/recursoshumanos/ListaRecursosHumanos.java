
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.WHERE;
import static com.hospital.conexiones.Conexion.empleado;
import com.mycompany.hospital.Tarifa;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaRecursosHumanos extends Conexion{
    
    
    
    public List listarEmpleadosRecursosHumanos(){
            List<Usuario> lista = new ArrayList<>();
        Usuario usuario = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"tipo<>'Administrador' AND tipo<>'Recursos Humanos' AND tipo<>'Gerente';");
            
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
    
    public List listarAreas(){
        List<String> lista = new ArrayList<>();
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+areas+WHERE+"nombre<>'Administrador' AND nombre<>'Recursos Humanos' AND nombre<>'Gerente';");
            
            while (resultado.next()) {    
                
                lista.add(resultado.getString(2));
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
        
    }
    
    public List listarEspecialistas(){
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+especialistas+";");
            
            while (resultado.next()) {    
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCui(resultado.getString(3));
                
                lista.add(usuario);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
    
    public List listarTarifas(){
        List<Tarifa> lista = new ArrayList<>();
        Tarifa tarifa = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+tarifario+";");
            
            while (resultado.next()) {    
                tarifa = new Tarifa();
                tarifa.setId(resultado.getInt(1));
                tarifa.setTipo(resultado.getString(2));
                tarifa.setPrecio(resultado.getDouble(3));
                tarifa.setCosto(resultado.getDouble(4));
                tarifa.setCuota(resultado.getDouble(5));
                
                lista.add(tarifa);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
    }
}
