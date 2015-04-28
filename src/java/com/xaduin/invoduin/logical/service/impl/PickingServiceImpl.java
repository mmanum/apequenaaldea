/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.logical.service.impl;

import com.xaduin.invoduin.logical.service.PickingService;
import com.xaduin.invoduin.logical.service.resource.exception.IncompatibleCustomer;
import com.xaduin.invoduin.logical.service.resource.exception.IncompatiblePrice;
import com.xaduin.invoduin.persistence.dao.PickingsDAO;
import com.xaduin.invoduin.persistence.dao.PicklinesDAO;
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
@Service("pickingServiceImpl")
public class PickingServiceImpl implements PickingService {
    
    // IoC
    @Autowired    
    @Qualifier("pickingsDAOImpl")
    private PickingsDAO pickingsDAO; 
    
    // IoC
    @Autowired    
    @Qualifier("picklinesDAOImpl")
    private PicklinesDAO picklinesDAO; 
    
    
    public void setPickingsDAO(PickingsDAO pickingsDAOImpl) {
        this.pickingsDAO = pickingsDAOImpl;
    }
    
    public void setPickLinesDAO(PickingsDAO invoiceDAOImpl) {
        this.pickingsDAO = invoiceDAOImpl;
    }
    
    
    /******************
    ***** Methods *****    
    *******************/
    
    @Override
    public Map mergePicks(Pickings pick) throws IncompatibleCustomer {
        
        HashMap picklines = new HashMap<Integer, Picklines>();
        /*
        for( Pickings currentPick : (Set<Pickings>)invoice.getPickingses() ) {            
            for( Picklines pickline : (Set<Picklines>)pick.getPicklineses() ) {
                
                if( picklines.isEmpty() 
                        || !picklines.containsKey(pickline.getIdpicklines()) ) {
                    picklines.put(pickline.getIdpicklines(), pickline);
                }else {
                    Picklines tmpPickline = (Picklines)picklines.get(pickline.getIdpicklines());
                    if(tmpPickline.getPrice() == pickline.getPrice())
                        tmpPickline.setAmount(tmpPickline.getAmount() + pickline.getAmount());
                    else
                        throw new IncompatibleCustomer();
                }
            }     
        }      */
        return picklines;
    }
    
    
    /*******************************
    ***** Hibernate Operations *****    
    ********************************/
    
    @Override
    public List<Pickings> query() {
        return pickingsDAO.query();
    }
        
    @Override
    public List<Pickings> queryToInvoice() {
        return null;
    }
    
    @Override
    public List<Pickings> queryToInvoice(Integer idcompanies) {
        List<Pickings> list = pickingsDAO.queryToInvoice(idcompanies);
        return list;
    }
    
    @Override
    public Pickings get(Integer idInvoice) {
        Pickings pick =  pickingsDAO.get(new Integer(1));
        return pick;
    }
    
    
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
