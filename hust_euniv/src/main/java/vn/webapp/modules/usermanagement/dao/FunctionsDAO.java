/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : December 27th, 2015
 */
package vn.webapp.modules.usermanagement.dao;

import java.util.List;

import vn.webapp.modules.usermanagement.model.Function;

public interface FunctionsDAO {
	
	/**
	 * 
	 * @return
	 */
	public List<Function> loadFunctionsListByUser(String Usercode);
	
	public List<Function> loadFunctionsList();
	
	public List<Function> loadFunctionsParentHierachyList();
	
	public List<Function> loadFunctionsChildHierachyList();
	
	public List<Function> loadFunctionsParentHierachyList(String Usercode);
	
	public List<Function> loadFunctionsChildHierachyList(String Usercode);
	
	public String loadCodeByFunctionUrl(String Func_Url);

}
