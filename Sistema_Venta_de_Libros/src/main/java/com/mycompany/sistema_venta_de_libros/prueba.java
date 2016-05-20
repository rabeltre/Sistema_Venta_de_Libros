package com.mycompany.sistema_venta_de_libros;

import liquibase.exception.DatabaseException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 08/05/16.
 */
@ManagedBean
@ViewScoped
public class prueba implements Serializable{
    String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public  void mostrar(){

        System.out.println(mensaje);
    }
    @PostConstruct
    public void   iniciar(){
        this.mensaje = "829-663-1954";
    }

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
