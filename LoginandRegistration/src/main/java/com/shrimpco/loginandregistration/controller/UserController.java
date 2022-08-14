package com.shrimpco.loginandregistration.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shrimpco.loginandregistration.model.User;
import com.shrimpco.loginandregistration.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value="/", method=RequestMethod.GET)
	private String loginPage(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("user", new User());
		return "index.jsp";
	}
	
	@RequestMapping( value="/register", method=RequestMethod.POST)
	private String register(@Valid @ModelAttribute("newUser") User newUser,
							BindingResult bindingResult,
							HttpSession session,
							RedirectAttributes redirectAttribute,
							Model model) {
		
		//checking confirm = password
		if(!newUser.getPassword().equals(newUser.getConfirm_password())) {
			System.out.println("unsuccessful register - password mismatch");
			bindingResult.rejectValue("confirm_password", "Matches", "Password mismatch!");
			return "index.jsp";
		}
		//checking if db req met
		if(bindingResult.hasErrors()) {
			System.out.println("unsuccessful register - table req not met");
			return "index.jsp";
		}
		//checking if email exists
		User potentialUser = userService.singleUserByLogin(newUser.getEmail());
		if(potentialUser != null){
			System.out.println("unsuccessful register - email already exists");
			bindingResult.rejectValue("email", "In Use", "The email already exists in db!");
			return "index.jsp";
		} else {
			
			// else no errors create user and add email/id to session
			User currentUser = userService.createUser( newUser );
			session.setAttribute("email", newUser.getEmail() );
			session.setAttribute("id", newUser.getId() );
			session.setAttribute("first_name", newUser.getFirst_name() );
			session.setAttribute("last_name", newUser.getLast_name() );
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping( value="/login", method=RequestMethod.POST)
	private String login(@Valid @ModelAttribute("user") User user,
						BindingResult bindingResult,
						HttpSession session,
						Model model) {
		//if errors
		User currentUser = userService.singleUserByLogin(user.getEmail());
		if(currentUser != null) {
			
			if(BCrypt.checkpw(user.getPassword(), currentUser.getPassword() ) ) {
					System.out.println("successful login");
					session.setAttribute("email", currentUser.getEmail() );
					session.setAttribute("id", currentUser.getId() );
					session.setAttribute("first_name", currentUser.getFirst_name() );
					session.setAttribute("last_name", currentUser.getLast_name() );
					return "redirect:/dashboard";
			}
			else {
				System.out.println("unsuccessful login - password");
				bindingResult.rejectValue("password", "Incorrect", "Password not correct!");
				model.addAttribute("newUser", new User());
				return "index.jsp";
			}
		} else {
			System.out.println("unsuccessful login - email");
			bindingResult.rejectValue("email", "Incorrect", "email not correct!");
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
	} 
	
	@RequestMapping( value="/dashboard", method=RequestMethod.GET)
	private String dashboard() {
		
		return "dashboard.jsp";
	}
	
	@RequestMapping (value="/logout", method=RequestMethod.GET)
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
