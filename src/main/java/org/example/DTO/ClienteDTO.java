package main.java.org.example.DTO;

public class ClienteDTO {
    private String nombre;
    private String email;
    private int cantidad_vendida;

    public ClienteDTO(String nombre, String email, int cantidad) {
        this.nombre = nombre;
        this.email = email;
        this.cantidad_vendida = cantidad;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
               ", email='" + email + '\'' +
               ", cantidad_vendida=" + cantidad_vendida;
    }
}
