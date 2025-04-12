package main.java.org.example.factories;

import main.java.org.example.ConcreteDaos.ClienteMySQLDAO;
import main.java.org.example.ConcreteDaos.FacturaMySQLDAO;
import main.java.org.example.ConcreteDaos.LineaFacturaMySQLDAO;
import main.java.org.example.ConcreteDaos.ProductoMySQLDAO;
import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DAO.interfaces.FacturaDAO;
import main.java.org.example.DAO.interfaces.LineaFactDAO;
import main.java.org.example.DAO.interfaces.ProductoDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {
    private static Connection conn = null;
    private static MySQLDAOFactory instance = null;

    @Override
    public ClienteDAO getClienteDAO() {
        return new ClienteMySQLDAO(getConnection());
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return new ProductoMySQLDAO(getConnection());
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        return new FacturaMySQLDAO(getConnection());
    }

    @Override
    public LineaFactDAO getLineaFacturaDAO() {
        return new LineaFacturaMySQLDAO(getConnection());
    }

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String uri = "jdbc:mysql://localhost:3306/integrador1";

    private MySQLDAOFactory() {
    }

    public static synchronized MySQLDAOFactory getInstance() {
        if (instance == null) {
            instance = new MySQLDAOFactory();
        }
        return instance;
    }

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }
        String driver = DRIVER;
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            conn = DriverManager.getConnection(uri, "root", "");
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
