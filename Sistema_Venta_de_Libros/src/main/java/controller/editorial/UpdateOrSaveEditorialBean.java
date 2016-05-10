package controller.editorial;

import model.Editorial;
import service.EditorialService;

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
public class UpdateOrSaveEditorialBean implements Serializable {
    @ManagedProperty(value = "#{editorialService}")
    private EditorialService editorialService;
    private Editorial editorial;
    private String id;
    private String option;

    public void init() {
        if (this.getId() != null) {
            this.editorial = editorialService.findById(this.getId());
            this.setOption("Editar editorial");
        } else {
            editorial = new Editorial();
            this.setOption("Nueva Editorial");
        }

    }

    public String onPersist() {
        this.editorialService.makePersistent(this.editorial);
        return "viewEditorial.xhtml?faces-redirect=true";
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
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

    public void setEditorialService(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

}
