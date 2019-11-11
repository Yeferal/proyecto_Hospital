
package com.mycompany.hospital;

public class Pago {
    private int id, idGerente;
    private String nombreEmpleado, cuiEmpleado, tipo, nombreGerente,fecha;
    private double pago;
    
    public Pago(String nombreEmpleado,String cuiEmpleado,String fecha,String tipo,int idGerente,String nombreGerente,double pago){
        this.nombreEmpleado = nombreEmpleado;
        this.cuiEmpleado = cuiEmpleado;
        this.fecha = fecha;
        this.tipo = tipo;
        this.idGerente = idGerente;
        this.nombreGerente = nombreGerente;
        this.pago = pago;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setIdGerente(int idGerente){
        this.idGerente = idGerente;
    }
    
    public void setNombreEmpleado(String nombreEmpleado){
        this.nombreEmpleado = nombreEmpleado;
    }
    
    public void setCuiEmpleado(String cuiEmpleado){
        this.cuiEmpleado = cuiEmpleado;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setNombreGerente(String nombreGerente){
        this.nombreGerente = nombreGerente;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public void setPago(double pago){
        this.pago = pago;
    }
    
    public int getId(){
        return id;
    }
    
    public int getIdGerente(){
        return idGerente;
    }
    
    public String getNombreEmpleado(){
        return nombreEmpleado;
    }
    
    public String getCuiEmpleado(){
        return cuiEmpleado;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getNombreGerente(){
        return nombreGerente;
    }
    public String getFecha(){
        return fecha;
    }
    
    public double getPago(){
        return pago;
    }
}
