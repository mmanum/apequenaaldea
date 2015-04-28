/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao.impl;

import com.xaduin.invoduin.persistence.dao.CompaniesDAO;
import com.xaduin.invoduin.persistence.domain.Companies;

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
public class CompaniesDAOImpl implements CompaniesDAO {    

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
    public List<Companies> query() {
        String sentence = "from Companies";

        Query query = session.createQuery(sentence);
        List<Companies> list = query.list();

        return list;
    }

    @Override
    public String insertUpdate(Companies company) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.saveOrUpdate(company);
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
            Companies customer =
                    (Companies) session.get(
                    Companies.class, idCustomer);
            session.delete(customer);
            tx.commit();

        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }

        return result;
    }

    @Override
    public Companies get(Integer idrestaurante) {
        Companies customer = 
                (Companies) session.get(Companies.class, idrestaurante);
        return customer;
    }
    
}
