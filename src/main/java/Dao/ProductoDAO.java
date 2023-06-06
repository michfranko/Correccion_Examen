
package Dao;

import Modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    void agregarProducto(Producto producto);
    void eliminarProducto(int codigo);
    Producto obtenerProducto(int codigo);
    List<Producto> obtenerTodosLosProductos();
    void actualizarProducto(Producto producto);
}
