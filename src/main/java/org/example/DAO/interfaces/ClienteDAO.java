package main.java.org.example.DAO.interfaces;

import main.java.org.example.DTO.ClienteDTO;
import main.java.org.example.entities.Cliente;

import java.sql.Connection;
import java.util.List;

public interface ClienteDAO {
    Connection connection = null;

    List<Cliente> getAll();

    Cliente get(int id);

    void save(Cliente cliente);

    Cliente update(Cliente cliente);

    boolean delete(int id);

    public List<ClienteDTO> get_lista_clientes_mayor_facturacion();
}