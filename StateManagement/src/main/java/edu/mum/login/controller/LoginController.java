package edu.mum.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.login.domain.User;
import edu.mum.login.service.LoginService;

@Controller
//@SessionAttributes("user")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String getLoginForm(Model model){		
		return "login";
	}
	
	
	@RequestMapping(value="/welcome", method= RequestMethod.GET)
	public String welcome(Model model){		
		return "welcome";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)	
	public String authenticate(User user, boolean remember, 
				 			  @CookieValue(value="userName",defaultValue="") String userName, 
				 			  Model model, 
				 			  HttpServletResponse response,
				 			  RedirectAttributes redirectAttributes,
				 			  HttpSession session){
									
		
		
		if (loginService.authenticate(user)) {
			
			if(remember && userName.isEmpty()){
				Cookie cookie  = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(30*24*60*60);
				response.addCookie(cookie);
			}
			
			else if(!remember){
				Cookie cookie  = new Cookie("userName", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
			session.setAttribute("user",user);			
			return "redirect:/welcome"; 	
			 		
		} 
		else{
			model.addAttribute("error", "Username and/or password invalid.");
			return "login";
		}
		
	}
	
	
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(SessionStatus status, HttpSession session){
		//status.setComplete();
		session.invalidate();
		return "login";
	}
	
	
}
