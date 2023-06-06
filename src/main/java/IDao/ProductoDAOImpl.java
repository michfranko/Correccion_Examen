
package IDao;

import Dao.ProductoDAO;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoDAOImpl implements ProductoDAO {
    private Map<Integer, Producto> productos;

    public ProductoDAOImpl() {
        productos = new HashMap<>();
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.put(producto.getCodigo(), producto);
    }

    @Override
    public void eliminarProducto(int codigo) {
        productos.remove(codigo);
    }

    @Override
    public Producto obtenerProducto(int codigo) {
        return productos.get(codigo);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public void actualizarProducto(Producto producto) {
        productos.put(producto.getCodigo(), producto);
    }
}
