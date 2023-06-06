
package Modelo;

import java.util.Date;
import java.util.List;

public class Carrito {
    private Date fecha;
    private double subtotal;
    private double iva;
    private double total;
    private Cliente cliente;
    private List<Producto> productos;

    public Carrito(Date fecha, double subtotal, double iva, double total, Cliente cliente, List<Producto> productos) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.cliente = cliente;
        this.productos = productos;
    }
    

    public Carrito() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

  
}

