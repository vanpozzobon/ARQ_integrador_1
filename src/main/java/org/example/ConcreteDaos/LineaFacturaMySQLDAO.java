package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.LineaFactDAO;
import main.java.org.example.entities.LineaFactura;

import java.util.List;

public class LineaFacturaMySQLDAO implements LineaFactDAO {
    @Override
    public List<LineaFactura> getAllByProducto(int idProducto) {
        return List.of();
    }

    @Override
    public List<LineaFactura> getALLByIDFactura(int idFactura) {
        return List.of();
    }

    @Override
    public LineaFactura getByIdFactura(int idFactura) {
        return null;
    }

    @Override
    public LineaFactura save(LineaFactura lineaFactura) {
        return null;
    }

    @Override
    public LineaFactura update(LineaFactura lineaFactura) {
        return null;
    }

    @Override
    public boolean delete(LineaFactura lineaFactura) {
        return false;
    }
}
