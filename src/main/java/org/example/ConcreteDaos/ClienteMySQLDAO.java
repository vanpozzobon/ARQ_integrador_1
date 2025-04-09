package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.entities.Cliente;

import java.util.List;

public class ClienteMySQLDAO implements ClienteDAO {
    @Override
    public List<Cliente> getAll() {
        return List.of();
    }

    @Override
    public Cliente get(int id) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
