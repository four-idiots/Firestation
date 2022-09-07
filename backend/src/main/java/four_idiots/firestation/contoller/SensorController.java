package four_idiots.firestation.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SensorController {

    @GetMapping("/sensor/{id}")
    public String sensor(@PathVariable int id, Model model) {
        model.addAttribute("sensor", id);
        return "templates/ab/sensor";
    }
}
