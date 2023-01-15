package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import practice.dao.UserDao;
import practice.model.Login;
import practice.model.User;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        return modelAndView;
    }

    @GetMapping("/home1")
    public String home1(ModelMap modelMap) {
        modelMap.addAttribute("login", new Login());
        return "home";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = UserDao.checkLogin(login);
        ModelAndView modelAndView;
        if (user == null) {
            modelAndView = new ModelAndView("error");
        } else {
            modelAndView = new ModelAndView("view");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
