
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.medicamento;
import com.mycompany.hospital.Medicamento;
import com.mycompany.hospital.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaReporte extends Conexion{
    
    public List listarReporteMedicamentos(String texto){
        List<Medicamento> lista = new ArrayList<>();
        Medicamento m = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+medicamento+" WHERE nombre LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                m = new Medicamento(resultado.getString(2), resultado.getDouble(3), resultado.getDouble(4), resultado.getInt(5), resultado.getInt(6));
                m.setId(resultado.getInt(1));
                System.out.println(resultado.getString(2));
                lista.add(m);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    public List listarReporteGanancia(String texto,String fecha1,String fecha2){
        List<Medicamento> lista = new ArrayList<>();
        Medicamento m = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+medicamento+" WHERE nombre LIKE '%"+texto+"%';");
            while (resultado.next()) {                
                m = new Medicamento(resultado.getString(2), resultado.getDouble(3), resultado.getDouble(4), resultado.getInt(5), resultado.getInt(6));
                m.setId(resultado.getInt(1));
                m.setListaVentas(getVentas(m.getNombre(),fecha1, fecha2,m.getCosto()));
                
                lista.add(m);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    public List getVentas(String nombre,String fecha1,String fecha2,double costo){
        List<Venta> lista = new ArrayList<>();
        Venta v = null;
        try {
            Statement stmt1 = conect.createStatement();
            ResultSet resultado1 = stmt1.executeQuery("SELECT * FROM venta_medicamento WHERE nombre_medicamento LIKE '%"+nombre+"%' AND (fecha<="+fecha1+") AND (fecha>="+fecha2+") ORDER BY fecha;");
            
            while (resultado1.next()) {                
                v= new Venta("", "", "", resultado1.getDouble(7), resultado1.getInt(8), resultado1.getDouble(9));
                v.setFecha(resultado1.getString(6));
                v.setCosto(costo);
                lista.add(v);
            }
            
            
        } catch (SQLException e) {
        }
        return lista;
    }
    
    
    

}
