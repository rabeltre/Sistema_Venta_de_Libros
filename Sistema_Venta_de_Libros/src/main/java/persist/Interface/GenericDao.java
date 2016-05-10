package persist.Interface;

import java.io.Serializable;
import java.util.List;

/**
 * Created by estudiantes on 25/03/16.
 */
public interface GenericDao<T, ID extends Serializable> {
    T findById(ID id);
    List<T> findAll();
    T makePersistent(T entity);


}
