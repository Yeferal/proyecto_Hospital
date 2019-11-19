/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

import com.hospital.conexiones.Conexion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class CostosFarmacia extends Conexion{
    
    
    private double subTotal;
    private List<Compra> compra = new ArrayList<>();
    
    
    public CostosFarmacia(List compra,double subTotal){
        this.compra = compra;
        this.subTotal = subTotal;
    }
    
    public List getCompra(){
        return compra;
    }
    public double getSubTotal(){
        return subTotal;
    }
}
