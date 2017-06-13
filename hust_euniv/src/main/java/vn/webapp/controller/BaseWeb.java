/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.webapp.modules.usermanagement.model.Function;

public class BaseWeb {

    @Autowired
    private HttpServletRequest request;
    protected String baseUrl;
    protected String assetsUrl;
    
    public BaseWeb() {
		// TODO Auto-generated constructor stub
	}
    
    @ModelAttribute
    public void addGlobalAttr(ModelMap map, HttpSession session) {
        if(request.getRequestURI().equals("/")){
        	baseUrl = request.getRequestURL().substring(0, request.getRequestURL().length() - 1).toString();
        }else if(request.getRequestURI().equals("")){
            baseUrl = request.getRequestURL().toString();            
        }else{
            baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());            
        }               
        
        assetsUrl = baseUrl + "/assets";
        map.put("baseUrl", baseUrl);
        map.put("assetsUrl", assetsUrl);
        
        if(session.getAttribute("funcsParentsList") != null){
        	List<Function> funcsChildrenList = (List<Function>)session.getAttribute("funcsChildrenList");
        	List<Function> funcsParentsList = (List<Function>)session.getAttribute("funcsParentList");
        	map.put("funcsChildrenList", funcsChildrenList);        	
        	map.put("funcsParentsList", funcsParentsList);
        	
        }
    }
}
