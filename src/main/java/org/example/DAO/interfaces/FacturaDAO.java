package main.java.org.example.DAO.interfaces;

import main.java.org.example.entities.Factura;

import java.util.List;

public interface FacturaDAO {
    List<Factura> getAll();

    Factura getFacturaId(int idFactura);

    void save(Factura factura);

    Factura update(Factura Factura);

    boolean delete(Factura Factura);

    List<Factura> getAllByIdCliente(int IdCliente);

}
