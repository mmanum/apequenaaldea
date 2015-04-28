/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.presentation.controller;

import com.xaduin.invoduin.persistence.domain.Invoices;
import com.xaduin.invoduin.persistence.domain.Companies;
import com.xaduin.invoduin.persistence.domain.Pickings;
import com.xaduin.invoduin.persistence.domain.Picklines;

import com.xaduin.invoduin.logical.service.InvoicingService;
import com.xaduin.invoduin.logical.service.CompaniesService;
import com.xaduin.invoduin.logical.service.PickingService;
import com.xaduin.invoduin.logical.service.resource.exception.IncompatiblePrice;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/invoicing")
public class InvoicingController {

    // IoC
    @Autowired    
    @Qualifier("invoicingServiceImpl")
    private InvoicingService invoicingService;
    
    // IoC
    @Autowired    
    @Qualifier("companiesServiceImpl")
    private CompaniesService companiesService;
    
    // IoC
    @Autowired    
    @Qualifier("pickingServiceImpl")
    private PickingService pickingService;

    public void setInvoicesService(InvoicingService invoicingServiceImpl) {
        this.invoicingService = invoicingServiceImpl;
    }

    public void setCompaniesService(CompaniesService companiesServiceImpl) {
        this.companiesService = companiesServiceImpl;
    }
    
    // ---
    
    @RequestMapping(value={"/", "index.htm","index.html", "index.php"})
    public ModelAndView index() {
        List<Invoices> invoices = invoicingService.query();
        ModelAndView mav = new ModelAndView("invoicingHome");        
        mav.addObject("invoices", invoices);
        return mav;
    }
    
    /**
     *
     *
    */
    @RequestMapping(params="accion=QRY")
    public ModelAndView query() {
        List<Invoices> invoices = invoicingService.query();

        ModelAndView mav = new ModelAndView("invoicingHome");
        mav.addObject("invoices", invoices);

        return mav;
    }
    
    @RequestMapping(params="accion=GET")
    public ModelAndView get(HttpServletRequest request) {
        String id = request.getParameter("id");

        ModelAndView mav;
        Invoices invoice = invoicingService.get(Integer.valueOf(id));

        mav = new ModelAndView("autoresGet");
        mav.addObject("invoice", invoice);

        return mav;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET) 
    public ModelAndView profile(@PathVariable("id") String id) {
                
        Companies myCompany = companiesService.getMyCompany();
        Invoices invoice = invoicingService.get(Integer.valueOf(id));
         
        try {
            Map picklines = invoicingService.mergePicklines(invoice);
            
            ModelAndView mav = new ModelAndView("invoice");        
            mav.addObject("myCompany", myCompany);
            mav.addObject("invoice", invoice); 
            mav.addObject("picklines", picklines.values());
            return mav;
            
        }catch(IncompatiblePrice ex) {
            System.out.println("Excepción Precio Incompatible");
            return null;
        }
        
    }
    

    @RequestMapping( params = "accion=INS", method=RequestMethod.GET)
    public ModelAndView insert( @RequestParam(value="company", required=false)Integer idcompany) {
               
        ModelAndView mav = new ModelAndView("invoiceIns");        
        
        List<Companies> lCompanies = companiesService.query();
        List<Pickings> lPicks = pickingService.queryToInvoice(idcompany);
        String nextInvoiceNumber = invoicingService.getNextInvoiceNumber();

        Invoices invoice = new Invoices();
        mav.addObject("invoicef", invoice);     
        mav.addObject("idcompany", idcompany);
        mav.addObject("companies", lCompanies);
        mav.addObject("picks", lPicks);
        return mav;
    }
/*
    @RequestMapping(params = "accion=INS2")
    public ModelAndView insert2(@ModelAttribute Autores autores) {
        String result = autoresService.insert(autores);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Solicitud atendida.");

        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "accion=DEL")
    public ModelAndView delete(HttpServletRequest request) {
        String ids = request.getParameter("ids");

        String result = autoresService.delete(ids);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Solicitud atendida.");

        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    
    
    @RequestMapping(params = "accion=UPD")
    public ModelAndView update(@ModelAttribute Autores autores) {
        String result = autoresService.update(autores);

        if (result == null) {
            result = "Solicitud atendida.";
        }

        ModelAndView mav = new ModelAndView("mensaje");
        mav.addObject("msg", result);

        return mav;
    }
    */
}
