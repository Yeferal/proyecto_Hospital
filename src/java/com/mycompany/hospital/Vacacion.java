
package com.mycompany.hospital;

public class Vacacion {
    private int id, idEmpleado,estado,dias;
    private String nombreEmpleado,fechaInicio,fechaFinaliza, tipo;
    
    
    public Vacacion(int idEmpleado,String nombreEmpleado,String fechaInicio, String fechaFinaliza,int dias){
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.fechaInicio = fechaInicio;
        this.fechaFinaliza = fechaFinaliza;
        this.dias = dias;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    public void setIdEmpleado(int idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    public void setNombreEmpleado(String nombreEmpleado){
        this.nombreEmpleado = nombreEmpleado;
    }
    public void setFechaInicio(String fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFinaliza(String fechaFinaliza){
        this.fechaFinaliza = fechaFinaliza;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }
    public void setDias(int dias){
        this.dias = dias;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public int getId(){
        return id;
    }
    public int getIdEmpleado(){
        return idEmpleado;
    }
    public String getNombreEmpleado(){
        return nombreEmpleado;
    }
    public String getFechaInicio(){
        return fechaInicio;
    }
    public String getFechaFinaliza(){
        return fechaFinaliza;
    }
    public int getEstado(){
        return estado;
    }
    public int getDias(){
        return dias;
    }
    public String getTipo(){
        return tipo;
    }
}
