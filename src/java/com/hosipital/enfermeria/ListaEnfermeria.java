/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosipital.enfermeria;

import com.hospital.conexiones.Conexion;
import static com.hospital.conexiones.Conexion.FROM;
import static com.hospital.conexiones.Conexion.SELECT;
import static com.hospital.conexiones.Conexion.medicamento;
import com.mycompany.hospital.Medicamento;
import com.mycompany.hospital.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class ListaEnfermeria extends Conexion{
    
    private List<Paciente> listaHistorial = null;
    
    public List listarPacientes(int id){
        List<Paciente> lista = new ArrayList<>();
        conectar();
        Paciente p = null;
        System.out.println(id);
        listaHistorial = new ArrayList<>();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT id_paciente,nombre_paciente,nombre_empleado FROM asignacion WHERE id_empleado="+id+" AND tipo='Enfermeria';");
            while (resultado.next()) {                
                p = new Paciente(0, 0, resultado.getString(2), "", "", "");
                p.setId(resultado.getInt(1));

                lista.add(p);
                listarHistoria(p.getId());
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return lista;
    }
    
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
    public void listarHistoria(int id){
        Paciente p = null;
        try {
            Statement stmt1 = conect.createStatement();
            ResultSet resultado1 = stmt1.executeQuery("SELECT h.*,p.nombre FROM historial_medico h join paciente p on (h.id_paciente=p.id) WHERE h.tipo='Suministro' AND h.id_paciente="+id+" ORDER BY fecha;");
            while (resultado1.next()) {                
                p = new Paciente(0, 0, resultado1.getString(7), "", "", resultado1.getString(4));
                p.setFechaNacimiento(resultado1.getString(3));
                p.setId(resultado1.getInt(1));

                listaHistorial.add(p);
                
            }
        } catch (SQLException e) {
        }
        
    }
    public List getHistoria(){
        return listaHistorial;
    }
    
}
