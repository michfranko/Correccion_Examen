
package IDao;

import Dao.CarritoDAO;
import Modelo.Carrito;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class CarritoDAOImpl implements CarritoDAO {
    private List<Carrito> carritos;

    public CarritoDAOImpl() {
        carritos = new ArrayList<>();
    }

    @Override
    public void agregarAlCarrito(Carrito carrito, Producto producto) {
        carrito.getProductos().add(producto);
    }

    @Override
    public void eliminarDelCarrito(Carrito carrito, Producto producto) {
        carrito.getProductos().remove(producto);
    }

    @Override
    public List<Producto> obtenerProductosDelCarrito(Carrito carrito) {
        return carrito.getProductos();
    }

    @Override
    public void finalizarCompra(Carrito carrito) {
        carritos.add(carrito);
    }
}

