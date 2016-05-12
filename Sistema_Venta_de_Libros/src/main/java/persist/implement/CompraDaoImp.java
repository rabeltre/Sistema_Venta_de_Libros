package persist.implement;

import model.Compra;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.CompraDao;

import java.util.List;

/**
 * Created by root on 08/05/16.
 */
@Repository("compraDao")
public class CompraDaoImp implements CompraDao {
    private static Session session;
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    @Transactional(readOnly = true)
    public Compra findById(String s) {
        this.iniciarSession();
        return (Compra) session.load(Compra.class, Integer.parseInt(s));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Compra> findAll() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Compra.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public Compra makePersistent(Compra entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return entity;
    }


    public void iniciarSession(){
        session=sessionFactory.getCurrentSession();
    }

    @Override
    public List<Object> findCompras(String valor) {
        this.iniciarSession();
        Query query = session.createQuery(valor);
        query.setMaxResults(100);
        return query.list();
    }
}

