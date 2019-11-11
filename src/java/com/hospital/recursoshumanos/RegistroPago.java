
package com.hospital.recursoshumanos;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Pago;
import com.mycompany.hospital.Usuario;
import java.sql.SQLException;

public class RegistroPago extends Conexion{
    
    /*inserta un pago en la DB*/
    public void insertarPago(Pago pago){
        conectar();
        System.out.println("entro");
        try {
            insertar = conect.prepareStatement(INSERT+pagos+"(nombre_empleado,cui_empleado,fecha,tipo,id_gerente,nombre_gerente,pago_empleado) "+VALUES+"(?,?,?,?,?,?,?);");
            
            insertar.setString(1, pago.getNombreEmpleado());
            insertar.setString(2, pago.getCuiEmpleado());
            insertar.setString(3, pago.getFecha());
            insertar.setString(4, pago.getTipo());
            insertar.setInt(5, pago.getIdGerente());
            insertar.setString(6, pago.getNombreGerente());
            insertar.setDouble(7, pago.getPago());
            
            insertar.executeUpdate();
            System.out.println("termino");
            desconectar();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*retorna un empleado*/
    public Usuario getUsuario(int id){
        Usuario usuario= null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"id="+id+";");
            resultado.next();
            usuario = new Usuario(resultado.getString(2),resultado.getString(3));
            usuario.setId(resultado.getInt(1));
            desconectar();
        } catch (SQLException e) {
        }
        return usuario;
    }
    /*retorna una empleado*/
    public Usuario getEmpleado(int id){
        Usuario usuario= null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"id="+id+";");
            resultado.next();
            usuario = new Usuario(resultado.getString(2),resultado.getString(3));
            usuario.setId(resultado.getInt(1));
            desconectar();
        } catch (SQLException e) {
        }
        return usuario;
    }
    /*retorna a un especialista*/
    public Usuario getEspecialista(int id){
        Usuario usuario= null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+especialistas+WHERE+"id="+id+";");
            resultado.next();
            usuario = new Usuario(resultado.getString(2),resultado.getString(3));
            usuario.setId(resultado.getInt(1));
            desconectar();
        } catch (SQLException e) {
        }
        return usuario;
    }
}
