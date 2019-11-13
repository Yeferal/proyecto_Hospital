
package com.hospital.administrador;

import com.hospital.conexiones.Conexion;
import java.sql.SQLException;


public class RegistroNormativo extends Conexion{
    
    
    public int getDiasVacaciones(){
        conectar();
        int dias =  0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+normativo+WHERE+"id=1;");
            resultado.next();
            dias = resultado.getInt(2);
            desconectar();
            return dias;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dias;
    }
    
    public void cambairNormativo(int numero){
        conectar();
        
        try {
            insertar = conect.prepareStatement(UPDATE+normativo+SET+"vacaciones="+numero+";");
            insertar.executeUpdate();
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
