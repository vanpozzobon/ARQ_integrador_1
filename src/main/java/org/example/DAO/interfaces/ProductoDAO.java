package main.java.org.example.DAO.interfaces;

import main.java.org.example.entities.Producto;

import java.util.List;

public interface ProductoDAO {
    List<Producto> getAll();
    Producto getProductoId(int id);
    int getValor(int id);
    Producto save(Producto producto);
    Producto update(Producto producto);
    boolean delete(Producto producto);

}
