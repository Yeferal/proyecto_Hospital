
package com.mycompany.hospital;


public class Medicamento {
    private int id,cantidad,minimo;
    private double precio,costo;
    private String nombre;
    
    public Medicamento(String nombre,double precio,double costo,int cantidad, int minimo){
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.cantidad = cantidad;
        this.minimo = minimo;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public void setCosto(double costo){
        this.costo = costo;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setMinimo(int minimo){
        this.minimo = minimo;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNombre(){
        return  nombre;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public int minimo(){
        return minimo;
    }
}
