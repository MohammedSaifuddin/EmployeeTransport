package org.etas.springmvc.dao;

import java.util.List;

import org.etas.springmvc.bean.Cab;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CabDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<Cab> getAllCabs() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cab> cabList = session.createQuery("from Cab").list();
        return cabList;
    }

    public Cab getCab(int cabId) {
        Session session = this.sessionFactory.getCurrentSession();
        Cab cab = (Cab) session.load(Cab.class, new Integer(cabId));
        return cab;
    }

    public Cab addCab(Cab cab) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cab);
        return cab;
    }

    public void updateCab(Cab cab) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cab);
    }

    public void deleteCab(int cabId) {
        Session session = this.sessionFactory.getCurrentSession();
        Cab p = (Cab) session.load(Cab.class, new Integer(cabId));
        if (null != p) {
            session.delete(p);
        }
    }

    public void setCabStatusToAvailable(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query qry = session.createQuery(" update Cab set cabStatus = 1 where id= " + id);
        qry.executeUpdate();
    }

    public void setCabStatusToUnavailable(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query qry = session.createQuery(" update Cab set cabStatus = 0 where id= " + id);
        qry.executeUpdate();
    }

}
