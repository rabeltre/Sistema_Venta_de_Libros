package model;
// Generated May 19, 2016 12:58:55 AM by Hibernate Tools 4.3.1



/**
 * Nocontrato generated by hbm2java
 */
public class Nocontrato  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private int numero;

    public Nocontrato() {
    }

    public Nocontrato(Cliente cliente, int numero) {
       this.cliente = cliente;
       this.numero = numero;
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
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }




}

