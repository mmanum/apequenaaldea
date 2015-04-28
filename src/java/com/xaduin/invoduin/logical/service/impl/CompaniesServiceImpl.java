/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.logical.service.impl;

import com.xaduin.invoduin.logical.service.CompaniesService;
import com.xaduin.invoduin.persistence.dao.CompaniesDAO;
import com.xaduin.invoduin.persistence.domain.Companies;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author manu
 */
@Service("companiesServiceImpl")
public class CompaniesServiceImpl implements CompaniesService {
    
    private static Integer IdMyCompany = new Integer(1);
    
    // IoC
    @Autowired    
    @Qualifier("companiesDAOImpl")
    private CompaniesDAO companiesDAO; 
    
    
    public void setCompaniesDAO(CompaniesDAO companiesDAOImpl) {
        this.companiesDAO = companiesDAOImpl;
    }
    
    @Override
    public List<Companies> query() {
        return companiesDAO.query();
    }
    
    @Override
    public Companies get(Integer idCompanies) {
        Companies company =  companiesDAO.get(idCompanies);
        return company;
    }
    
    @Override
    public Companies getMyCompany() {
        return this.get(CompaniesServiceImpl.IdMyCompany);
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
