package controller.compra;

import model.Compra;
import model.Producto;
import service.CompraService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.IntegerConverter;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 11/05/16.
 */
@ManagedBean
@ViewScoped
public class ViewCompraBean implements Serializable {
    @ManagedProperty(value = "#{compraService}")
    private CompraService compraService;
    private List<Object> compras;
    private String fechaInicial;
    private String fechaFinal;
    private String idProductoAbuscar;
    private String sql;
    private Integer productoSeleccionado;
    private List<Object[]> productos;
    private List<SelectItem> listaDeProductos;



public void init (){
    this.llenarComboProducto();


}
    private void llenarComboProducto(){
        this.listaDeProductos = new ArrayList<SelectItem>();
        this.productos = compraService.findOnlyNameAndIdOfProduct();

        for (Object[] object: productos){
            listaDeProductos.add(new SelectItem( (Integer)object[0], (String) object[1]));
        }
        this.productos.clear();
    }

    public List<SelectItem> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(List<SelectItem> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    public List<Object[]> getProductos() {
        return productos;
    }

    public void setProductos(List<Object[]> productos) {
        this.productos = productos;
    }

    public List<Object> getCompras() {
        return compras;
    }

    public void setCompras(List<Object> compras) {
        this.compras = compras;
    }

    public void setCompraService(CompraService compraService) {
        this.compraService = compraService;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getIdProductoAbuscar() {
        return idProductoAbuscar;
    }

    public void setIdProductoAbuscar(String idProductoAbuscar) {
        this.idProductoAbuscar = idProductoAbuscar;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Integer getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Integer productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
}
