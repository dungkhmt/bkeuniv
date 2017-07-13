package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.webapp.modules.researchdeclarationmanagement.dao.StaffDAO;
import vn.webapp.modules.researchdeclarationmanagement.model.Staff;

@Service("StaffService")
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDAO staffDAO;
    
    /**
     * Get staff list
     * @param String
     * @return object
     */
    @Override
    @Transactional
    public List<Staff> listStaffs(){
    	try {
            return staffDAO.listStaffs();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Edit a staff
     * @param String
     * @return Interger
     */
    @Override
    @Transactional
    public void editAStaff(int StaffId, String staffName, String staffEmail, String staffPhone, String staffDepartment, 
    						String userCode, String staffCatCode, String userFacultyCode, String staffGender, String staffDateOfBirth, String academicRank){
    	
    	Staff staff = new Staff();
    	staff.setStaff_Department_Code(staffDepartment);
    	staff.setStaff_AsciiName(staffName);
    	staff.setStaff_Name(staffName);
    	staff.setStaff_Phone(staffPhone);
    	staff.setStaff_User_Code(userCode);
    	staff.setStaff_Category_Code(staffCatCode);
    	staff.setStaff_Email(staffEmail);
    	staff.setStaff_Code(userCode);
    	staff.setStaff_ID(StaffId);
    	staff.setStaff_Faculty_Code(userFacultyCode);
    	staff.setStaff_Gender(staffGender);
    	staff.setStaff_DateOfBirth(staffDateOfBirth);
    	//staff.setAcademicRank(academicRank);
    	staff.setStaff_AcademicRank(academicRank);
    	//System.out.println("mStaffService::editAStaff, academicRank = " + staff.getAcademicRank().getAcademicRank_Code());
    	
    	staffDAO.editAStaff(staff);
    }
    
    /**
     * Save a staff
     * @param String
     * @return int
     */
    @Override
    @Transactional
    public int saveAStaff(String staffName, String staffEmail, String staffPhone, 
    						String staffDepartment, String userCode, String staffCatCode, String staffFaculty){
    	
    	Staff staff = new Staff();
    	staff.setStaff_Department_Code(staffDepartment);
    	staff.setStaff_AsciiName(staffName);
    	staff.setStaff_Name(staffName);
    	staff.setStaff_Phone(staffPhone);
    	staff.setStaff_User_Code(userCode);
    	staff.setStaff_Category_Code(staffCatCode);
    	staff.setStaff_Email(staffEmail);
    	staff.setStaff_Code(userCode);
    	staff.setStaff_Faculty_Code(staffFaculty);
    	staff.setStaff_Department_Code(staffDepartment);
    	return staffDAO.saveAStaff(staff);
    }

	@Override
	public List<Staff> listStaffsByFields(JSONObject field) {

		return staffDAO.listStaffByFields(field);
	}
}
