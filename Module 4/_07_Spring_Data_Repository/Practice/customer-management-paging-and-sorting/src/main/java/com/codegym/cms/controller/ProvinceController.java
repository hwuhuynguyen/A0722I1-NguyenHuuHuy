package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.customer.ICustomerService;
import com.codegym.cms.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

//    @GetMapping("/provinces")
    @RequestMapping(value = "/provinces", method = RequestMethod.GET)
    public ModelAndView listProvinces() {
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

//    @GetMapping("/create-province")
    @RequestMapping(value = "/create-province", method = RequestMethod.GET)
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

//    @PostMapping("/create-province")
    @RequestMapping(value = "/create-province", method = RequestMethod.POST)
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

//    @GetMapping("/edit-province/{id}")
    @RequestMapping(value = "/edit-province/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

//    @PostMapping("/edit-province")
    @RequestMapping(value = "/edit-province", method = RequestMethod.POST)
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

//    @GetMapping("/delete-province/{id}")
    @RequestMapping(value = "/delete-province/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

//    @PostMapping("/delete-province")
    @RequestMapping(value = "/delete-province", method = RequestMethod.POST)
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }

//    @GetMapping("/view-province/{id}")
    @RequestMapping(value = "/view-province/{id}", method = RequestMethod.GET)
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> provinceOptional = provinceService.findById(id);
        if(provinceOptional.isEmpty()){
            return new ModelAndView("/error.404");
        }

//        Iterable<Customer> customers = customerService.findAllByProvince(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", provinceOptional.get());
        modelAndView.addObject("customers", null);
        return modelAndView;
    }
}
