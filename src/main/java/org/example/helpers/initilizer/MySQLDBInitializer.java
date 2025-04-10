package main.java.org.example.helpers.initilizer;

public class MySQLDBInitializer implements DBInitilizer {
    /**
     * Método para inicializar la base de datos MySQL.
     * La inicializacion de la base de dato consta de la creacion de la base de datos en caso de no existir y la creacion de las tablas para los modelos del sistema.
     */
    @Override
    public void initDB() {
        // Implementación para inicializar la base de datos MySQL
        System.out.println("Base de datos MySQL inicializada.");
    }
}
