package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.customer.ICustomerService;
import com.codegym.cms.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }


//    @GetMapping("/create-customer")
    @RequestMapping(value = "/create-customer", method = RequestMethod.GET)
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

//    @PostMapping("/create-customer")
    @RequestMapping(value = "/create-customer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

//    @GetMapping("/customers")
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Customer> customers;
//        Pageable pageable = PageRequest.of(1,5);
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }


//    @GetMapping("/edit-customer/{id}")
    @RequestMapping(value = "/edit-customer/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

//    @PostMapping("/edit-customer")
    @RequestMapping(value = "/edit-customer", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

//    @GetMapping("/delete-customer/{id}")
    @RequestMapping(value = "/delete-customer/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

//    @PostMapping("/delete-customer")
    @RequestMapping(value = "/delete-customer", method = RequestMethod.POST)
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }

}
