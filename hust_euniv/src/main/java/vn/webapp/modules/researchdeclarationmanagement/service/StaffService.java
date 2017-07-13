package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import org.json.simple.JSONObject;

import vn.webapp.modules.researchdeclarationmanagement.model.Staff;

public interface StaffService {
	
	/**
	 * 
	 * @return
	 */
	public List<Staff> listStaffs();
	
	/**
	 * 
	 * @param staffFaculty
	 * @return
	 */
	public List<Staff> listStaffsByFields(JSONObject field);
	
    /**
     * 
     * @param StaffId
     * @param staffName
     * @param staffEmail
     * @param staffPhone
     * @param staffDepartment
     * @param userCode
     * @param staffCatCode
     * @param userFacultyCode
     * @param staffGender
     * @param staffDateOfBirth
     */
    public void editAStaff(int StaffId, String staffName, String staffEmail, String staffPhone, String staffDepartment, 
    						String userCode, String staffCatCode, String userFacultyCode, String staffGender, String staffDateOfBirth, String academicRank);
    
    /**
     * 
     * @param staffName
     * @param staffEmail
     * @param staffPhone
     * @param staffDepartment
     * @param userCode
     * @param staffCatCode
     * @param staffFaculty
     * @return
     */
    public int saveAStaff(String staffName, String staffEmail, String staffPhone, 
    						String staffDepartment, String userCode, String staffCatCode, String staffFaculty);
}
