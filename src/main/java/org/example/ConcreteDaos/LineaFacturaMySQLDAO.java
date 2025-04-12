package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.LineaFactDAO;
import main.java.org.example.entities.LineaFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LineaFacturaMySQLDAO implements LineaFactDAO {
    private Connection conexion;

    public LineaFacturaMySQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

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
    public void save(LineaFactura lineaFactura) {

        String sql = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, lineaFactura.getFactura().getIdFactura());
            ps.setInt(2, lineaFactura.getProducto().getIdProducto());
            ps.setInt(3, lineaFactura.getCantidad());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                this.conexion.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
