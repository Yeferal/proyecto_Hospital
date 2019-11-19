
package com.hospital.recepcionista;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Paciente;
import com.mycompany.hospital.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaRecepcion extends Conexion{
    
    /*retorna un listado de medicos*/
    public List listarMedicos(){
        List<Usuario> lista = new ArrayList<>();
        Usuario u=null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"tipo='Medico';");
            while (resultado.next()) {
                u = new Usuario(resultado.getString(2),"");                
                u.setId(resultado.getInt(1));
                
                lista.add(u);
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    /*retorna un listado de enfermeros*/
    public List listarEnfermeros(){
        List<Usuario> lista = new ArrayList<>();
        Usuario u=null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+empleado+WHERE+"tipo='Enfermeria' AND alta=0;");
            while (resultado.next()) {                
                u = new Usuario(resultado.getString(2),"");                
                u.setId(resultado.getInt(1));
                
                lista.add(u);
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    /*retorna un listado de pacieintes*/
    public List listarPacientes(){
        List<Paciente> lista = new ArrayList<>();
        Paciente p=null;
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+paciente+"WHERE alta=0;");
            while (resultado.next()) { 
                p = new Paciente(resultado.getInt(5), resultado.getInt(6), resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(7));
                p.setId(resultado.getInt(1));
                p.setListaMedicos(listarMedicosPaciente(p.getId()));
                p.setListaEnfermeros(listarEnfermerosPaciente(p.getId()));
                
                lista.add(p);
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    /*retorna una lista de habitaciones disponibles*/
    public List listarHabitacionesDisponibles(){
        List<Integer> lista = new ArrayList<>();
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+habitacion+WHERE+"paciente=0 AND estado=1;");
            while (resultado.next()) {                
                
                lista.add(resultado.getInt(1));
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    /*retorna un listado de medicos por paciente*/
    public List listarMedicosPaciente(int id){
        List<String> lista = new ArrayList<>();
        try {
            Statement stmt1 = conect.createStatement();
            ResultSet resultado1 = stmt1.executeQuery(SELECT+"nombre_empleado "+FROM+asignacion+WHERE+"id_paciente="+id+" AND tipo='Medico';");
            while (resultado1.next()) {
                System.out.println(resultado1.getString(1));
                lista.add(resultado1.getString(1));
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    /*retorna un listado de los enfermeros por paciente*/
    public List listarEnfermerosPaciente(int id){
        List<String> lista = new ArrayList<>();
        try {
            Statement stmt1 = conect.createStatement();
            ResultSet resultado1 = stmt1.executeQuery(SELECT+"nombre_empleado "+FROM+asignacion+WHERE+"id_paciente="+id+" AND tipo='Enfermeria';");
            System.out.println(SELECT+"nombre_empleado "+FROM+asignacion+WHERE+"id_paciente="+id+" AND tipo='Enfermeria';");
            while (resultado1.next()) {
                System.out.println(resultado1.getString(1));
                lista.add(resultado1.getString(1));
            }
        } catch (SQLException e) {
        }
        return lista;
    }
}
