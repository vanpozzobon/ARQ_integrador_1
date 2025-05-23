package main.java.org.example.entities;

public class Producto {
    private int idProducto;
    private String nombre;
    private float valor;

    public Producto() {
    }

    public Producto(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Producto(int idProducto, String nombre, float valor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "Producto{" +
               "idProducto=" + idProducto +
               ", nombre='" + nombre + '\'' +
               ", valor=" + valor +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return this.getIdProducto() == producto.getIdProducto();
    }
}
