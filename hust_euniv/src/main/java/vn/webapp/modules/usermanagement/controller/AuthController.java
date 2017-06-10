package vn.webapp.modules.usermanagement.controller;

import java.util.HashSet;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.webapp.controller.BaseWeb;
import vn.webapp.modules.usermanagement.model.Role;
import vn.webapp.modules.usermanagement.service.RoleService;
import vn.webapp.modules.usermanagement.service.UserService;
import vn.webapp.modules.usermanagement.validation.UserValidation;


@Controller
@RequestMapping(value="/auth")
public class AuthController extends BaseWeb {
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private RoleService roleService;	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {		
		return "signin";
	}	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		model.addAttribute("userForm", new UserValidation());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveAnUser(HttpServletRequest request,
			@Valid @ModelAttribute("userForm") UserValidation userForm,
			BindingResult result, Model model, HttpSession session) {

		model.addAttribute("username", userForm.getUsername());
		model.addAttribute("password", userForm.getPassword());
		model.addAttribute("repassword", userForm.getRepassword());
		
		if(result.hasErrors()){
			return "register";
		}
		
		if(userService.getByUsername(userForm.getUsername()) != null){			
			model.addAttribute("status", "Username exists");		
			model.addAttribute("userForm", new UserValidation());
			return "register";			
		}
				
		if(!userForm.getPassword().equals(userForm.getRepassword())){			
			model.addAttribute("status", "Password and repassword not match");
			model.addAttribute("userForm", new UserValidation());
			return "register";
		}
		
		try {			
			String username = userForm.getUsername();
			String password = DigestUtils.md5Hex(userForm.getPassword());
			
			Role role = roleService.getByName("ROLE_USER");
			HashSet<Role> roles = new HashSet<Role>();
			roles.add(role);
			userService.save(username, password, roles);
			
		} catch (Exception e) {
			model.addAttribute("status", "You failed to create new account");
			model.addAttribute("userForm", new UserValidation());
			return "register";			
		}		
		model.addAttribute("status", "You have registered successfully the account, please login to continue");
		return "login";	
		
	}	
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String denied(Locale locale, Model model) {		
		return "denied";
	}	

}
