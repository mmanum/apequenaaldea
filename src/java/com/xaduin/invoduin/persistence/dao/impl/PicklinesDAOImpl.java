/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao.impl;

import com.xaduin.invoduin.persistence.dao.PicklinesDAO;
import com.xaduin.invoduin.persistence.domain.Picklines;

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
public class PicklinesDAOImpl implements PicklinesDAO {    

    private Session session;
    private Transaction tx;

    // IoC
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    // ---

    @Override
    public List<Picklines> query() {
        String sentence = "from pickings";

        Query query = session.createQuery(sentence);
        List<Picklines> list = query.list();

        return list;
    }

    @Override
    public String insertUpdate(Picklines picklines) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.saveOrUpdate(picklines);
            tx.commit();

        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }

        return result;
    }

    @Override
    public String delete(Integer idCustomer) {
        String result = null;

        tx = session.beginTransaction();
        try {
            Picklines customer =
                    (Picklines) session.get(
                    Picklines.class, idCustomer);
            session.delete(customer);
            tx.commit();

        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }

        return result;
    }

    @Override
    public Picklines get(Integer idrestaurante) {
        Picklines picklines = 
                (Picklines) session.get(Picklines.class, idrestaurante);
        return picklines;
    }
    
}
