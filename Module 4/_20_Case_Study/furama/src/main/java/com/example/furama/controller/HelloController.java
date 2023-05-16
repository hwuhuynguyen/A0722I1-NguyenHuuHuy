package codegym.vn.springboot.controller;

import codegym.vn.springboot.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        if (model != null) {
            throw new MyException("Exception at Hello");
        }
        return "error/hello";
    }
}
