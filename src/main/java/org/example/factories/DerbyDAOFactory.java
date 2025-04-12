package main.java.org.example.factories;

import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DAO.interfaces.FacturaDAO;
import main.java.org.example.DAO.interfaces.LineaFactDAO;
import main.java.org.example.DAO.interfaces.ProductoDAO;

import java.sql.Connection;

public class DerbyDAOFactory extends DAOFactory {
    Connection con;
    private static DerbyDAOFactory instance = null;

    @Override
    public ClienteDAO getClienteDAO() {
        return null;
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return null;
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        return null;
    }

    @Override
    public LineaFactDAO getLineaFacturaDAO() {
        return null;
    }

    public static synchronized DerbyDAOFactory getInstance() {
        if (instance == null) {
            instance = new DerbyDAOFactory();
        }
        return instance;
    }
}
