package main.java.org.example.entities;

public class LineaFactura {
    private Factura factura;
    private Producto producto;
    private int cantidad;

    public LineaFactura() {
    }
    public LineaFactura(Factura factura, Producto producto, int cantidad) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    @Override
    public String toString() {
        return "Linea factura{" +
               factura.toString() +
               ", " + producto.toString() +
               ", cantidad=" + cantidad +
               '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineaFactura)) return false;
        LineaFactura lineaFactura = (LineaFactura) o;
        return this.getFactura().equals(lineaFactura.getFactura()) && this.getProducto().equals(lineaFactura.getProducto());
    }
}
