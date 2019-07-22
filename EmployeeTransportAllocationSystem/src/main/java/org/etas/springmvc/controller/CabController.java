package org.etas.springmvc.controller;

import java.util.List;

import org.etas.springmvc.bean.Cab;
import org.etas.springmvc.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CabController {

    @Autowired
    CabService cabService;

    @RequestMapping(value = "/getAllCabs", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getCabs(Model model) {

        List<Cab> listOfCabs = cabService.getAllCabs();
        model.addAttribute("cab", new Cab());
        model.addAttribute("listOfCabs", listOfCabs);
        return "cabDetails";
    }

    @RequestMapping(value = "/getCab/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Cab getCabById(@PathVariable int cabId) {
        return cabService.getCab(cabId);
    }

    @RequestMapping(value = "/addCab", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addCab(@ModelAttribute("cab") Cab cab) {
        if (cab.getCabId() == 0) {
            cabService.addCab(cab);
        } else {
            cabService.updateCab(cab);
        }

        return "redirect:/getAllCabs";
    }

    @RequestMapping(value = "/updateCab/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateCab(@PathVariable("id") int id, Model model) {
        model.addAttribute("cab", this.cabService.getCab(id));
        model.addAttribute("listOfCabs", this.cabService.getAllCabs());
        return "cabDetails";
    }

    @RequestMapping(value = "/setCabStatusToAvailable/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String setCabStatusToAvailable(@PathVariable("id") int id) {
        cabService.setCabStatusToAvailable(id);
        return "redirect:/getAllCabs";
        
    }
    
    @RequestMapping(value = "/setCabStatusToUnavailable/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String setCabStatusToUnavailable(@PathVariable("id") int id) {
        cabService.setCabStatusToUnavailable(id);
        return "redirect:/getAllCabs";

    }
}
