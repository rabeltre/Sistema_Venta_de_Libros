package model;
// Generated May 19, 2016 12:58:55 AM by Hibernate Tools 4.3.1



/**
 * Profesion generated by hbm2java
 */
public class Profesion  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private String descripcion;

    public Profesion() {
    }

    public Profesion(Cliente cliente, String descripcion) {
       this.cliente = cliente;
       this.descripcion = descripcion;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


