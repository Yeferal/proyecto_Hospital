
package com.hospital.servlet.reporteempleados;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Contrato;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaReporteEmpleados extends Conexion{
    
    
    public List listarEmpleados(String texto,String fecha1,String fecha2){
        List<Contrato> lista = new ArrayList<>();
        Contrato c = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM historia_laboral WHERE tipo_historial='Contrato' AND (fecha_registro<="+fecha1+") AND (fecha_registro>="+fecha2+") AND (area_trabajo LIKE '%"+texto+"%') ORDER BY fecha_registro;");
            while (resultado.next()) {                
                c = new Contrato(resultado.getString(2), resultado.getString(3),resultado.getDouble(4),resultado.getString(5),resultado.getString(6),resultado.getString(7));
                c.setId(resultado.getInt(1));
                
                lista.add(c);
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public List listarEmpleadosRetiro(String texto,String fecha1,String fecha2){
        List<Contrato> lista = new ArrayList<>();
        Contrato c = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM historia_laboral WHERE tipo_historial='Despido' AND tipo_historial='Renuncia' AND (fecha_registro<="+fecha1+") AND (fecha_registro>="+fecha2+") AND (area_trabajo LIKE '%"+texto+"%') ORDER BY fecha_registro;");
            while (resultado.next()) {                
                c = new Contrato(resultado.getString(2), resultado.getString(3),resultado.getDouble(4),resultado.getString(5),resultado.getString(6),resultado.getString(7));
                c.setId(resultado.getInt(1));
                
                lista.add(c);
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public List listarEmpleadosMedicosAsignados(){
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT e.*,(SELECT count(id_asignacion) FROM asignacion WHERE nombre_empleado=e.nombre) cantidad FROM empleado e WHERE e.tipo='Medico';");
            while (resultado.next()) {    
                if(resultado.getInt(10)>0){
                    u = new Usuario(resultado.getString(2), resultado.getString(3));
                    u.setSalario(resultado.getDouble(7));
                    u.setTipo(resultado.getString(8));
                    u.setId(resultado.getInt(1));
                
                    lista.add(u);
                }
                
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
    public List listarEmpleadosMedicosDesAsignados(){
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT e.*,(SELECT count(id_asignacion) FROM asignacion WHERE nombre_empleado=e.nombre) cantidad FROM empleado e WHERE e.tipo='Medico';");
            while (resultado.next()) {    
                if(resultado.getInt(10)==0){
                    u = new Usuario(resultado.getString(2), resultado.getString(3));
                    u.setSalario(resultado.getDouble(7));
                    u.setTipo(resultado.getString(8));
                    u.setId(resultado.getInt(1));
                
                    lista.add(u);
                }
                
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
}
