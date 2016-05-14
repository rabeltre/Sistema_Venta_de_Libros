package persist.Interface;

import model.Compra;

import java.util.Date;
import java.util.List;

/**
 * Created by root on 08/05/16.
 */
public interface CompraDao extends GenericDao<Compra,String>{
    public List<Object>findCompras(String valor);
    public List<Object> findComprasByIdProductoAndDate(Integer idProducto, Date fechaInicio, Date fechaFinal);
}
