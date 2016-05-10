package controller.producto;


import model.Editorial;
import model.Estado;
import model.Producto;
import service.ProductoService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 03/05/16.
 */
@ManagedBean
@ViewScoped
public class UpdateOrSaveProductoBean implements Serializable {
    @ManagedProperty(value = "#{productoService}")
    private ProductoService productoService;
    private Producto producto;
    private String id;
    private String option;
    private Estado estado;

    private Integer selectItemEditorial;

    private List<SelectItem> listaDeEditoritoriales;

    private List<Editorial> editorials;

    private Editorial editorial;

    public void init() {
        this.listaDeEditoritoriales = new ArrayList<SelectItem>();

        this.editorials = productoService.findByAllEditorial();

        for (Editorial editorial : editorials) {
            listaDeEditoritoriales.add(new SelectItem(editorial.getIdEditorial(), editorial.toString()));
        }
        this.editorials.clear();
        if (this.getId() != null) {

            producto = productoService.findById(this.getId());
            this.selectItemEditorial = this.producto.getEditorial().getIdEditorial();
            this.setOption("Editar Producto");
        } else {
            this.setOption("Nuevo Producto");
            this.producto = new Producto();
        }


    }

    public String onPersist() {
        estado = new Estado(1);
        this.editorial = new Editorial(this.selectItemEditorial);

        producto.setEstado(this.estado);
        producto.setEditorial(this.editorial);

        this.productoService.makePersistent(this.producto);
        return "viewProducto.xhtml?faces-redirect=true";
    }




    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getSelectItemEditorial() {
        return selectItemEditorial;
    }

    public void setSelectItemEditorial(Integer selectItemEditorial) {
        this.selectItemEditorial = selectItemEditorial;
    }

    public List<SelectItem> getListaDeEditoritoriales() {
        return listaDeEditoritoriales;
    }

    public void setListaDeEditoritoriales(List<SelectItem> listaDeEditoritoriales) {
        this.listaDeEditoritoriales = listaDeEditoritoriales;
    }

    public List<Editorial> getEditorials() {
        return editorials;
    }

    public void setEditorials(List<Editorial> editorials) {
        this.editorials = editorials;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
