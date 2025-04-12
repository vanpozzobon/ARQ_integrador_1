package main.java.org.example.ConcreteDaos;

import main.java.org.example.DAO.interfaces.ProductoDAO;
import main.java.org.example.DTO.ProductoDTO;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Producto;

import java.sql.*;
import java.util.List;

public class ProductoMySQLDAO implements ProductoDAO {
    private Connection conexion;

    public ProductoMySQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Producto> getAll() {
        return List.of();
    }

    @Override
    public Producto getProductoId(int id) {
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        PreparedStatement ps = null;
        Producto producto = null;

        try {
            ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto(rs.getInt("idProducto"), rs.getString("nombre"), rs.getFloat("valor"));
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
        return producto;
    }

    @Override
    public int getValor(int id) {
        return 0;
    }

    @Override
    public void save(Producto producto) {
        String sql = "INSERT INTO producto (nombre, valor) VALUES (?,?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getValor());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                producto.setIdProducto(idGenerado);
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
    public Producto update(Producto producto) {
        return null;
    }

    @Override
    public boolean delete(Producto producto) {
        return false;
    }

    public ProductoDTO get_producto_mayor_recaudacion() {
        String sql = "SELECT p.idProducto, p.nombre, p.valor, SUM(fp.cantidad * p.valor) AS total_recaudado, SUM(fp.cantidad) AS cantidad_vendida\n" +
                     "FROM factura_producto fp\n" +
                     "JOIN producto p ON fp.idProducto = p.idProducto\n" +
                     "GROUP BY p.idProducto, p.nombre\n" +
                     "ORDER BY total_recaudado DESC\n" +
                     "LIMIT 1;\n";
        PreparedStatement ps = null;
        ProductoDTO producto = null;
        try {
            ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new ProductoDTO(rs.getString("nombre"), rs.getFloat("valor"), rs.getInt("cantidad_vendida"));
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
            return producto;
            
        }

    }
}
