
package Dao;

import Modelo.Carrito;
import Modelo.Producto;
import java.util.List;

public interface CarritoDAO {
    void agregarAlCarrito(Carrito carrito, Producto producto);
    void eliminarDelCarrito(Carrito carrito, Producto producto);
    List<Producto> obtenerProductosDelCarrito(Carrito carrito);
    void finalizarCompra(Carrito carrito);
}
