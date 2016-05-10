package service;


import model.Compra;
import model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.CompraDao;
import persist.Interface.ProductoDao;


import java.util.List;

/**
 * Created by root on 03/05/16.
 */
@Service("compraService")
public class CompraService {
   @Autowired
    private CompraDao compraDao;

    @Autowired
    private ProductoDao productoDao;

    public Producto findByIdProducto(String idproducto){
        return productoDao.findById(idproducto);
    }


    public Compra findById(String s) {
        return compraDao.findById(s);
    }


    public List<Compra> findAll() {
        return compraDao.findAll();
    }


    public Compra makePersistent(Compra entity) {
        return compraDao.makePersistent(entity);
    }
}
