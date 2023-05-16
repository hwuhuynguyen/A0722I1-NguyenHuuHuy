package codegym.vn.springboot.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String user,
                          @RequestParam("password") String pass,
                          HttpSession session, Model model) {
        if ("root".equals(user) && "admin".equals(pass)) {
            session.setAttribute("user", user);
            return "redirect:/student/list";
        }

        model.addAttribute("username", user);
        model.addAttribute("error", "Sai user hoặc pass");
        return "login";
    }
}
