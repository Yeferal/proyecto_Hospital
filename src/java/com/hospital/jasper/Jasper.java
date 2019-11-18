
package com.hospital.jasper;

import com.hospital.conexiones.Conexion;
import static com.mysql.cj.jdbc.admin.TimezoneDump.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import static java.lang.Math.exp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class Jasper extends Conexion{
    
            public void imprimir(List listado) throws FileNotFoundException {
                conectar();
        try {
            
            System.out.println(getClass().getResource("jasper/Farmacia1.jasper"));
            
            InputStream inputStream       = getClass().getResourceAsStream("./Farmacia1.jasper");
//            Reader      inputStreamReader = new InputStreamReader(inputStream);
            
            
            System.out.println(inputStream);
            JasperPrint jasperPrint2 = JasperFillManager.fillReport(getClass().getResourceAsStream("Farmacia1.jasper"),null,new JRBeanCollectionDataSource(listado));
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte1.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
            System.out.println("Lo hixzo");
        } catch ( JRException ex) {
            ex.printStackTrace();
        }
        desconectar();
        
    }
}
