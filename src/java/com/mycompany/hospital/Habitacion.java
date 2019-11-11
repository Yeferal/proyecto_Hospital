
package com.mycompany.hospital;


public class Habitacion {
    
    private int id, idPaciente,estado;
    private double costo, cuota;
    private String estadoTexto;
    
    public Habitacion(int estado,double costo,double cuota){
        this.estado = estado;
        this.costo = costo;
        this.cuota = cuota;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setPaciente(int idPaciente){
        this.idPaciente = idPaciente;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public void setCosto(double costo){
        this.costo = costo;
    }
    
    public void setCuota(double cuota){
        this.cuota = cuota;
    }
    
    public void setEstadoTexto(String estadoTexto){
        this.estadoTexto = estadoTexto;
    }
    
    
    public int getId(){
        return id;
    }
    
    public int getPaciente(){
        return idPaciente;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public double getCuota(){
        return cuota;
    }
    
    public String getEstadoTexto(){
        if(estado==0){
            estadoTexto="Inhabilitado";
            return estadoTexto;
        }else{
            estadoTexto = "Habilitado";
        }
        return estadoTexto;
     
    }
}
