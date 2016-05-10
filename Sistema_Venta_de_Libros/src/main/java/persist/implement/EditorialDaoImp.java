package persist.implement;

import model.Editorial;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.EditorialDao;

/**
 * Created by root on 03/05/16.
 */
import java.util.List;


@Repository("editorialDao")
public class EditorialDaoImp implements EditorialDao {
    private static Session session;
    private SessionFactory  sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




    public void iniciarSession(){
        session=sessionFactory.getCurrentSession();
    }


    @Override
    @Transactional(readOnly = true)
    public Editorial findById(String s) {
        this.iniciarSession();
        return (Editorial) session.load(Editorial.class, Integer.parseInt(s));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Editorial> findAll() {
        this.iniciarSession();
        Criteria criteria =session.createCriteria(Editorial.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public Editorial makePersistent(Editorial entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return entity;
    }
}
