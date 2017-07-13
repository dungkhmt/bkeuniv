/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : December 27th, 2015
 */
package vn.webapp.modules.usermanagement.service;

import java.util.List;

import vn.webapp.modules.usermanagement.model.Function;

public interface FunctionService {
	/**
	 * 
	 * @return
	 */
	public List<Function> loadFunctionListByUser(String sUserCode);
	
	/**
	 * 
	 * @param sUserCode
	 * @return
	 */
	//public Function loadFunctionsPermissionByCodeAndUser(String sFuncCode, String sUserCode);
    
	/**
	 * 
	 * @param null
	 * @return
	 */
	public List<Function> loadFunctionsList();
	
	/**
	 * 
	 * @return
	 */
	public List<Function> loadFunctionsParentHierachyList();
	
	/**
	 * 
	 * @return
	 */
	public List<Function> loadFunctionsChildHierachyList();
	
	/**
	 * 
	 * @param sFuncCode
	 * @param sUserCode
	 * @return
	 */
	
	public List<Function> loadFunctionsParentHierachyList(String Usercode);
	
	public List<Function> loadFunctionsChildHierachyList(String Usercode);
	
	public String loadCodeByFunctionUrl(String Func_Url);
	
	
	public Boolean checkAccess(String sUserCode, String sFuncCode);
}
