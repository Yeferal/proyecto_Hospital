
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
    RegistroVacaciones registro = new RegistroVacaciones();
    
    public void enviarRegistro(Usuario usuario,String fecha){
        
        registro.insertarVacaciones(usuario, fecha);
    }
    
    
    
    
    public List listarVacaciones(){
        List<Vacacion> lista = new ArrayList<>();
        Vacacion v = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"e.nombre,e.tipo,v.fecha_inicio,v.fecha_finaliza,e.id,v.id_empleado, v.dias "+FROM+"empleado e left join vacaciones v on (e.id=v.id_empleado AND v.estado=1);");
            while (resultado.next()) {                
                v = new Vacacion(resultado.getInt(6),resultado.getString(1) , resultado.getString(3), resultado.getString(4), resultado.getInt(7));
                v.setTipo(resultado.getString(2));
                
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
