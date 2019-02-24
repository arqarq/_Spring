package pl.sdacademy.springboot5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greetingEndpoint")
    public String greeting(Model model,
                           @RequestParam(name = "additional", required = false, defaultValue = "abcdef")
                                   String additional) {
        model.addAttribute("myAttribute", "I'm set in the controller");
        model.addAttribute("additionalAttribute", additional);
        return "greeting-view";
    }
}
