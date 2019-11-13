
package com.mycompany.hospital;

public class Compra {
    private int id, idFactura,cantidad;
    private String nombreMedicamento,fecha;
    private double precio,total;
    
    public Compra(int idFactura,String nombreMedicamento,String fecha,double precio,int cantidad,double total){
        this.idFactura = idFactura;
        this.nombreMedicamento = nombreMedicamento;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setIdFactura(int idFactura){
        this.idFactura = idFactura;
    }
    public void setNombreMedicamento(String nombreMedicamento){
        this.nombreMedicamento = nombreMedicamento;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setTotal(double total){
        this.total = total;
    }
    
    public int getId(){
        return id;
    }
    public int getIdFactura(){
        return idFactura;
    }
    public String getNombreMedicamento(){
        return nombreMedicamento;
    }
    public String getFecha(){
        return fecha;
    }
    public double getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getTotal(){
        return total;
    }
}
