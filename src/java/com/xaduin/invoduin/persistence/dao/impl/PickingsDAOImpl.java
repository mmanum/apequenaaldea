/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao.impl;

import com.xaduin.invoduin.persistence.dao.PickingsDAO;
import com.xaduin.invoduin.persistence.domain.Pickings;

import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 *
 * @author manu
 */

@Repository
public class PickingsDAOImpl implements PickingsDAO {    

    private Session session;
    private Transaction tx;

    // IoC
    @Autowired
    @Qualifier("sessionFactoryImpl")
    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }
    // ---

    @Override    
    public List<Pickings> query() {
        
        String sentence = "from Pickings";
        Query query = session.createQuery(sentence);
        List<Pickings> list = query.list();
        return list;
    }
    
    @Override
    public List<Pickings> queryToInvoice() {
        return null;
    }
    
    @Override    
    public List<Pickings> queryToInvoice(Integer idcompanies) {
        String sentence = "from Pickings where invoiced = 0 AND customers_idcustomers = " + idcompanies;
        Query query = session.createQuery(sentence);
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
    }
    
}
