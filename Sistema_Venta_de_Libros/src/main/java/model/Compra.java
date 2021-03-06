package model;
// Generated May 8, 2016 2:29:43 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Compra generated by hbm2java
 */
public class Compra  implements java.io.Serializable {


     private Integer idCompra;
     private Producto producto;
     private int cantidad;
     private Date fecha;

    public Compra() {
    }

	
    public Compra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public Compra(Producto producto, int cantidad, Date fecha) {
       this.producto = producto;
       this.cantidad = cantidad;
       this.fecha = fecha;
    }
   
    public Integer getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


