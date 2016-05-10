package model;
// Generated May 4, 2016 1:24:33 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Editorial generated by hbm2java
 */
public class Editorial  implements java.io.Serializable {


     private Integer idEditorial;
     private String nombre;
     private byte valor;
     private Set productos = new HashSet(0);

    public Editorial() {
    }

    public Editorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    @Override
    public String toString() {
        return idEditorial + " - " + nombre;
    }

    public Editorial(String nombre, byte valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    public Editorial(String nombre, byte valor, Set productos) {
       this.nombre = nombre;
       this.valor = valor;
       this.productos = productos;
    }
   
    public Integer getIdEditorial() {
        return this.idEditorial;
    }
    
    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public byte getValor() {
        return this.valor;
    }
    
    public void setValor(byte valor) {
        this.valor = valor;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


