package main.java.org.example.helpers.initilizer;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class MySQLDBInitializer implements DBInitilizer {
    private Connection conexion;

    /**
     * Método para inicializar la base de datos MySQL.
     * La inicializacion de la base de dato consta de la creacion de la base de datos en caso de no existir y la creacion de las tablas para los modelos del sistema.
     */
    @Override
    public void initDB() throws SQLException {
        this.generateCOnnection("");
        this.createDatabase();
        this.generateCOnnection("integrador1");
        this.createTableCliente();
        this.createTableFactura();
        this.createTableProducto();
        this.createTableLineaFactura();
    }

    private void generateCOnnection(String database) {
        // Implementación para inicializar la base de datos MySQL
        String driver = "com.mysql.cj.jdbc.Driver";
        String uri = "jdbc:mysql://localhost:3306/" + database;

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            this.conexion = DriverManager.getConnection(uri, "root", "");
            this.conexion.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS integrador1";
        PreparedStatement stm = this.conexion.prepareStatement(sql);
        stm.execute();
        this.conexion.commit();
    }

    private void createTableCliente() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cliente (" +
                     "idCliente INT AUTO_INCREMENT PRIMARY KEY, " +
                     "nombre VARCHAR(500) NOT NULL, " +
                     "email VARCHAR(150) NOT NULL" +
                     ");";
        PreparedStatement stm = this.conexion.prepareStatement(sql);
        stm.execute();
        this.conexion.commit();
    }

    private void createTableProducto() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS producto (idProducto INT AUTO_INCREMENT PRIMARY KEY,\n" +
                     "    nombre VARCHAR(45) NOT NULL,\n" +
                     "    valor FLOAT NOT NULL);";
        PreparedStatement stm = this.conexion.prepareStatement(sql);
        stm.execute();
        this.conexion.commit();
    }

    private void createTableFactura() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS factura (idFactura INT AUTO_INCREMENT PRIMARY KEY,\n" +
                     "    idCliente INT NOT NULL,\n" +
                     "     FOREIGN KEY (idCliente) REFERENCES cliente(idCLiente));";
        PreparedStatement stm = this.conexion.prepareStatement(sql);
        stm.execute();
        this.conexion.commit();
    }

    private void createTableLineaFactura() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS factura_producto (\n" +
                     "    idFactura INT,\n" +
                     "    idProducto INT,\n" +
                     "    cantidad FLOAT,\n" +
                     "    PRIMARY KEY (idFactura, idProducto),\n" +
                     "    FOREIGN KEY (idFactura) REFERENCES factura(idFactura),\n" +
                     "    FOREIGN KEY (idProducto) REFERENCES producto(idProducto)\n" +
                     ");";

        PreparedStatement stm = this.conexion.prepareStatement(sql);
        stm.execute();
        this.conexion.commit();
    }
}
