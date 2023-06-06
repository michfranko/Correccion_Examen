
package Dao;

import Modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    void eliminarCliente(int cedula);
    Cliente obtenerCliente(int cedula);
    List<Cliente> obtenerTodosLosClientes();
    void actualizarCliente(Cliente cliente);
}

