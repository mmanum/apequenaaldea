/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao.impl;

import com.xaduin.invoduin.persistence.dao.InvoicesDAO;
import com.xaduin.invoduin.persistence.domain.Invoices;

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


@Repository("invoicesDAOImpl")
public class InvoicesDAOImpl implements InvoicesDAO {    

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
    public List<Invoices> query() {
        /* String sentence = 
                "SELECT "
                + "inv.idinvoice,"
                + "c.categoria,"
                + "r.restaurante,"
                + "r.direccion,"
                + "r.distrito "
                + "FROM picking pick INNER JOIN i.idinvoice invoices inv"; */

        String sentence = "from Invoices";
        Query query = session.createQuery(sentence);
        List<Invoices> list = query.list();
        return list;
    }

    
    @Override
    public Invoices get(Integer idinvoice) {
        Invoices invoice = 
                (Invoices) session.get(Invoices.class, idinvoice);
        return invoice;
    }    
    
    /*
    @Override
    public Invoices get2(Integer idinvoice) {        
        //Get Invoice with id
        Query  query = session.createQuery("from invoices where invoices.idinvoices= :id");
        query.setLong("id", 3);
        Invoices invoice = (Invoices) query.uniqueResult();
        return invoice;
    }*/
    
    @Override
    public String insertUpdate(Invoices customer) {
        String result = null;

        tx = session.beginTransaction();
        try {
            session.saveOrUpdate(customer);
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
            Invoices customer =
                    (Invoices) session.get(
                    Invoices.class, idCustomer);
            session.delete(customer);
            tx.commit();

        } catch (Exception e) {
            result = e.getMessage();
            tx.rollback();
        }

        return result;
    }

    
    @Override
    public String getNextInvoiceNumber() {
        /* String sentence = 
                "SELECT "
                + "inv.idinvoice,"
                + "c.categoria,"
                + "r.restaurante,"
                + "r.direccion,"
                + "r.distrito "
                + "FROM picking pick INNER JOIN i.idinvoice invoices inv"; */

        String sentence = "SELECT  MAX(SUBSTRING_INDEX(SUBSTRING(number, 2), '/', 1)) as max_year, "
                            + "MAX(SUBSTRING_INDEX(number, '/', -1)) as max_number"
                            + "FROM `pickings` WHERE"
                            + "number LIKE CONCAT ( 'A', "
                            + " (SELECT MAX(SUBSTRING_INDEX(SUBSTRING(number, 2), '/', 1)) FROM pickings),"
                            + "'/%' )";
        Query query = session.createQuery(sentence);
        List<Invoices> list = query.
        return list;
    }

}
