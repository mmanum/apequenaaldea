/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao;

import com.xaduin.invoduin.persistence.domain.Companies;

import java.util.List;

/**
 *
 * @author manu
 */
public interface CompaniesDAO {
    
    public List<Companies> query();

    public String insertUpdate(Companies companies);

    public String delete(Integer idCompanies);

    public Companies get(Integer idCompanies);
    
}
