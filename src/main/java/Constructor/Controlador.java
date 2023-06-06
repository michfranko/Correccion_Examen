/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constructor;

import Dao.CarritoDAO;
import Dao.ClienteDAO;
import Dao.ProductoDAO;
import IDao.CarritoDAOImpl;
import IDao.ClienteDAOImpl;
import IDao.ProductoDAOImpl;
import Modelo.Carrito;
import Modelo.Cliente;
import Modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    private ClienteDAO clienteDAO = new ClienteDAOImpl();
    private ProductoDAO productoDAO = new ProductoDAOImpl();
    private CarritoDAO carritoDAO = new CarritoDAOImpl();

    public void agregarCliente(Scanner scanner) {
        System.out.println("===== AGREGAR CLIENTE =====");
        System.out.print("Ingrese la cédula del cliente: ");
        int cedula = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese los nombres del cliente: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese los apellidos del cliente: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(cedula, nombres, apellidos, direccion, telefono);
        clienteDAO.agregarCliente(cliente);
        System.out.println("Cliente agregado correctamente.");
    }

    public void eliminarCliente(Scanner scanner) {
        System.out.println("===== ELIMINAR CLIENTE =====");
        System.out.print("Ingrese la cédula del cliente a eliminar: ");
        int cedula = scanner.nextInt();
        clienteDAO.eliminarCliente(cedula);
        System.out.println("Cliente eliminado correctamente.");
    }

    public void listarClientes() {
        System.out.println("===== LISTA DE CLIENTES =====");
        for (Cliente cliente : clienteDAO.obtenerTodosLosClientes()) {
            System.out.println(cliente.toString());
        }
    }

    public void agregarProducto(Scanner scanner) {
        System.out.println("===== AGREGAR PRODUCTO =====");
        System.out.print("Ingrese el código del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(codigo, nombre, descripcion, precio);
        productoDAO.agregarProducto(producto);
        System.out.println("Producto agregado correctamente.");
    }

    public void eliminarProducto(Scanner scanner) {
        System.out.println("===== ELIMINAR PRODUCTO =====");
        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigo = scanner.nextInt();
        productoDAO.eliminarProducto(codigo);
        System.out.println("Producto eliminado correctamente.");
    }

    public void listarProductos() {
        System.out.println("===== LISTA DE PRODUCTOS =====");
        for (Producto producto : productoDAO.obtenerTodosLosProductos()) {
            System.out.println(producto.toString());
        }
    }

    public void agregarAlCarrito(Scanner scanner) {
        System.out.println("===== AGREGAR PRODUCTO AL CARRITO =====");
        System.out.print("Ingrese la cédula del cliente: ");
        int cedula = scanner.nextInt();
        Cliente cliente = clienteDAO.obtenerCliente(cedula);
        if (cliente == null) {
            System.out.println("No existe un cliente con esa cédula.");
            return;
        }

        System.out.print("Ingrese el código del producto a agregar: ");
        int codigo = scanner.nextInt();
        Producto producto = productoDAO.obtenerProducto(codigo);
        if (producto == null) {
            System.out.println("No existe un producto con ese código.");
            return;
        }

        Carrito carrito = new Carrito();
        carrito.setCliente(cliente);
        carritoDAO.agregarAlCarrito(carrito, producto);
        System.out.println("Producto agregado al carrito correctamente.");
    }

    public void eliminarDelCarrito(Scanner scanner) {
        System.out.println("===== ELIMINAR PRODUCTO DEL CARRITO =====");
        System.out.print("Ingrese la cédula del cliente: ");
        int cedula = scanner.nextInt();
        Cliente cliente = clienteDAO.obtenerCliente(cedula);
        if (cliente == null) {
            System.out.println("No existe un cliente con esa cédula.");
            return;
        }

        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigo = scanner.nextInt();
        Producto producto = productoDAO.obtenerProducto(codigo);
        if (producto == null) {
            System.out.println("No existe un producto con ese código.");
            return;
        }

        Carrito carrito = new Carrito();
        carrito.setCliente(cliente);
        carritoDAO.eliminarDelCarrito(carrito, producto);
        System.out.println("Producto eliminado del carrito correctamente.");
    }

    public void listarProductosDelCarrito(Scanner scanner) {
        System.out.println("===== PRODUCTOS DEL CARRITO =====");
        System.out.print("Ingrese la cédula del cliente: ");
        int cedula = scanner.nextInt();
        Cliente cliente = clienteDAO.obtenerCliente(cedula);
        if (cliente == null) {
            System.out.println("No existe un cliente con esa cédula.");
            return;
        }

        Carrito carrito = new Carrito();
        carrito.setCliente(cliente);
        List<Producto> productos = carritoDAO.obtenerProductosDelCarrito(carrito);
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }

    public void finalizarCompra(Scanner scanner) {
        System.out.println("===== FINALIZAR COMPRA =====");
        System.out.print("Ingrese la cédula del cliente: ");
        int cedula = scanner.nextInt();
        Cliente cliente = clienteDAO.obtenerCliente(cedula);
        if (cliente == null) {
            System.out.println("No existe un cliente con esa cédula.");
            return;
        }

        Carrito carrito = new Carrito();
        carrito.setCliente(cliente);
        carritoDAO.finalizarCompra(carrito);
        System.out.println("Compra finalizada correctamente.");
    }
}
