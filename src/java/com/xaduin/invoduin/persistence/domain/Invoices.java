package com.xaduin.invoduin.persistence.domain;
// Generated Apr 21, 2015 7:11:40 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Invoices generated by hbm2java
 */
public class Invoices  implements java.io.Serializable {


     private Integer idinvoices;
     private Companies companies;
     private String number;
     private Date date;
     private double taxs;
     private double rates;
     private double amountfree;
     private boolean invoiced;
     private Set pickingses = new HashSet(0);

    public Invoices() {
    }

	
    public Invoices(Companies companies, String number, Date date, double taxs, double rates, double amountfree, boolean invoiced) {
        this.companies = companies;
        this.number = number;
        this.date = date;
        this.taxs = taxs;
        this.rates = rates;
        this.amountfree = amountfree;
        this.invoiced = invoiced;
    }
    public Invoices(Companies companies, String number, Date date, double taxs, double rates, double amountfree, boolean invoiced, Set pickingses) {
       this.companies = companies;
       this.number = number;
       this.date = date;
       this.taxs = taxs;
       this.rates = rates;
       this.amountfree = amountfree;
       this.invoiced = invoiced;
       this.pickingses = pickingses;
    }
   
    public Integer getIdinvoices() {
        return this.idinvoices;
    }
    
    public void setIdinvoices(Integer idinvoices) {
        this.idinvoices = idinvoices;
    }
    public Companies getCompanies() {
        return this.companies;
    }
    
    public void setCompanies(Companies companies) {
        this.companies = companies;
    }
    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public double getTaxs() {
        return this.taxs;
    }
    
    public void setTaxs(double taxs) {
        this.taxs = taxs;
    }
    public double getRates() {
        return this.rates;
    }
    
    public void setRates(double rates) {
        this.rates = rates;
    }
    public double getAmountfree() {
        return this.amountfree;
    }
    
    public void setAmountfree(double amountfree) {
        this.amountfree = amountfree;
    }
    public boolean isInvoiced() {
        return this.invoiced;
    }
    
    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }
    public Set getPickingses() {
        return this.pickingses;
    }
    
    public void setPickingses(Set pickingses) {
        this.pickingses = pickingses;
    }




}


