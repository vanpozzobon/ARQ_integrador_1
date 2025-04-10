package main.java.org.example.entities;

public class Factura {
    private int idFactura;
    private Cliente cliente;

    public Factura() {
    }
    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }
    public Factura(int idFactura, Cliente cliente) {
        this.idFactura = idFactura;
        this.cliente = cliente;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public int getIdFactura() {
        return idFactura;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }
    @Override
    public String toString() {
        return "Factura{" +
               "idFactura=" + idFactura +
               ", " + cliente.toString() +
               '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;
        Factura factura = (Factura) o;
        return this.getIdFactura() == factura.getIdFactura();
    }
}
