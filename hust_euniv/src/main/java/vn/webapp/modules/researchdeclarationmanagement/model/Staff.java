/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : October 14th, 2015
 */
package vn.webapp.modules.researchdeclarationmanagement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import vn.webapp.modules.usermanagement.model.User;
@Entity
@Table(name = "tblstaffs")
public class Staff implements Serializable{
	@Id
    @GeneratedValue
    private int Staff_ID;
    private String Staff_Code;
    private String Staff_Name;
    private String Staff_AsciiName;
    private String Staff_Email;
    private String Staff_Department_Code;
    private String Staff_Phone;
    private String Staff_Category_Code;
    private String Staff_User_Code;
    private String Staff_Faculty_Code;
    private String Staff_Gender;
    private String Staff_DateOfBirth;		
    private String Staff_AcademicRank;
    
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "Staff_User_Code", referencedColumnName = "User_Code",insertable = false, updatable = false)
//    private User user;
    
//    @ManyToOne
//    @JoinColumn(name="Staff_Category_Code", referencedColumnName = "Staff_Category_Code", insertable = false, updatable = false)
//    public mStaffCategory staffCategory;
    
//    @ManyToOne
//    @JoinColumn(name = "Staff_Department_Code", referencedColumnName = "Department_Code",insertable = false, updatable = false)
//    private mDepartment department;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="Staff_AcademicRank", referencedColumnName = "AcademicRank_Code", insertable=false, updatable = false)
//    public mAcademicRank academicRank;

	public int getStaff_ID() {
		return Staff_ID;
	}

	public void setStaff_ID(int staff_ID) {
		Staff_ID = staff_ID;
	}

	public String getStaff_Code() {
		return Staff_Code;
	}

	public void setStaff_Code(String staff_Code) {
		Staff_Code = staff_Code;
	}

	public String getStaff_Name() {
		return Staff_Name;
	}

	public void setStaff_Name(String staff_Name) {
		Staff_Name = staff_Name;
	}

	public String getStaff_AsciiName() {
		return Staff_AsciiName;
	}

	public void setStaff_AsciiName(String staff_AsciiName) {
		Staff_AsciiName = staff_AsciiName;
	}

	public String getStaff_Email() {
		return Staff_Email;
	}

	public void setStaff_Email(String staff_Email) {
		Staff_Email = staff_Email;
	}

	public String getStaff_Department_Code() {
		return Staff_Department_Code;
	}

	public void setStaff_Department_Code(String staff_Department_Code) {
		Staff_Department_Code = staff_Department_Code;
	}

	public String getStaff_Phone() {
		return Staff_Phone;
	}

	public void setStaff_Phone(String staff_Phone) {
		Staff_Phone = staff_Phone;
	}

	public String getStaff_Category_Code() {
		return Staff_Category_Code;
	}

	public void setStaff_Category_Code(String staff_Category_Code) {
		Staff_Category_Code = staff_Category_Code;
	}

	public String getStaff_User_Code() {
		return Staff_User_Code;
	}

	public void setStaff_User_Code(String staff_User_Code) {
		Staff_User_Code = staff_User_Code;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String getStaff_Faculty_Code() {
		return Staff_Faculty_Code;
	}

	public void setStaff_Faculty_Code(String staff_Faculty_Code) {
		Staff_Faculty_Code = staff_Faculty_Code;
	}

	public String getStaff_Gender() {
		return Staff_Gender;
	}

	public void setStaff_Gender(String staff_Gender) {
		Staff_Gender = staff_Gender;
	}

	public String getStaff_DateOfBirth() {
		return Staff_DateOfBirth;
	}

	public void setStaff_DateOfBirth(String staff_DateOfBirth) {
		Staff_DateOfBirth = staff_DateOfBirth;
	}

	public String getStaff_AcademicRank() {
		return Staff_AcademicRank;
	}

	public void setStaff_AcademicRank(String staff_AcademicRank) {
		Staff_AcademicRank = staff_AcademicRank;
	}
	
}
