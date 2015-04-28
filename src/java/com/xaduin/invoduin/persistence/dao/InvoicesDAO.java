/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao;

import com.xaduin.invoduin.persistence.domain.Invoices;

import java.util.List;

/**
 *
 * @author manu
 */
public interface InvoicesDAO {
        
    public List<Invoices> query();
    
    public Invoices get(Integer idInvoice);
    
    //public Invoices get2(Integer idInvoice);

    public String insertUpdate(Invoices invoice);

    public String delete(Integer idinvoice);
    
    public String getNextInvoiceNumber();
    
}
