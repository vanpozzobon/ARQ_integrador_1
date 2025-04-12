package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.ClienteDAO;
import main.java.org.example.DAO.interfaces.FacturaDAO;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Factura;
import main.java.org.example.entities.Producto;

import java.sql.*;
import java.util.List;

public class FacturaMySQLDAO implements FacturaDAO {
    private Connection conexion;

    public FacturaMySQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Factura> getAll() {
        return List.of();
    }

    @Override
    public Factura getFacturaId(int idFactura) {

        String sql = "SELECT * FROM factura WHERE idFactura = ?";
        PreparedStatement ps = null;
        Factura factura = null;

        try {
            ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, idFactura);
            ResultSet rs = ps.executeQuery();
            ClienteDAO clientedao = new ClienteMySQLDAO(this.conexion);

            if (rs.next()) {
                Cliente cliente = clientedao.get(rs.getInt("idCliente"));
                factura = new Factura(rs.getInt("idFactura"), cliente);
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
        return factura;
    }

    @Override
    public void save(Factura factura) {
        String sql = "INSERT INTO factura (idCliente) VALUES (?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, factura.getCliente().getIdCliente());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                factura.setIdFactura(idGenerado);
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
