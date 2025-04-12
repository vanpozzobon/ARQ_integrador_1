package main.java.org.example.DAO.interfaces;

import main.java.org.example.entities.LineaFactura;

import java.sql.ClientInfoStatus;
import java.util.List;

public interface LineaFactDAO {
    //NO DEBERIA SER FACTURA_PRODUCTO?
    List<LineaFactura> getAllByProducto(int idProducto);

    List<LineaFactura> getALLByIDFactura(int idFactura);

    LineaFactura getByIdFactura(int idFactura);

    void save(LineaFactura lineaFactura);

    LineaFactura update(LineaFactura lineaFactura);

    boolean delete(LineaFactura lineaFactura);


}
