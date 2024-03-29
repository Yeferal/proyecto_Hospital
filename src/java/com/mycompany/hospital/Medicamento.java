
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.List;


public class Medicamento {
    private int id,cantidad,minimo;
    private double precio,costo;
    private String nombre;
    private List<Venta> ventas = new ArrayList<>();
    
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
    
    public void setListaVentas(List ventas){
        this.ventas = ventas;
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
    
    public int getMinimo(){
        return minimo;
    }
    
    public List getVentas(){
        return ventas;
    }
}
