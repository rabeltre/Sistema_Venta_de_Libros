package controller.compra;

import model.Compra;
import model.Producto;
import service.CompraService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 08/05/16.
 */
@ManagedBean
@ViewScoped
public class UpdateOrSaveCompraBean implements Serializable{
@ManagedProperty(value = "#{compraService}")
    private CompraService compraService;

private Compra compra;
    private Producto producto;
    private String id;
    private Date fechaActual;

    private void iniciarFecha(){
        fechaActual = new Date();
        this.compra.setFecha(fechaActual);

    }


    public void init (){

        if (this.getId()!=null){
            this.producto = compraService.findByIdProducto(this.getId());
            this.compra = new Compra();
            this.iniciarFecha();
        }else{


        }
    }
    public String onPersist(){

        this.compra.setProducto(this.producto);
        this.compraService.makePersistent(this.compra);
        return "/View/Producto/viewProducto.xhtml?faces-redirect=true";

    }


    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setCompraService(CompraService compraService) {
        this.compraService = compraService;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
}
