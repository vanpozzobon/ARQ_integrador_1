package main.java.org.example.factories;

import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DAO.interfaces.FacturaDAO;
import main.java.org.example.DAO.interfaces.LineaFactDAO;
import main.java.org.example.DAO.interfaces.ProductoDAO;

import java.sql.Connection;

public class MySQLDAOFactory extends DAOFactory {
    Connection con;
    
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

}
