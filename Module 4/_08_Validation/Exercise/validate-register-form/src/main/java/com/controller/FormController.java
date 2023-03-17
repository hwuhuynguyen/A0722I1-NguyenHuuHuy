package com.controller;

import com.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @GetMapping("/register-form")
    public ModelAndView showRegisterForm()
    {
        return new ModelAndView("/index", "user", new User());
    }

    @PostMapping("/create")
    public String checkValidation(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model)
    {
        new User().validate(user, bindingResult);
        if(bindingResult.hasFieldErrors())
        {
            model.addAttribute("user", user);
            return "/index";
        }
        else
        {
            return "/result";
        }
    }
}
