
package com.hospital.farmacia;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Medicamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaFarmacia extends Conexion{
    
    
    public List listarMedicamentos(){
        List<Medicamento> lista = new ArrayList<>();
        Medicamento m = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+medicamento+";");
            while (resultado.next()) {                
                m = new Medicamento(resultado.getString(2), resultado.getDouble(3), resultado.getDouble(4), resultado.getInt(5), resultado.getInt(6));
                m.setId(resultado.getInt(1));
                
                lista.add(m);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    public Medicamento getMedicamento(int id){
        conectar();
        Medicamento m = null;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM medicamento WHERE id="+id+";");
            resultado.next();
            m = new Medicamento(resultado.getString(2), resultado.getDouble(3), 0, resultado.getInt(5), resultado.getInt(6));
            m.setId(resultado.getInt(1));
            
        } catch (SQLException e) {
        }
        desconectar();
        
        return m;
    }
    
    public boolean getCantidadMedicamento(int id, int cantidad){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM medicamento WHERE id="+id+";");
            resultado.next();
            if(resultado.getInt(5)<cantidad){
                desconectar();
                return false;
            }
            
        } catch (SQLException e) {
        }
        desconectar();
        return true;
    }
    
    
    
}
