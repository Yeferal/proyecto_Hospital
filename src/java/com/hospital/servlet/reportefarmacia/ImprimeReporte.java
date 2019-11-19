/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.servlet.reportefarmacia;

import com.hospital.conexiones.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author yefer
 */
public class ImprimeReporte extends Conexion{
    
    
    
    public void imprimir1(List listado) throws FileNotFoundException {
                conectar();
        try {
            
            System.out.println("hola");
            JasperPrint jasperPrint2 = JasperFillManager.fillReport(getClass().getResourceAsStream("Farmacia2.jasper"),null,new JRBeanCollectionDataSource(listado));
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Farmacia2.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
            System.out.println("Lo hixzo");
        } catch ( JRException ex) {
            ex.printStackTrace();
        }
                try {
                    File objetFile = new File("Farmacia2.pdf");
                    Desktop.getDesktop().open(objetFile);
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
        
        
        System.out.println("hola");
        desconectar();
        
    }
}
