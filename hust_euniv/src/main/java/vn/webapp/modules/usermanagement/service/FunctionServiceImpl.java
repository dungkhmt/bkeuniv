/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : October 14th, 2015
 */
/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : December 27th, 2015
 */
package vn.webapp.modules.usermanagement.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.webapp.modules.usermanagement.dao.FunctionsDAO;
import vn.webapp.modules.usermanagement.model.Function;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionsDAO functionsDAO;

	/**
	 * Get permissions by user code
	 * 
	 * @param String
	 * @return object
	 * @throws UsernameNotFoundException
	 */
	@Override
	@Transactional
	public List<Function> loadFunctionListByUser(String sUserCode) {
		return functionsDAO.loadFunctionsListByUser(sUserCode);		
	}

	@Override
	@Transactional
	public List<Function> loadFunctionsList() {
		return functionsDAO.loadFunctionsList();		
	}

	/**
     * 
     */
	@Override
	@Transactional
	public List<Function> loadFunctionsParentHierachyList() {
		return functionsDAO.loadFunctionsParentHierachyList();
	}

	@Override
	@Transactional
	public List<Function> loadFunctionsChildHierachyList() {
		return functionsDAO.loadFunctionsChildHierachyList();
	}
	
	@Override
	@Transactional	
	public List<Function> loadFunctionsParentHierachyList(String Usercode){
		return functionsDAO.loadFunctionsParentHierachyList(Usercode);
	}
	
	@Override
	@Transactional	
	public List<Function> loadFunctionsChildHierachyList(String Usercode){
		return functionsDAO.loadFunctionsChildHierachyList(Usercode);
	}
	
	@Override
	@Transactional
	public String loadCodeByFunctionUrl(String Func_Url){
		return functionsDAO.loadCodeByFunctionUrl(Func_Url);
	}

	@Override
	public Boolean checkAccess(String sUserCode, String sFuncCode) {
		JSONObject field = new JSONObject();
		field.put("users.User_Code", sUserCode);
		field.put("f.FUNC_CODE", sFuncCode);
		List<Function> mFuncsPermission = functionsDAO.listFunctionByFields(field);
		if(mFuncsPermission==null||mFuncsPermission.size()<1) {
			return false;
		} else {
			return true;
		}
	}

}
