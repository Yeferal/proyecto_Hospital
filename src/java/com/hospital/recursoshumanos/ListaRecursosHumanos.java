
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
    
    
    /*retorna un listado de los empleados de recursos humanos*/
    public List listarEmpleadosRecursosHumanos(){
            List<Usuario> lista = new ArrayList<>();
        Usuario usuario = null;
        conectar();
        
        
        try {
            
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"tipo<>'Administrador' AND tipo<>'Recursos Humanos' AND tipo<>'Gerente';");
            
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
    /*retorna un listado de las area de la DB*/
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
    /*retorna un lsitado de especialistas*/
    public List listarEspecialistas(){
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+especialistas+";");
            
            while (resultado.next()) {    
                usuario = new Usuario(resultado.getString(2),resultado.getString(3));
                usuario.setId(resultado.getInt(1));
                
                lista.add(usuario);
            }
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return lista;
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
}
