package org.example;

import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DTO.ClienteDTO;
import main.java.org.example.DTO.ProductoDTO;
import main.java.org.example.factories.DAOFactory;
import main.java.org.example.factories.MySQLDAOFactory;
import main.java.org.example.helpers.PopulateDBHelper;
import main.java.org.example.helpers.initilizer.MySQLDBInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Desea crear la base de datos? (yes/no) [no]");
            String opcion = entrada.readLine();
            if (opcion.equals("yes") || opcion.equals("YES")) {
                //Punto 1 del integrador 1. Permite crear la estructura de la base de datos con las respectivas tablas.
                MySQLDBInitializer ms = new MySQLDBInitializer();
                try {
                    ms.initDB();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error en la inicialización de la base de datos");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al ingresar la opcion");
            System.exit(1);
        }
        DAOFactory daofactory = DAOFactory.getDAOFactory(1);
        try {
            BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Desea cargar los archivos CSV? (yes/no) [yes]");
            String opcion2 = entrada2.readLine();
            if (opcion2.equals(""))
                opcion2 = "yes";
            if (opcion2.equals("yes") || opcion2.equals("YES")) {
                //Punto 2 del integrador 1. Permite cargar los archivos CSV en la base de datos
                PopulateDBHelper pop = new PopulateDBHelper(daofactory);
                pop.cargarArchivosCSV();

            }
        } catch (IOException e) {
            System.out.println("Error al ingresar la opcion");
            System.exit(1);
        }
        //Punto 3 del integrador 1. Se obtiene el Producto con mayor recaudacion.
        ProductoDTO prod = daofactory.getProductoDAO().get_producto_mayor_recaudacion();
        System.out.println("\nProducto con mayor recaudacion " + prod);

        //Punto 4 del integrador 1. Se obtiene la lista de clientes ordenada por mayor facturacion.
        List<ClienteDTO> clientes = daofactory.getClienteDAO().get_lista_clientes_mayor_facturacion();

        System.out.println("\nLista de clientes con mayor facturación:");
        for (ClienteDTO cliente : clientes) {
            System.out.println(cliente);
        }
    }
}