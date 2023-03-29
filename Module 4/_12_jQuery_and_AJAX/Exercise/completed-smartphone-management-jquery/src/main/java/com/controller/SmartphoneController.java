package com.controller;

import com.model.Smartphone;
import com.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Smartphone> update(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }

    @PutMapping
    public void edit(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
    }
}

