package main.java.org.example.factories;

import java.sql.Connection;

public class DerbyDAOFactory extends DAOFactory {
    Connection con;

    @Override
    public ClienteDao getClienteDAO() {
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
    public LineaProductoDAO getLineaProductoDAO() {
        return null;
    }
}
