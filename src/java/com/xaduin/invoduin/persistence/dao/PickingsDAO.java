/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao;

import com.xaduin.invoduin.persistence.domain.Pickings;

import java.util.List;

/**
 *
 * @author manu
 */
public interface PickingsDAO {
    
    public List<Pickings> query();
    
    public List<Pickings> queryToInvoice();
    
    public List<Pickings> queryToInvoice(Integer idcompanies);

    public String insertUpdate(Pickings pick);

    public String delete(Integer idPick);

    public Pickings get(Integer pick);
    
}
