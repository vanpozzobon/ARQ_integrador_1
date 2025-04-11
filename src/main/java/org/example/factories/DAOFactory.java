package main.java.org.example.factories;


import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DAO.interfaces.FacturaDAO;
import main.java.org.example.DAO.interfaces.LineaFactDAO;
import main.java.org.example.DAO.interfaces.ProductoDAO;

public abstract class  DAOFactory {

    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;
    public abstract ClienteDAO getClienteDAO();
    public abstract ProductoDAO getProductoDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract LineaFactDAO getLineaFacturaDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC : {
                return MySQLDAOFactory.getInstance();
            }
            case DERBY_JDBC:
                return DerbyDAOFactory.getInstance();
            default:
                throw new IllegalArgumentException("Invalid factory type: " + whichFactory);
        }
    }
}
