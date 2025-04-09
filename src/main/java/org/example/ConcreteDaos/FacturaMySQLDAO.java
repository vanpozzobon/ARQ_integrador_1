package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.FacturaDAO;
import main.java.org.example.entities.Factura;

import java.util.List;

public class FacturaMySQLDAO implements FacturaDAO {

    @Override
    public List<Factura> getAll() {
        return List.of();
    }

    @Override
    public Factura getFacturaId(int IdFactura) {
        return null;
    }

    @Override
    public Factura save(Factura Factura) {
        return null;
    }

    @Override
    public Factura update(Factura Factura) {
        return null;
    }

    @Override
    public boolean delete(Factura Factura) {
        return false;
    }

    @Override
    public List<Factura> getAllByIdCliente(int IdCliente) {
        return List.of();
    }
}
