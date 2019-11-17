
package com.mycompany.hospital;


public class Venta {
    private int id, idFactura,cantidad;
    private String nombreEmpleado,nombreCliente,nombreMedicamento,fecha;
    private double precio,total, costo;
    
    public Venta(String nombreEmpleado, String nombreCliente,String nombreMedicamento,double precio,int cantidad,double total){
        this.nombreEmpleado = nombreEmpleado;
        this.nombreCliente = nombreCliente;
        this.nombreMedicamento = nombreMedicamento;
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
    public void setNombreEmpleado(String nombreEmpleado){
        this.nombreEmpleado = nombreEmpleado;
    }
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
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
    public void setCosto(double costo){
        this.costo= costo;
    }
    
    public int getId(){
        return id;
    }
    public int getIdFactura(){
        return idFactura;
    }
    public String getNombreEmpleado(){
        return nombreEmpleado;
    }
    public String getNombreCliente(){
        return nombreCliente;
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
    
    public double getGanancia(){
        return total-costo*cantidad;
    }
    public double  getCosto(){
        return costo;
    }
}
