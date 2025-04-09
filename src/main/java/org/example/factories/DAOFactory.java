package main.java.org.example.factories;



public abstract class  DAOFactory {

    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;
    public abstract ClienteDao getClienteDAO();
    public abstract ProductoDAO getProductoDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract LineaProductoDAO getLineaProductoDAO();

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
