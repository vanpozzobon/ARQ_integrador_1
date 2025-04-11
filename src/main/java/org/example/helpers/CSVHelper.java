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
import java.util.ArrayList;
import java.util.List;

/**
 * CSVHelper permite leer archivos CSV y convertirlos en objetos Java retornando una lista de objetos.
 */
public class CSVHelper {
    private DAOFactory daoFactory;

    public CSVHelper(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Recupera los registros del archivo CSV retornando un iterador de elementos CSVRecord.
     * Los elementos CSVRecord permiten acceder a la informacion contenida de forma indexada
     *
     * @param archivo nombre del archivo CSV que se desea leer
     * @return Iterador de elementos CSVRecord.
     * @throws IOException
     */
    private Iterable<CSVRecord> getData(String archivo) throws IOException {
        String path = "src\\main\\resources\\" + archivo;
        Reader in = new FileReader(path);
        String[] header = {};  // Puedes configurar tu encabezado personalizado aquí si es necesario
        CSVParser csvParser = CSVFormat.EXCEL.withHeader(header).parse(in);

        Iterable<CSVRecord> records = csvParser.getRecords();
        return records;
    }

    /**
     * Carga el archivo CSV correspondiente a los Clientes
     * Archivo clientes.csv
     *
     * @return Lista de objetos Cliente
     */
    public List<Cliente> getClientesFromCSV(String archivo) throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        Iterable<CSVRecord> records = getData(archivo);
        for (CSVRecord record : records) {
            if (record.get(0).equals("idCliente")) continue;
            if (record.size() >= 3) {
                int idCliente = Integer.parseInt(record.get(0));
                String nombre = record.get(1);
                String email = record.get(2);
                Cliente cliente = new Cliente(idCliente, nombre, email);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    /**
     * Carga el archivo CSV correspondiente a los Productos
     *
     * @return Lista de objetos Producto
     */
    public List<Producto> getProductosFromCSV(String archivo) throws IOException {
        List<Producto> productos = new ArrayList<>();
        Iterable<CSVRecord> records = getData(archivo);
        for (CSVRecord record : records) {
            if (record.get(0).equals("idProducto")) continue;
            if (record.size() >= 3) {
                int idProducto = Integer.parseInt(record.get(0));
                String nombre = record.get(1);
                double precio = Double.parseDouble(record.get(2));
                Producto producto = new Producto(idProducto, nombre, precio);
                productos.add(producto);
            }
        }
        return productos;
    }

    /**
     * Carga el archivo CSV correspondiente a las Facturas
     *
     * @return Lista de objetos Factura
     */
    public List<Factura> getFacturasFromCSV(String archivo) throws IOException {
        List<Factura> facturas = new ArrayList<>();
        Iterable<CSVRecord> records = getData(archivo);
        for (CSVRecord record : records) {
            if (record.get(0).equals("idFactura")) continue;
            if (record.size() >= 2) {
                int idFactura = Integer.parseInt(record.get(0));
                int idCliente = Integer.parseInt(record.get(1));
                Cliente cliente = daoFactory.getClienteDAO().get(idCliente);
                if (cliente != null) {
                    Factura factura = new Factura(idFactura, cliente);
                    facturas.add(factura);
                }
            }
        }
        return facturas;

    }

    /**
     * Carga el archivo CSV correspondiente a las Lineas de Factura
     *
     * @return Lista de objetos LineaFactura
     */
    public List<LineaFactura> getLineaFacturaFromCSV(String archivo) throws IOException {
        List<LineaFactura> lineasFactura = new ArrayList<>();
        Iterable<CSVRecord> records = getData(archivo);
        for (CSVRecord record : records) {
            if (record.get(0).equals("idFactura")) continue;
            if (record.size() >= 3) {
                int idFactura = Integer.parseInt(record.get(0));
                int idProducto = Integer.parseInt(record.get(1));
                int cantidad = Integer.parseInt(record.get(2));
                Producto producto = daoFactory.getProductoDAO().getProductoId(idProducto);
                Factura factura = daoFactory.getFacturaDAO().getFacturaId(idFactura);
                if (factura != null && producto != null) {
                    LineaFactura lineaFactura = new LineaFactura(factura, producto, cantidad);
                    lineasFactura.add(lineaFactura);
                }
            }
        }
        return lineasFactura;
    }
}
