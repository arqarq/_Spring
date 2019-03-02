package pl.sdacademy.springboot5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class GreetingController {
    // @Autowired // niezalecane bez konstruktora
    // private GreetingService greetingService;
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetingEndpoint")
    public String greeting(Model model,
                           @RequestParam(name = "additional", required = false, defaultValue = "abcdef")
                                   String additional) {
        model.addAttribute("myAttribute", "I'm set in the controller");
        model.addAttribute("additionalAttribute", additional);
        return "greeting-view";
    }

    @GetMapping("/greetingService")
    @ResponseBody
    public <T extends String> T greetingFromService() {
        return (T) greetingService.greeting();
        // return "greeting-service"; // widok
    }
}
