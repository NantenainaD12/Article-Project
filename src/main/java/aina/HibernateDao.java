package aina;

import com.aina.spring_mvc.model.Article_Event;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

//Hibernate 3.0
public class HibernateDao {

    private SessionFactory sessionFactory;

    public <T> T create(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public <T> T findById(Class<T> clazz,Serializable id){
        Session session = sessionFactory.openSession();
        T entity = (T) session.get(clazz, id);
        session.close();
        return entity;
    }

    public <T> List<T> findAll(Class<T> tClass){
        Session session = sessionFactory.openSession();
        List<T> results = session.createCriteria(tClass).list();
        session.close();
        return results;
    }

    public <T> List<T> findWhere(T entity){
        System.out.println("ggg");
        Session session = sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass()).add(example).list();
        session.close();
        return results;
    }
    public <T> List<T> findWhere(Article_Event entity){
        System.out.println("TAYYY");
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(entity.getClass());
        if (!entity.getTitre().isEmpty()){
            criteria.add(Restrictions.like("titre", "%"+entity.getTitre()+"%"));
        }  if (!entity.getAbout().isEmpty()){
            criteria.add(Restrictions.like("about", "%"+entity.getAbout()+"%"));
        }
        List<T> results = criteria.list();
        session.close();
        return results;
    }

    public <T> List<T> paginateWhere (T entity, int offset, int size){
        Session session = sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass())
                .add(example)
                .setFirstResult(offset)
                .setMaxResults(offset+size).list();
        session.close();
        System.out.println("ATYYYY" +results.get(0).toString());
        return results;
    }
    public <T> List<T> paginateWhere (T entity){
        Session session = sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass())
                .add(example).list();
        session.close();
        //System.out.println("ATYYYY" +results.get(0).toString());
        return results;
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size){
        System.out.println("setMaxResults "+(offset+size));
        Session session = sessionFactory.openSession();
        List<T> results = session.createCriteria(clazz)
                            .setFirstResult(offset)
                            .setMaxResults(size).list();
        session.close();
        return results;
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size, String orderBy, boolean orderAsc){
        Session session = sessionFactory.openSession();
        Order order = (orderAsc) ? Order.asc(orderBy) : Order.desc(orderBy);
        List<T> results = session.createCriteria(clazz)
                .addOrder(order)
                .setFirstResult(offset)
                .setMaxResults(offset+size) .list();
        session.close();
        return results;
//        List<Employee> employees = session.createCriteria(Employee.class)
//                .add(Restrictions.like("name", "%ko"))
//                .add(Restrictions.eq("post", "koto"))
//                .list();

    }

    public void deleteById(Class tClass, Serializable id){
        delete(findById(tClass, id));
    }

    public void delete(Object entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public <T> T update(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return entity;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
