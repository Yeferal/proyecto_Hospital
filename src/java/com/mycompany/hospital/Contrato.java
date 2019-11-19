
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private int id;
    private String nombre, fecha,registro;
    private String cui;
    private double salario;
    private String tipo;
    
    public Contrato(String nombre,String cui,double salario,String registro,String tipo,String fecha){
        this.nombre = nombre;
        this.cui = cui;
        this.salario = salario;
        this.registro = registro;
        this.tipo = tipo;
        this.fecha = fecha;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCui(String cui){
        this.cui = cui;
    }
    
    
    public void setSalario(double salario){
        this.salario = salario;
    }

    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
   
    
    
    
    public String getRegistro(){
        return registro;
    }
    public String getFecha(){
        return fecha;
    }
    public String getfecha_registro(){
        return fecha;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCui(){
        return cui;
    }
    public String getcui_empleado(){
        return cui;
    }
    public double getsalario_empleado(){
        return salario;
    }
    
    
    public double getSalario(){
        return salario;
    }
    
    
    public String getTipo(){
        return tipo;
    }
    public String getarea_trabajo(){
        return tipo;
    }
    public String gettipo_historial(){
        return registro;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setRegistro(String registro){
        this.registro = registro;
    }
    public String getEmpleado(){
        return nombre;
    }
}
