/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao.impl;

import com.xaduin.invoduin.persistence.dao.SalesDAO;

import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
/**
 *
 * @author manu
 */

@Repository
public class SalesDAOImpl implements SalesDAO {    

    private Session session;
    private Transaction tx;

    // IoC
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    // ---
/*
    @Override
    public List<Pickings> query() {
        String s = "select "
                + "r.idrestaurante,"
                + "c.categoria,"
                + "r.restaurante,"
                + "r.direccion,"
                + "r.distrito "
                + "from Categorias c inner join c.restauranteses r";

        Query query = session.createQuery(s);
        List<Pickings> list = query.list();

        return list;
    }

    @Override
    public String insertUpdate(Pickings pick) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.saveOrUpdate(pick);
            tx.commit();

        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }

        return result;
    }

    @Override
    public String delete(Integer idPick) {
        String result = null;

        tx = session.beginTransaction();
        try {
            Pickings pick =
                    (Pickings) session.get(
                    Pickings.class, idPick);
            session.delete(pick);
            tx.commit();

        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }

        return result;
    }

    @Override
    public Pickings get(Integer idPick) {
        Pickings pick = 
                (Pickings) session.get(Pickings.class, idPick);
        return pick;
    }*/
    
}
