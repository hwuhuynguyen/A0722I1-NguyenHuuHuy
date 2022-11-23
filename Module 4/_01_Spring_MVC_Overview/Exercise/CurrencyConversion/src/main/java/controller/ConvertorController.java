package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertorController {
    @GetMapping("/convertor")
    public ModelAndView displayConvertForm() {
        ModelAndView modelAndView = new ModelAndView("convert");
        modelAndView.addObject("USD", 0);
        modelAndView.addObject("rate", 0);
        modelAndView.addObject("result", 0);
        return modelAndView;
    }

    @PostMapping("/convertor")
    public ModelAndView convert(@RequestParam("USD") String money, @RequestParam("rate") String rate) {
        ModelAndView modelAndView = new ModelAndView("convert");
        try {
            double usd = Double.parseDouble(money);
            double exchangeRate = Double.parseDouble(rate);
            modelAndView.addObject("USD", usd);
            modelAndView.addObject("rate", exchangeRate);
            modelAndView.addObject("result", usd * exchangeRate + " VND");
        } catch (NumberFormatException exception) {
            System.err.println(exception.getMessage());

            modelAndView.addObject("result", "Error while casting to double");
        }
        return modelAndView;
    }
}
