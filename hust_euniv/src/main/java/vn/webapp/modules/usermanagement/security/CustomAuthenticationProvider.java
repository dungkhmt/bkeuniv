/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.webapp.modules.usermanagement.security;

import java.util.Collection;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import vn.webapp.modules.usermanagement.model.User;
import vn.webapp.modules.usermanagement.service.UserService;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;	

	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {  
        
		System.out.println("authen OK");
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        System.out.println(username + " " + password);
       
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
        
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        System.out.println(authorities.size());
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
