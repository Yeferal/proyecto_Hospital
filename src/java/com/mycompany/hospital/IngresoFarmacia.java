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
public class IngresoFarmacia {
    
    private double subTotal;
    private List<Venta> venta = new ArrayList<>();
    
    
    public IngresoFarmacia(List venta,double subTotal){
        this.venta = venta;
        this.subTotal = subTotal;
    }
    
    public List getVenta(){
        return venta;
    }
    public double getSubTotal(){
        return subTotal;
    }
    
}
