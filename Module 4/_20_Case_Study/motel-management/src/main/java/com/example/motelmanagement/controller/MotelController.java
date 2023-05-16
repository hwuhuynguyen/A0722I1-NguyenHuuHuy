package com.example.motelmanagement.controller;


import com.example.motelmanagement.entity.Motel;
import com.example.motelmanagement.entity.Payment;
import com.example.motelmanagement.service.IMotelService;
import com.example.motelmanagement.service.IPaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/motel")
public class MotelController {
    @Autowired
    private IMotelService motelService;

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/list")
    public String getMotelList(Model model, @RequestParam("search") Optional<String> search,
                               @RequestParam("filter") Optional<String> filter) {
        List<Motel> motelList;
        if (search.isPresent()) {
            motelList = (List<Motel>) motelService.searchByCustomerNameContainingIgnoreCase(search.get());
        } else {
            motelList = (List<Motel>) motelService.findAvailableMotels();
        }
        if (filter.isPresent()) {
            Payment payment = paymentService.findById(filter.get()).get();
            motelList = (List<Motel>) motelService.searchAvailableMotelsByPaymentMethod(payment);
            System.err.println("done");
        }
        model.addAttribute("motelList", motelList);
        model.addAttribute("paymentList", paymentService.findAll());
        return "motel/list";
    }

    @GetMapping("/create")
    public String displayCreateForm(Model model) {
        List<Payment> paymentList = (List<Payment>) paymentService.findAll();
        Motel motel = new Motel();
        motel.setId(autoGenerateMotelId());
        model.addAttribute("motel", motel);
        model.addAttribute("paymentList", paymentList);
        return "motel/create";
    }

    @PostMapping("/create")
    public String createNewMotel(@Valid @ModelAttribute("motel") Motel motel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Payment> paymentList = (List<Payment>) paymentService.findAll();
            model.addAttribute("paymentList", paymentList);
            if (motel.getPayment() == null) {
                motel.setPayment(new Payment());
            }
            return "/motel/create";
        }
        motel.setId(autoGenerateMotelId());
        System.err.println(motel);
        motelService.save(motel);
        return "redirect:/motel/list";
    }

    @GetMapping("/view/{id}")
    public String viewDetailMotel(@PathVariable("id") String id, Model model) {
        Motel motel = motelService.findById(id).isPresent() ? motelService.findById(id).get() : null;
        System.err.println(motel);
        if (motel != null) {
            model.addAttribute("motel", motel);
            return "/motel/view";
        }
        return "error";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        Motel motel = motelService.findById(id).isPresent() ? motelService.findById(id).get() : null;
        if (motel != null) {
            List<Payment> paymentList = (List<Payment>) paymentService.findAll();
            model.addAttribute("motel", motel);
            model.addAttribute("paymentList", paymentList);
            return "/motel/update";
        }
        return "error";
    }

    @PostMapping("/update")
    public String updateMotel(@Valid @ModelAttribute("motel") Motel motel,
                              BindingResult bindingResult, Model model) {
        System.err.println(motel);
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getErrorCount());
            System.err.println(bindingResult.getAllErrors());
            List<Payment> paymentList = (List<Payment>) paymentService.findAll();
            model.addAttribute("paymentList", paymentList);
            if (motel.getPayment() == null) {
                motel.setPayment(new Payment());
            }
            System.err.println(motel);
            return "/motel/update";
        }
        motelService.save(motel);
        return "redirect:/motel/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteMotelById(@PathVariable("id") String id) {
        Motel motel = motelService.findById(id).isPresent() ? motelService.findById(id).get() : null;
        if (motel != null) {
            motel.setDeleted(true);
            motelService.save(motel);
            System.err.println("deleted");
        }
        return "redirect:/motel/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAllByIds(@RequestParam("ids") Optional<String[]> ids) {
        if (ids.isEmpty()) return "redirect:/motel/list";
        List<Motel> motelList = (List<Motel>) motelService.findAvailableMotelsByIdIn(ids.get());
        for (Motel motel : motelList) {
            System.err.println(motel);
            motel.setDeleted(true);
            motelService.save(motel);
        }
        return "redirect:/motel/list";
    }

    private String autoGenerateMotelId() {
        List<Motel> motelList = (List<Motel>) motelService.findAll();
        if (motelList.size() == 0) return "PT-001";
        String lastId = motelList.get(motelList.size() - 1).getId();
        String[] split = lastId.split("-");
        int number = Integer.parseInt(split[1]) + 1;
        return (number < 10) ? ("PT-00" + number) : ("PT-0" + number);
    }
}
