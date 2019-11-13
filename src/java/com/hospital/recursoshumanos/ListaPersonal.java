
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import com.mycompany.hospital.Pago;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Vacacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaPersonal extends Conexion{
    
    /*retorna un listado de los especialistas*/
    public List listarEspecialistas(){
        conectar();
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+especialistas+";");
            while (resultado.next()) {                
                u = new Usuario(resultado.getString(2),resultado.getString(3));
                u.setId(resultado.getInt(1));
                
                lista.add(u);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    /*retorna un listado de empleados*/
    public List listarEmpleados(){
        conectar();
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+";");
            while (resultado.next()) {                
                u = new Usuario(resultado.getString(2),resultado.getString(3));
                u.setId(resultado.getInt(1));
                u.setSalario(resultado.getDouble(7));
                
                lista.add(u);
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    /*retorna un listado de pagos*/
    public List listarPagos(){
        conectar();
        List<Pago> lista = new ArrayList<>();
        Pago p = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+pagos+"order by fecha;");
            while (resultado.next()) {                
                p = new Pago(resultado.getString(2),"0",resultado.getString(4),resultado.getString(5),0,resultado.getString(7),resultado.getDouble(8));
                p.setId(resultado.getInt(1));
                
                lista.add(p);
            }
            desconectar();
            
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    public List listarVacaciones(){
        List<Vacacion> lista = new ArrayList<>();
        Vacacion v = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"e.nombre,e.tipo,v.fecha_inicio,v.fecha_finaliza,e.id,v.id_empleado, v.dias,v.id "+FROM+"empleado e left join vacaciones v on (e.id=v.id_empleado AND v.estado=0);");
            while (resultado.next()) {                
                v = new Vacacion(resultado.getInt(5),resultado.getString(1) , resultado.getString(3), resultado.getString(4), resultado.getInt(7));
                v.setTipo(resultado.getString(2));
                v.setId(resultado.getInt(8));
                lista.add(v);
            }
            desconectar();
            
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public String getFechaActual(){
        String fecha = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"CURDATE();");
            resultado.next();
            fecha = resultado.getString(1);
            desconectar();
        } catch (SQLException e) {
        }
        
        return fecha;
    }
    
    
}
