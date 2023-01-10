package controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String save() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@Nullable @RequestParam("condiments") String[] condiments, Model model) {
        if (condiments == null)
            model.addAttribute("result", "None of condiments is selected!!");
        else
            model.addAttribute("result", Arrays.toString(condiments));
        return "index";
    }
}
