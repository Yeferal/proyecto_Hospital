
package com.hospital.recursoshumanos;

import com.hospital.administrador.RegistroNormativo;
import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Vacacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlVacaciones extends Conexion{
    
    RegistroNormativo norma = new RegistroNormativo();
    
    
    public String obtenerFechaFinalizacion(String fecha){

        String fechaFinal = null;
        int dias = 0;
        int contador=0;
        while (norma.getDiasVacaciones()!=dias) {            
            if(mostrarDiaSemana(sumarDia(contador, fecha))==1 || mostrarDiaSemana(sumarDia(contador, fecha))==7){
                
            }else{
                
                dias++;
            }
            contador++;
            
        }
        
        contador--;
        fechaFinal = sumarDia(contador, fecha);

        return fechaFinal;
        
    }
    
    private String sumarDia(int dias, String fecha){
        String fechaNueva = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+" DATE_ADD('"+fecha+"', INTERVAL "+dias+" DAY);");
            resultado.next();
            fechaNueva = resultado.getString(1);
            
        } catch (SQLException e) {
        }
        return fechaNueva;
    }
    
    private int mostrarDiaSemana(String fecha){
        int fechaNueva = 0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+" DAYOFWEEK('"+fecha+"');");
            resultado.next();
            fechaNueva = resultado.getInt(1);
            
        } catch (SQLException e) {
        }
        return fechaNueva;
    }

    
}
