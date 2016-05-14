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

import java.util.Date;
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

    public void iniciarSession(){
        session=sessionFactory.getCurrentSession();
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




    @Override
    public List<Object> findCompras(String valor) {
        this.iniciarSession();
        Query query = session.createQuery(valor);
        query.setMaxResults(100);
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findComprasByIdProductoAndDate(Integer idProducto, Date fechaInicio, Date fechaFinal) {
        this.iniciarSession();
        System.out.println(fechaInicio);
        String sql = "select c.producto.nombre, c.cantidad, c.producto.precio, c.fecha from Compra c ";
        sql = sql +  sqlValidator(idProducto);

        if (fechaFinal != null && fechaInicio!= null){
        sql = sql + sqlEntreFechas(idProducto);}

        Query query = session.createQuery(sql);
        if (idProducto !=0)
        query.setParameter("id", idProducto);

        if (fechaFinal != null && fechaInicio!= null)
        query.setParameter("fechaInicio",fechaInicio).setParameter("fechaFinal", fechaFinal);


        query.setMaxResults(100);
        return query.list();
    }



    private String sqlValidator(Integer valor){
        if (valor.equals(0)){
            return "";
        }else{
            return "where c.producto.idProducto=:id";
        }
    }

    private  String sqlEntreFechas(Integer valor){

        String cadena ="c.fecha between :fechaInicio and :fechaFinal";
        if (valor.equals(0)){
            cadena = " where " + cadena;

        }else {
            cadena = " and " + cadena;

        }

        return cadena;
    }


}

