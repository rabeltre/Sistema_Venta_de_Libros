package service;

import model.Editorial;
import model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.EditorialDao;
import persist.Interface.ProductoDao;

import java.util.List;

/**
 * Created by root on 03/05/16.
 */
@Service("productoService")
public class ProductoService {
    @Autowired
    private ProductoDao productoDao;
    @Autowired
    private EditorialDao editorialDao;

    public List<Editorial> findByAllEditorial(){
        return editorialDao.findAll();
    }


    public Producto findById(String s) {
        return productoDao.findById(s);
    }
    public List<Object> findByName(String parametro) {
        return productoDao.findByName(parametro);
    }

    public List<Producto> findAll() {
        return productoDao.findAll();
    }


    public Producto makePersistent(Producto entity) {
        return productoDao.makePersistent(entity);
    }


    public List<Object> findAllWithEditorialName() {
        return productoDao.findAllWithEditorialName();
    }

    public void eliminarProducto(Integer idProducto){
        productoDao.eliminarProducto(idProducto);

    }
}
