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
public class ViewEditorialBean implements Serializable{
    @ManagedProperty(value = "#{editorialService}")
    private EditorialService editorialService;
private List<Editorial>editorials;

    public void init(){
        editorials = editorialService.findAll();
    }

    public List<Editorial> getEditorials() {
        return editorials;
    }

    public void setEditorials(List<Editorial> editorials) {
        this.editorials = editorials;
    }

    public void setEditorialService(EditorialService editorialService) {
        this.editorialService = editorialService;
    }
}
