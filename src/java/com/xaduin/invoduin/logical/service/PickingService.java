/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.logical.service;

import com.xaduin.invoduin.logical.service.resource.exception.IncompatibleCustomer;
import com.xaduin.invoduin.logical.service.resource.exception.IncompatiblePrice;
import com.xaduin.invoduin.persistence.domain.Pickings;
import com.xaduin.invoduin.persistence.domain.Picklines;

import java.util.List;
import java.util.Map;

/**
 *
 * @author manu
 */
public interface PickingService {
    
    public List<Pickings> query();
    
    public Pickings get(Integer idPick);
        
    public Map mergePicks(Pickings pick) throws IncompatibleCustomer;
    
    public List<Pickings> queryToInvoice();
    
    public List<Pickings> queryToInvoice(Integer idcompanies);
    
}
