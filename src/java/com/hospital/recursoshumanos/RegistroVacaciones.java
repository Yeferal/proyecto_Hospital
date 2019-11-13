
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Usuario;
import com.mycompany.hospital.Vacacion;
import java.sql.SQLException;

public class RegistroVacaciones extends Conexion{
    
    ControlVacaciones c = new ControlVacaciones();

    
    public void insertarVacaciones(Usuario usuario,String fecha){
        conectar();
        try {
            insertar = conect.prepareStatement(INSERT+vacaciones+"(id_empleado,nombre_empleado,fecha_inicio,fecha_finaliza,dias) "+VALUES+"(?,?,?,?,?);");
            insertar.setInt(1, usuario.getId());
            insertar.setString(2, usuario.getNombre());
            insertar.setString(3, fecha);
            insertar.setString(4, c.obtenerFechaFinalizacion(fecha));
            insertar.setInt(5, c.norma.getDiasVacaciones());
            
            insertar.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
    }
    
    public void modificarFecha(int id,String fecha){
        conectar();
        try {
            insertar = conect.prepareStatement(UPDATE+vacaciones+SET+"fecha_inicio='"+fecha+"', fecha_finaliza='"+c.obtenerFechaFinalizacion(fecha)+"' "+WHERE+"id="+id+";");
            insertar.executeUpdate();
            desconectar();
        } catch (SQLException e) {
        }
        
    }
    
    public boolean verifiacarFecha(String fecha){
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"DATEDIFF('"+fecha+"',CURDATE());");
            resultado.next();
            if(resultado.getInt(1)>6){
                desconectar();
                return true;
            }
        } catch (SQLException e) {
        }
        desconectar();
        return false;
    }
    
    
    public Vacacion getVacacion(int id){
        Vacacion v = null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"e.nombre,e.tipo,v.fecha_inicio,v.fecha_finaliza,e.id,v.id_empleado, v.dias,v.id  "+FROM+"empleado e left join vacaciones v on (e.id=v.id_empleado AND v.estado=0) "+WHERE+"e.id="+id+";");
            resultado.next();
            System.out.println(SELECT+"e.nombre,e.tipo,v.fecha_inicio,v.fecha_finaliza,e.id,v.id_empleado, v.dias,v.id  "+FROM+"empleado e left join vacaciones v on (e.id=v.id_empleado AND v.estado=0) "+WHERE+"e.id="+id+";");
            v= new Vacacion(resultado.getInt(5),resultado.getString(1) , resultado.getString(3), resultado.getString(4), resultado.getInt(7));
            v.setId(resultado.getInt(8));
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        
        return v;
    }
    
    
    public String generarFechaAleatoria(String fechaActual){
        String fecha = null;
        conectar();
        int numero = Integer.parseInt(fechaActual.substring(8,10));

        int dia=0;
        int mes=0;
        while (numero>dia) {            
            dia = getRamdon(27);
        }
        
        numero = Integer.parseInt(fechaActual.substring(5,7));

        while (numero>mes) {            
            mes = getRamdon(11);
        }
        
        fecha = fechaActual.substring(0,4)+"-"+encadenar(dia, mes);
        
        
        return fecha;
    }
    
    private int getRamdon(int condicion){
        int aleatoriao = (int)(Math.random()*condicion+1);

        return aleatoriao;
    }
    
    private String encadenar(int dia,int mes){
        String cadena = null;
        if(mes<10){
            cadena="0"+mes+"-";
        }else{
            cadena = mes+"-";
        }
        
        if(dia<10){
           cadena+="0"+dia;
        }else{
            cadena += dia;
        }

        return cadena;
    }
    
}
