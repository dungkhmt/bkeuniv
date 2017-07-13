package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.List;

import org.json.simple.JSONObject;

import vn.webapp.modules.researchdeclarationmanagement.model.Staff;

public interface StaffDAO {

	/**
	 * 
	 * @return
	 */
	public List<Staff> listStaffs();
	
	/**
	 * 
	 * @param Object
	 * @return
	 */
	public List<Staff> listStaffByFields(JSONObject fields);
	
	
	
    /**
     * 
     * @param staff
     */
    public void editAStaff(Staff staff);
    
    /**
     * 
     * @param staff
     * @return
     */
    public int saveAStaff(Staff staff);
    
    /**
     * 
     * @param staffId
     * @return
     */
    public int removeAStaff(Staff staff);
}
