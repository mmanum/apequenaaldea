/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.persistence.dao;

import com.xaduin.invoduin.persistence.domain.Picklines;

import java.util.List;

/**
 *
 * @author manu
 */
public interface PicklinesDAO {
    
    public List<Picklines> query();

    public String insertUpdate(Picklines pickline);

    public String delete(Integer pickline);

    public Picklines get(Integer pickline);
    
}
