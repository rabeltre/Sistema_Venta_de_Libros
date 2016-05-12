package persist.Interface;

import javafx.beans.binding.ObjectExpression;
import model.Producto;

import java.util.List;

/**
 * Created by root on 03/05/16.
 */
public interface ProductoDao extends GenericDao<Producto,String> {
public List<Object> findAllWithEditorialName();
    public List<Object>findByName(String parametro);
    public List<Object[]>findOnlyNameAndIdOfProduct();
}
