/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class IngresoConsulta {
    
    private double subTotal;
    private List<Consulta> consulta = new ArrayList<>();
    
    
    public IngresoConsulta(List consulta,double subTotal){
        this.consulta = consulta;
        this.subTotal = subTotal;
    }
    
    public List getConsulta(){
        return consulta;
    }
    public double getSubTotal(){
        return subTotal;
    }
}
