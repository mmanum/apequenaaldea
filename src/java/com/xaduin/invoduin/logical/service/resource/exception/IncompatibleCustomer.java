/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.logical.service.resource.exception;


/**
 *
 * @author manu
 */
public class IncompatibleCustomer extends Exception {
    
    public IncompatibleCustomer() {
        super("El cliente no es el mismo los albaranes son seleccionados.");
    }
    
}
