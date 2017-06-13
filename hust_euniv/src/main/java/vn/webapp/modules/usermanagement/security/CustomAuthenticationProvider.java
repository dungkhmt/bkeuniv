/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.webapp.modules.usermanagement.security;

import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import vn.webapp.modules.usermanagement.model.Function;
import vn.webapp.modules.usermanagement.model.User;
import vn.webapp.modules.usermanagement.service.FunctionService;
import vn.webapp.modules.usermanagement.service.UserService;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;	
	
	@Autowired
	private FunctionService functionService;	
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {  
        
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
       
        if ("".equals(username)) {
            throw new BadCredentialsException("You must fill in username");
        } 
        if ("".equals(password)) {
            throw new BadCredentialsException("You must fill in password");
        }
        
        String md5EncryptedPassword = DigestUtils.md5Hex(password);
    
        User user = userService.getByUsername(username);
                
        if (user == null) {
        	System.out.println("Username doesn't exists");
            throw new BadCredentialsException("Username doesn't exists");
        }
        if (!md5EncryptedPassword.equals(user.getPassword())) {
        	System.out.println("Wrong password");
            throw new BadCredentialsException("Wrong password");
        }
        
        List<Function> functionsOfUsers = functionService.loadFunctionsChildHierachyList(user.getUser_Code());
        //Every user has at least one function role will the permission to access to the homepage
        if(functionsOfUsers.size() > 0){
        	Function homeAccess = new Function();
	        homeAccess.setAuthority("HOME_ACCESS");
	        functionsOfUsers.add(homeAccess);
        }        
        Collection<? extends GrantedAuthority> authorities = functionsOfUsers;
        System.out.println(authorities.size());
        
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
