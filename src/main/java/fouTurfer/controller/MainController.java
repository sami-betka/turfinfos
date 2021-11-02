package fouTurfer.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
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