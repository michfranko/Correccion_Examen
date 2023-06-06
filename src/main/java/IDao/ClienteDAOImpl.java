
package IDao;


import Dao.ClienteDAO;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteDAOImpl implements ClienteDAO {
    private Map<Integer, Cliente> clientes;

    public ClienteDAOImpl() {
        clientes = new HashMap<>();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getCedula(), cliente);
    }

    @Override
    public void eliminarCliente(int cedula) {
        clientes.remove(cedula);
    }

    @Override
    public Cliente obtenerCliente(int cedula) {
        return clientes.get(cedula);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clientes.put(cliente.getCedula(), cliente);
    }
}

