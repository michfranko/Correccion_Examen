
package ec.edu.ups.edu.main;

import Constructor.Controlador;
import Dao.CarritoDAO;
import Dao.ClienteDAO;
import Dao.ProductoDAO;
import IDao.CarritoDAOImpl;
import IDao.ClienteDAOImpl;
import IDao.ProductoDAOImpl;
import java.util.Scanner;

public class Main {
    private static ClienteDAO clienteDAO = new ClienteDAOImpl();
    private static ProductoDAO productoDAO = new ProductoDAOImpl();
    private static CarritoDAO carritoDAO = new CarritoDAOImpl();
    private static Controlador controlador = new Controlador();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    controlador.agregarCliente(scanner);
                    break;
                case 2:
                    controlador.eliminarCliente(scanner);
                    break;
                case 3:
                    controlador.listarClientes();
                    break;
                case 4:
                    controlador.agregarProducto(scanner);
                    break;
                case 5:
                    controlador.eliminarProducto(scanner);
                    break;
                case 6:
                    controlador.listarProductos();
                    break;
                case 7:
                    controlador.agregarAlCarrito(scanner);
                    break;
                case 8:
                    controlador.eliminarDelCarrito(scanner);
                    break;
                case 9:
                    controlador.listarProductosDelCarrito(scanner);
                    break;
                case 10:
                    controlador.finalizarCompra(scanner);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Eliminar cliente");
        System.out.println("3. Listar clientes");
        System.out.println("4. Agregar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Listar productos");
        System.out.println("7. Agregar producto al carrito");
        System.out.println("8. Eliminar producto del carrito");
        System.out.println("9. Listar productos del carrito");
        System.out.println("10. Finalizar compra");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
