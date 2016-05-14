package service;


import model.Compra;
import model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.CompraDao;
import persist.Interface.ProductoDao;


import java.util.Date;
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

    public List<Object[]> findOnlyNameAndIdOfProduct(){
        return productoDao.findOnlyNameAndIdOfProduct();
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


    public List<Object> findCompras(String valor){
        return compraDao.findCompras(valor);
    }

    public List<Object> findComprasByIdProductoAndDate(Integer idProducto, Date fechaInicio, Date fechaFinal) {
        return compraDao.findComprasByIdProductoAndDate(idProducto, fechaInicio, fechaFinal);
    }
}
