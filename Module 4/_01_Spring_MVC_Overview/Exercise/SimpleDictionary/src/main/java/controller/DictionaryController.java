package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("word", "tu ngu");
        dictionary.put("house", "ngoi nha");
        dictionary.put("hello", "xin chao");
        dictionary.put("computer", "may tinh");
    }
    @GetMapping("/dictionary")
    public ModelAndView displayDictionaryForm() {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        modelAndView.addObject("word", "");
        modelAndView.addObject("result", "");
        return modelAndView;
    }

    @PostMapping("/dictionary")
    public ModelAndView translate(@RequestParam("engWord") String word) {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        String result = dictionary.get(word);
        if (result == null) {
            result = "Cannot find this word in the dictionary";
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
