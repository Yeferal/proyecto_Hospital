
package com.hospital.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    
    
    public Connection conect = null;
    public PreparedStatement insertar;
    public Statement stmt;
    public ResultSet resultado;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "usuario";
    private String password = "123456";
    private String servidor = "jdbc:mysql://localhost:3306/hospital";
    
    public final static String INSERT = "INSERT INTO ";
    public final static String INTO = "INTO ";
    public final static String VALUES = "VALUES ";
    public final static String UPDATE = "UPDATE ";
    public final static String SELECT = "SELECT ";
    public final static String FROM = "FROM ";
    public final static String WHERE ="WHERE ";
    public final static String SET = "SET ";
    public final static String DELETE = "DELETE ";
    
    public final static String administrador = "administrador ";
    public final static String areas = "areas ";
    public final static String habitacion = "habitacion ";
    public final static String normativo = "normativo ";
    public final static String recursosHumanos = "recursos_humanos ";
    public final static String gerente = "gerente ";
    public final static String tarifario = "tarifario ";
    public final static String especialistas = "especialistas ";
    public final static String paciente = "paciente ";
    public final static String empleado = "empleado ";
    public final static String pagos = "pagos ";
    public final static String historiaLaboral = "historia_laboral ";
    public final static String vacaciones = "vacaciones ";
    public final static String asignacion = "asignacion ";
    public final static String consulta = "consulta ";
    public final static String cuenta = "cuenta ";
    public final static String historialMedico = "historial_medico ";
    public final static String medicamento = "medicamento ";
    public final static String compraMedicamento = "compra_medicamento ";
    public final static String ventaMedicamento = "venta_medicamento ";
    public final static String usuarioTabla = "usuario ";
    
    
    public Conexion(){
        
    }
    //conecta a la base de datos
    public void conectar(){
        
        try {
            Class.forName(driver);
            conect = DriverManager.getConnection(servidor, user, password);
            System.out.println("Se conecto XD: "+conect.getCatalog());
        } catch (SQLException e) {
            System.out.println("No se Conecto");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Fallo de class");
        }
    }
    //desconecta de la base de datos
    public void desconectar(){
        try {
             //&& !conect.isClosed()
            if(conect != null && !conect.isClosed()){
            conect.close();
            System.out.println("Se cierrar conexion");
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al cerrar conexion");
        }
    }
    
    
}
