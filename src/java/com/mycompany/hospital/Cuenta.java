
package com.mycompany.hospital;

public class Cuenta {
    
    private int id,pagado;
    private String nombrePaciente,descripcion;
    private double total;
    
    public Cuenta(String nombrePaciente,String descripcion,double total){
        this.nombrePaciente = nombrePaciente;
        this.descripcion = descripcion;
        this.total = total;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setPagado(int pagado){
        this.pagado = pagado;
    }
    
    public int getId(){
        return id;
    }
    public int getPagado(){
        return pagado;
    }
    public String getNombrePaciente(){
        return nombrePaciente;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getTotal(){
        return total;
    }
}
