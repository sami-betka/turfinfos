package fouTurfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
    @GetMapping("/enter-chronos")
    public String enterChronos(Model model) {

        return "enter-chronos";
    }
    
}