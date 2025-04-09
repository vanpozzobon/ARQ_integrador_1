package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.ProductoDAO;
import main.java.org.example.entities.Producto;

import java.util.List;

public class ProductoMySQLDAO implements ProductoDAO {

    @Override
    public List<Producto> getAll() {
        return List.of();
    }

    @Override
    public Producto getProductoId(int id) {
        return null;
    }

    @Override
    public int getValor(int id) {
        return 0;
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

    @Override
    public Producto update(Producto producto) {
        return null;
    }

    @Override
    public boolean delete(Producto producto) {
        return false;
    }
}
