/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xaduin.invoduin.presentation.controller;

import com.xaduin.invoduin.persistence.domain.Companies;
import com.xaduin.invoduin.persistence.domain.Pickings;
import com.xaduin.invoduin.persistence.domain.Picklines;

import com.xaduin.invoduin.logical.service.PickingService;
import com.xaduin.invoduin.logical.service.CompaniesService;
import com.xaduin.invoduin.logical.service.resource.exception.IncompatibleCustomer;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/picking")
public class PickingController {

    // IoC
    @Autowired    
    @Qualifier("pickingServiceImpl")
    private PickingService pickingService;
    
    // IoC
    @Autowired    
    @Qualifier("companiesServiceImpl")
    private CompaniesService companiesService;

    public void setInvoicesService(PickingService pickingServiceImpl) {
        this.pickingService = pickingServiceImpl;
    }

    public void setCompaniesService(CompaniesService companiesServiceImpl) {
        this.companiesService = companiesServiceImpl;
    }
    
    // ---
    
    @RequestMapping(value={"/", "index.htm","index.html", "index.php"})
    public ModelAndView index() {
        
        List<Pickings> picks = pickingService.query();
        ModelAndView mav = new ModelAndView("pickingHome");        
        mav.addObject("picks", picks);
        return mav;
    }
    
    /**
     *
     *
    */
    @RequestMapping(params="accion=QRY")
    public ModelAndView query() {
        List<Pickings> picks = pickingService.query();

        ModelAndView mav = new ModelAndView("pickingHome");
        mav.addObject("picks", picks);

        return mav;
    }
    
    @RequestMapping(params = "accion=GET")
    public ModelAndView get(HttpServletRequest request) {
        String id = request.getParameter("id");

        ModelAndView mav;
        Pickings pick = pickingService.get(Integer.valueOf(id));

        mav = new ModelAndView("autoresGet");
        mav.addObject("pick", pick);

        return mav;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET) 
    public ModelAndView profile(@PathVariable("id") String id) {
                
        Companies myCompany = companiesService.getMyCompany();
        Pickings pick = pickingService.get(Integer.valueOf(id));
         
        try {
            Map picklines = pickingService.mergePicks(pick);
            
            ModelAndView mav = new ModelAndView("invoice");        
            mav.addObject("myCompany", myCompany);
            mav.addObject("pick", pick); 
            mav.addObject("picklines", picklines.values());
            return mav;
            
        }catch(IncompatibleCustomer ex) {
            System.out.println("Excepción Precio Incompatible");
            return null;
        }
        
    }
    
/*
    @RequestMapping(params = "accion=INS1")
    public ModelAndView insert1() {
        ModelAndView mav = new ModelAndView("autoresIns");

        Autores autores = new Autores();
        mav.addObject("autores", autores);

        return mav;
    }

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
