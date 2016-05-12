package controller.compra;

import service.CompraService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by root on 11/05/16.
 */
@ManagedBean
@ViewScoped
public class ViewCompraBean implements Serializable {
    @ManagedProperty(value = "#{compraService}")
    private CompraService compraService;



}
