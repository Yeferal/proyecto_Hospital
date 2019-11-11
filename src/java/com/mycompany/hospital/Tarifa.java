
package com.mycompany.hospital;


public class Tarifa {

    private int id;
    private String tipo;
    private double precio,costo,cuota;

    public Tarifa(String tipo,double precio,double costo,double cuota){
        this.tipo = tipo;
        this.precio = precio;
        this.costo = costo;
        this.cuota =  cuota;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public void setCosto(double costo){
        this.costo = costo;
    }
    
    public void setCuota(double cuota){
        this.cuota =  cuota;
    }
    
    
    public int getId(){
        return id;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public double getCuota(){
        return cuota;
    }
    
}
