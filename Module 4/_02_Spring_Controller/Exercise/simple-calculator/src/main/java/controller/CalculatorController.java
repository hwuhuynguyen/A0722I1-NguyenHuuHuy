package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam("firstOperand") double firstOperand,
                            @RequestParam("secondOperand") double secondOperand,
                            @RequestParam("operator") String operator,
                            Model model) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                try {
                    result = firstOperand / secondOperand;
                } catch (Exception exception) {
                    System.err.println(exception.getMessage());
                }
                break;
        }
        model.addAttribute("result", result);
        return new ModelAndView("index");
    }
}
