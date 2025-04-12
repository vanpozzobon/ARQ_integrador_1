package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DTO.ClienteDTO;
import main.java.org.example.DTO.ProductoDTO;
import main.java.org.example.entities.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteMySQLDAO implements ClienteDAO {
    private Connection conexion;

    public ClienteMySQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Cliente> getAll() {
        return List.of();
    }

    @Override
    public Cliente get(int id) {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        PreparedStatement ps = null;
        Cliente cliente = null;

        try {
            ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {

            }
        }
        return cliente;
    }

    @Override
    public void save(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre,email) VALUES (?,?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                cliente.setIdCliente(idGenerado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null)
                    ps.close();
                this.conexion.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public List<ClienteDTO> get_lista_clientes_mayor_facturacion() {
        String sql = "SELECT c.idCliente, c.nombre, c.email, SUM(fp.cantidad * p.valor) AS total_facturado, SUM(fp.cantidad) AS cantidad_vendida\n" +
                     "FROM cliente c\n" +
                     "JOIN factura f ON c.idCliente = f.idCliente\n" +
                     "JOIN factura_producto fp ON f.idFactura = fp.idFactura\n" +
                     "JOIN  producto p ON fp.idProducto = p.idProducto\n" +
                     "GROUP BY c.idCliente, c.nombre, c.email\n" +
                     "ORDER BY total_facturado DESC;\n";

        PreparedStatement ps = null;
        List<ClienteDTO> clientes = new ArrayList<>();
        try {
            ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO(rs.getString("nombre"), rs.getString("email"), rs.getInt("cantidad_vendida"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return clientes;

        }
    }
}
