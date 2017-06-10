package vn.webapp.modules.usermanagement.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.webapp.controller.BaseWeb;
import vn.webapp.modules.usermanagement.model.User;
import vn.webapp.modules.usermanagement.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = {""})
public class HomeController extends BaseWeb {
	
    @Autowired
    private UserService userService;
    
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!username.equals("anonymousUser")){
		    User user = userService.getByUsername(username);
		    session.setAttribute("currentUser", user);				   
		}
		return "home";
	}	
}
