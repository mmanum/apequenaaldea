/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.logical.service;

import com.xaduin.invoduin.persistence.domain.Companies;

import java.util.List;

/**
 *
 * @author manu
 */
public interface CompaniesService {
    
    public List<Companies> query();
    
    public Companies get(Integer idcompanies);
    
    public Companies getMyCompany();
}
