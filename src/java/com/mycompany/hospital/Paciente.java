
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id,edad,habitacion;
    private String nombre,cui,fechaNacimiento,fechaIngreso;
    private List<String> medicos = new ArrayList<>();
    private List<String> enfermeros = new ArrayList<>();
    
    public Paciente(int edad, int habitacion,String nombre,String cui, String fechaNacimiento, String fechaIngreso){
        this.edad = edad;
        this.habitacion = habitacion;
        this.nombre =nombre;
        this.cui = cui;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }
    
    public void setId(int id ){
        this.id = id;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setHabitacion(int habitacion){
        this.habitacion = habitacion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCui(String cui){
        this.cui = cui;
    }
    
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setFechaIngreso(String fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }
    public void setListaMedicos(List medicos){
        this.medicos = medicos;
    }
    public void setListaEnfermeros(List enfermeros){
        this.enfermeros = enfermeros;
    }
    
    
    public int getId(){
        return id;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public int getHabitacion(){
        return habitacion;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getCui(){
        return cui;
    }
    
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public String getFechaIngreso(){
        return fechaIngreso;
    }
    
    public List getEnfermeros(){
        return enfermeros;
    }
    
    public List getMedicos(){
        return medicos;
    }
}
