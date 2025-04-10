package main.java.org.example.helpers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * CSVService es un servicio que permite leer archivos CSV y convertirlos en objetos Java retornando una lista de objetos.
 */
public class PopulateDBHelper {

    /**
     * Recupera los registros del archivo CSV retornando un iterador de elementos CSVRecord.
     * Los elementos CSVRecord permiten acceder a la informacion contenida de forma indexada
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
     * Orquestador que permite cargar todos los tipos de archivos CSV que contiene el sistema
     */
    public void cargarArchivosCSV(){
        this.cargarArchivoClientes();
        this.cargarArchivoProductos();
        this.cargarArchivoFacturas();
        this.cargarArchivoFacturasProductos();
    }

    /**
     * Carga el archivo CSV correspondiente a los Clientes
     * Archivo clientes.csv
     */
    private void cargarArchivoClientes(){

    }
    private void cargarArchivoProductos(){

    }
    private void cargarArchivoFacturas(){

    }
    private void cargarArchivoFacturasProductos(){

    }
}
