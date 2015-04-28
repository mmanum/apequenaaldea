/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.logical.service.impl;

import com.xaduin.invoduin.logical.service.SalesService;
import com.xaduin.invoduin.logical.service.resource.exception.IncompatiblePrice;
import com.xaduin.invoduin.persistence.dao.SalesDAO;
import com.xaduin.invoduin.persistence.domain.Invoices;
import com.xaduin.invoduin.persistence.domain.Pickings;
import com.xaduin.invoduin.persistence.domain.Picklines;

import java.util.List;
import java.util.ArrayList;

//import org.hibernate.mapping.Map;
import java.util.Map;
import java.util.HashMap;

import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author manu
 */
@Service("salesServiceImpl")
public class SalesServiceImpl implements SalesService {
    
    // IoC
    @Autowired    
    @Qualifier("salesDAOImpl")
    private SalesDAO salesDAO; 
    
    
    public void setSalesDAO(SalesDAO salesDAOImpl) {
        this.salesDAO = salesDAOImpl;
    }
    
    
    
    /******************
    ***** Methods *****    
    *******************/
    /*
    @Override
    public Map mergePicklines(Invoices invoice) throws IncompatiblePrice {
        
        HashMap picklines = new HashMap<Integer, Picklines>();
        
        for( Pickings pick : (Set<Pickings>)invoice.getPickingses() ) {            
            for( Picklines pickline : (Set<Picklines>)pick.getPicklineses() ) {
                
                if( picklines.isEmpty() 
                        || !picklines.containsKey(pickline.getIdpicklines()) ) {
                    picklines.put(pickline.getIdpicklines(), pickline);
                }else {
                    Picklines tmpPickline = (Picklines)picklines.get(pickline.getIdpicklines());
                    if(tmpPickline.getPrice() == pickline.getPrice())
                        tmpPickline.setAmount(tmpPickline.getAmount() + pickline.getAmount());
                    else
                        throw new IncompatiblePrice();
                }
            }     
        }        
        return picklines;
    }
    */
    
    /*******************************
    ***** Hibernate Operations *****    
    ********************************/
    /*
    @Override
    public List<Invoices> query() {
        return invoicesDAO.query();
    }
    
    @Override
    public Invoices get(Integer idInvoice) {
        Invoices invo1 =  invoicesDAO.get(new Integer(1));
        //Invoices invo0 =  invoicesDAO.get2(new Integer(1));
        return invo1;
    }
    */
    
/*
    @Override
    public String insertar(Categorias categoria) {
        return categoriasDAO.insert(categoria);
    }    
    
    @Override
    public Categorias get(String ids) {
        return categoriasDAO.get(Integer.valueOf(ids));
    }

    @Override
    public String update(Categorias restaurante) {
        return categoriasDAO.update(restaurante);        
    }

    @Override
    public String delete(String ids) {        
        return categoriasDAO.delete(ids);        
    }
    
    */
}
