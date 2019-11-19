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
public class IngresoCuenta {
    
    private double subTotal;
    private List<Cuenta> cuenta = new ArrayList<>();
    
    
    public IngresoCuenta(List cuenta,double subTotal){
        this.cuenta = cuenta;
        this.subTotal = subTotal;
    }
    
    public List getCuenta(){
        return cuenta;
    }
    public double getSubTotal(){
        return subTotal;
    }
}
