package vn.webapp.modules.usermanagement.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import vn.webapp.modules.usermanagement.service.FunctionService;
/**
 * 
 * @author Srinivas Nalla
 * 
 *
 */
@Component
public class DbFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean{
	private static final Logger logger = LoggerFactory.getLogger(DbFilterInvocationSecurityMetadataSource.class);
	
	@Autowired
	FunctionService functionService;
	
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		FilterInvocation fi=(FilterInvocation)object;
		String url=fi.getRequestUrl();
		System.out.println("Request Url====>"+url);
		List<String> roles_ = new ArrayList<String>();
		
		//If the page is login page, don't need any role		
		if(url.equals("/auth/login.html")){
			return null;
		}
		
		//If the page is home page, require "home_access" role which is given to all users
		if(url.equals("/")){
			roles_.add("HOME_ACCESS");			
		}else{		
			String[] tokens = url.split("/");
			if(tokens.length <=2){
				return null;
			}
			String module = tokens[1];
			String functionAction = tokens[2];
			
			//If the request is for asset file (css, js, pics), no permission is required
			if(module.equals("assets")){
				return null;
			}
			
			String urlFunctionAction = "/"+module+"/"+functionAction;
			String func_code = functionService.loadCodeByFunctionUrl(urlFunctionAction);
			
			//Func_code needed not found in database
			if(func_code == null){
				return null;
			}		
			roles_.add(func_code);
			System.out.println(func_code);
		}
		
		System.out.println("Url Associated Roles :"+roles_);
		String[] stockArr = new String[roles_.size()];
		stockArr = roles_.toArray(stockArr);
		
	    return SecurityConfig.createList(stockArr);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		
//		List<>
		
//		appService.getUrlRoles();
//		this.urlRoles=urlCache.getUrlRoles();
//		logger.debug("Url Roles object :"+urlRoles);
	}
	
	public static void main(String args[]){
		String test = "/a/b/c";
		String[] tokens = test.split("/");
		System.out.println(tokens.length);
	}

}
