package persist.implement;

import model.Producto;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.ProductoDao;

import java.util.List;

/**
 * Created by root on 03/05/16.
 */
@Repository("productoDao")
public class ProductoDaoImp implements ProductoDao{
    private SessionFactory sessionFactory;
    private String sql;

    private static Session session;
@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void iniciarSession(){
        session =sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(String s) {
        this.iniciarSession();
        return (Producto) session.load(Producto.class, Integer.parseInt(s));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Producto.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public Producto makePersistent(Producto entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findAllWithEditorialName() {
        this.iniciarSession();
        this.sql="select p.idProducto, p.editorial.nombre, p.nombre, p.cantidad, p.precio, p.precioVenta from Producto p where p.estado.idEstado = 1 order by p.idProducto";
        Query query = session.createQuery(this.sql);
        query.setMaxResults(100);
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findByName(String parametro) {
        this.iniciarSession();
        this.sql="select p.idProducto, p.editorial.nombre, p.nombre, p.cantidad, p.precio, p.precioVenta from Producto p where p.estado.idEstado = 1 and p.nombre like :keyword order by p.idProducto";
        Query query = session.createQuery(this.sql);
        query.setParameter("keyword", "%" + parametro + "%");
        query.setMaxResults(100);
        return query.list();
    }

    @Override
    public List<Object[]> findOnlyNameAndIdOfProduct() {
        this.iniciarSession();
        this.sql="select p.idProducto, p.nombre from Producto p order by p.idProducto";
        Query query = session.createQuery(this.sql);
        return query.list();
    }

    public String getSql() {

        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
