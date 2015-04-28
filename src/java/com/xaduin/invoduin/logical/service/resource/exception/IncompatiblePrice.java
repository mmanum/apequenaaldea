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
public class IncompatiblePrice extends Exception {
    
    public IncompatiblePrice() {
        super("El precio del mismo producto de dos albaranes son distitos.");
    }
    
}
