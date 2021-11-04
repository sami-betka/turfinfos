package fouTurfer.controller;

import java.awt.Font;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	 @GetMapping("/test")
	    public String test(Model model) {

	        return "test";
	    }
	
    @GetMapping("/nav")
    public String nav(Model model) {

        return "_nav-components";
    }
    
    @GetMapping("/doigt")
    public String doigt(Model model) {
    	
    	paintComponent();

        return "doigt";
    }
    
    public void paintComponent() {

 
    	Font font = new Font("LucidaSans", Font.BOLD, 14);
    	System.out.println(font.getName());

    }
    
}