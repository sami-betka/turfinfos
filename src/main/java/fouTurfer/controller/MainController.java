package fouTurfer.controller;

import java.awt.Font;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import combibet.entity.Gambler;
import combibet.entity.UserRole;
import fouTurfer.model.UserAccount;

@Controller
public class MainController {
	
	 @GetMapping("/test")
	    public String test(Model model) {

	        return "test";
	    }
	 
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String loginPage(Model model, Principal principal) {

			if (principal != null) {
				return "redirect:/bankroll-list";
			}

			return "login";
		}
		
		@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
		public String logoutSuccessfulPage(Model model, Principal principal) {
			model.addAttribute("title", "Logout");
//	        navbarAttributes(model, principal);
			return "redirect:/bankroll-list";

//	        return "logoutSuccessfulPage";
		}
		
		@RequestMapping(value = "/userAccountInfo", method = RequestMethod.GET)
		public String loginSuccess(Model model, Principal principal) {

			UserAccount user = gamblerRepository.findByUserName(principal.getName());
			for (UserRole userRole : userRoleRepository.findAll()) {
				if (userRole.getAppRole().getRoleId() == 1 && userRole.getUser().getId() == user.getId()) {
					return "redirect:/admingate";
				}
			}
//			SmsRequest smsRequest = new SmsRequest("+33652463080", "Youhou !");
//			service.sendSms(smsRequest);
			return "redirect:/bankroll-list";
		}
	 
	 @GetMapping("/redirect-to-reunion-infos")
	    public String redirectToReunionInfos(
	    		@RequestParam("jour") String jour,
	    		@RequestParam("reunion") String reunion,
	    		Model model) {

			return "redirect:/reunion-infos?jour=" + jour + "&reunion=" + reunion;
	    }
	
    @GetMapping("/nav")
    public String nav(Model model) {

        return "_nav-components";
    }
    
    @GetMapping("/doigt")
    public String doigt(Model model) {
    	
        return "doigt";
    }
        
}