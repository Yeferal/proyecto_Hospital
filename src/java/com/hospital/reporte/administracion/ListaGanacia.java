
package com.hospital.reporte.administracion;

import com.hospital.conexiones.Conexion;
import com.mycompany.hospital.Compra;
import com.mycompany.hospital.Cuenta;
import com.mycompany.hospital.IngresoCuenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaGanacia extends Conexion{
    
    
    public IngresoCuenta getGananciaCuenta(String fecha1,String fecha2){
        IngresoCuenta ganancia = null;
        
        ganancia = new IngresoCuenta(listarCuenta(fecha1, fecha2),getTotalCuenta(fecha1, fecha2) );
        
        return ganancia;
        
    }
    
    
    public double getTotalCuenta(String fecha1,String fecha2){
        conectar();
        double total=0;
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT sum(Total) subtotal FROM cuenta;");
            resultado.next();
            total = resultado.getDouble(1);
            desconectar();
        } catch (Exception e) {
        }
        return total;
    }
    
    public List listarCuenta(String fecha1, String fecha2){
        List<Cuenta> lista = new ArrayList<>();
        Cuenta p = null;
        
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM cuenta;");

            while (resultado.next()) {                
                p = new Cuenta(resultado.getString(2), resultado.getString(3), resultado.getDouble(4));
                p.setId(resultado.getInt(1));

                lista.add(p);
            }
            desconectar();
            }catch (SQLException e) {
            e.printStackTrace();
        }
            
        
        return lista;
    }
}
