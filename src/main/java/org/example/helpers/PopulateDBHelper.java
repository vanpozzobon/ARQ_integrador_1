package main.java.org.example.helpers;

import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Factura;
import main.java.org.example.entities.LineaFactura;
import main.java.org.example.entities.Producto;
import main.java.org.example.factories.DAOFactory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * PopulateDBHelper permite cargar los datos de los archivos CSV en la base de datos.
 */
public class PopulateDBHelper {
    private DAOFactory daoFactory;

    public PopulateDBHelper(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Carga los datos de los archivos CSV en la base de datos.
     * Los archivos CSV deben estar en la carpeta src/main/resources
     * Obtiene la lista de clientes, productos, facturas y lineas de factura y los guarda en la base de datos.
     */
    public void cargarArchivosCSV() {
        try {
            CSVHelper csvHelper = new CSVHelper(this.daoFactory);
            List<Cliente> clientes = csvHelper.getClientesFromCSV("clientes.csv");
            int agregados = 0;
            for (Cliente cliente : clientes) {
                daoFactory.getClienteDAO().save(cliente);
                agregados++;
            }
            List<Producto> productos = csvHelper.getProductosFromCSV("productos.csv");
            for (Producto producto : productos) {
                daoFactory.getProductoDAO().save(producto);
                agregados++;
            }
            List<Factura> facturas = csvHelper.getFacturasFromCSV("facturas.csv");
            for (Factura factura : facturas) {
                daoFactory.getFacturaDAO().save(factura);
                agregados++;
            }
            List<LineaFactura> lineasFactura = csvHelper.getLineaFacturaFromCSV("facturas-productos.csv");
            for (LineaFactura lineaFactura : lineasFactura) {
                daoFactory.getLineaFacturaDAO().save(lineaFactura);
                agregados++;
            }
            System.out.println("Se han agregado " + agregados + " registros a la base de datos.");
        } catch (IOException e) {
            System.out.println("Error al cargar los archivos CSV: " + e.getMessage());
        }
    }


}
