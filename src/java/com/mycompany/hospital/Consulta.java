
package com.mycompany.hospital;

public class Consulta {
    
    private int id;
    private String nombrePaciente,fecha;
    private double cuota;
    
    public Consulta(String nombrePaciente,String fecha,double cuota){
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.cuota = cuota;
    }
    public void serId(int id){
        this.id = id;
    }    
    
    public int getId(){
        return id;
    }
    public String getNombrePaciente(){
        return nombrePaciente;
    }
    public String getFecha(){
        return fecha;
    }
    public double getCuota(){
        return cuota;
    }
}
