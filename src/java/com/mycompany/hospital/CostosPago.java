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
public class CostosPago {
    
    private double subTotal;
    private List<Pago> pago = new ArrayList<>();
    
    
    public CostosPago(List pago,double subTotal){
        this.pago = pago;
        this.subTotal = subTotal;
    }
    
    public List getPago(){
        return pago;
    }
    public double getSubTotal(){
        return subTotal;
    }
    
}
