
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Pago;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaPersonal extends Conexion{
    
    
    public List listarEspecialistas(){
        conectar();
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+especialistas+";");
            while (resultado.next()) {                
                u = new Usuario();
                u.setId(resultado.getInt(1));
                u.setNombre(resultado.getString(2));
                u.setCui(resultado.getString(3));
                
                lista.add(u);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    public List listarEmpleados(){
        conectar();
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+";");
            while (resultado.next()) {                
                u = new Usuario();
                u.setId(resultado.getInt(1));
                u.setNombre(resultado.getString(2));
                u.setCui(resultado.getString(3));
                u.setSalario(resultado.getDouble(7));
                
                lista.add(u);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    public List listarPagos(){
        conectar();
        List<Pago> lista = new ArrayList<>();
        Pago p = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+pagos+"order by fecha;");
            while (resultado.next()) {                
                p = new Pago();
                p.setId(resultado.getInt(1));
                p.setNombreEmpleado(resultado.getString(2));
                p.setNombreGerente(resultado.getString(7));
                p.setTipo(resultado.getString(5));
                p.setFecha(resultado.getString(4));
                p.setPago(resultado.getDouble(8));
                
                lista.add(p);
            }
            desconectar();
            
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    
}
