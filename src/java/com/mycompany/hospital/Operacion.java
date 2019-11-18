
package com.mycompany.hospital;

public class Operacion {
    
    private int id;
    private String fecha,cliente,medico,descripcion;
    
    
    
    public Operacion(String fecha,String cliente, String medico){
        this.fecha = fecha;
        this.cliente = cliente;
        this.medico = medico;
        
    }
    public void setId(int id){
        this.id = id;
    }
    public int getIg(){
        return id;
    }
    public String getFecha(){
        return fecha;
    }
    public String getCliente(){
        return cliente;
    }
    public String getMedico(){
        return medico;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
}
