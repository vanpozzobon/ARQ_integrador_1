package main.java.org.example.entities;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String email;

    public Cliente(){
    }
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public Cliente(int idCliente, String nombre, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Cliente{" +
               "idCliente=" + idCliente +
               ", nombre='" + nombre + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return this.getIdCliente() == cliente.getIdCliente();
    }
}
