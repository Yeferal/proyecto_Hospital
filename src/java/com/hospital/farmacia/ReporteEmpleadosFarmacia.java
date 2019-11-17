
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.medicamento;
import com.mycompany.hospital.Medicamento;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReporteEmpleadosFarmacia extends Conexion{
    
    
    public List listarReporteVentas(String texto){
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM empleado WHERE tipo='Farmacia' AND jefe=0 AND nombre LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                u = new Usuario(resultado.getString(2), resultado.getString(3));
                u.setId(resultado.getInt(1));
                u.setListaVentas(getVentas(u.getNombre()));
                
                lista.add(u);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    
    public List listarReporteVentasCUI(String texto){
        List<Usuario> lista = new ArrayList<>();
        Usuario u = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM empleado WHERE tipo='Farmacia' AND jefe=0 AND cui LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                u = new Usuario(resultado.getString(2), resultado.getString(3));
                u.setId(resultado.getInt(1));
                u.setListaVentas(getVentas(u.getNombre()));
                
                lista.add(u);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    public List getVentas(String nombre){
        List<Venta> lista = new ArrayList<>();
        Venta v = null;
        try {
            Statement stmt1 = conect.createStatement();
            ResultSet resultado1 = stmt1.executeQuery("SELECT v.*,m.costo FROM venta_medicamento v join medicamento m on (v.nombre_medicamento=m.nombre) WHERE v.nombre_empleado LIKE '%"+nombre+"%' ORDER BY fecha;");
            
            while (resultado1.next()) {                
                v= new Venta("", "", "", resultado1.getDouble(7), resultado1.getInt(8), resultado1.getDouble(9));
                v.setFecha(resultado1.getString(6));
                v.setCosto(resultado1.getDouble(10));
                lista.add(v);
            }
            
            
        } catch (SQLException e) {
        }
        System.out.println("tamaño: "+lista.size());
        return lista;
    }
}
