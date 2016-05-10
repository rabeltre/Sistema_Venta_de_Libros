package controller.producto;

import service.ProductoService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by root on 03/05/16.
 */
@ManagedBean
@ViewScoped
public class ViewProductoBean implements Serializable {
    @ManagedProperty(value="#{productoService}")
    private ProductoService productoService;
    private List<Object> productos;
    private String parametro;

    public void init (){
        productos = productoService.findAllWithEditorialName();

    }
public void search(){
    productos = productoService.findByName(this.parametro);
}
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Object> getProductos() {
        return productos;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public void setProductos(List<Object> productos) {
        this.productos = productos;
    }
}
