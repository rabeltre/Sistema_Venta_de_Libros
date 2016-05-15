package com.mycompany.sistema_venta_de_libros;

import liquibase.exception.DatabaseException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 08/05/16.
 */
@ManagedBean
@ViewScoped
public class prueba {

    public static void main (String [ ] args) {
        Date data = new Date();
        Calendar calendar = Calendar.getInstance();
        int  dia = calendar.MONTH;

        System.out.println (data);

    } //

    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }


}
