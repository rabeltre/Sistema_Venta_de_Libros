package model;
// Generated May 19, 2016 12:58:55 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Gastos generated by hbm2java
 */
public class Gastos  implements java.io.Serializable {


     private Integer idGastos;
     private CategoriaGastos categoriaGastos;
     private String descripcion;
     private Set gastosDetailses = new HashSet(0);

    public Gastos() {
    }

	
    public Gastos(CategoriaGastos categoriaGastos, String descripcion) {
        this.categoriaGastos = categoriaGastos;
        this.descripcion = descripcion;
    }
    public Gastos(CategoriaGastos categoriaGastos, String descripcion, Set gastosDetailses) {
       this.categoriaGastos = categoriaGastos;
       this.descripcion = descripcion;
       this.gastosDetailses = gastosDetailses;
    }
   
    public Integer getIdGastos() {
        return this.idGastos;
    }
    
    public void setIdGastos(Integer idGastos) {
        this.idGastos = idGastos;
    }
    public CategoriaGastos getCategoriaGastos() {
        return this.categoriaGastos;
    }
    
    public void setCategoriaGastos(CategoriaGastos categoriaGastos) {
        this.categoriaGastos = categoriaGastos;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getGastosDetailses() {
        return this.gastosDetailses;
    }
    
    public void setGastosDetailses(Set gastosDetailses) {
        this.gastosDetailses = gastosDetailses;
    }




}


