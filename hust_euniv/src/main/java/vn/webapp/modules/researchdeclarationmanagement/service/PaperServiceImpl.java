package vn.webapp.modules.researchdeclarationmanagement.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.webapp.modules.researchdeclarationmanagement.dao.PaperDAO;
import vn.webapp.modules.researchdeclarationmanagement.model.Papers;
import vn.webapp.modules.usermanagement.dao.UserDAO;
import vn.webapp.modules.usermanagement.model.User;

@Service("paperService")
public class PaperServiceImpl implements PaperService{
	@Autowired
    private PaperDAO paperDAO;

    @Autowired
    private UserDAO userDAO;
        
    /**
     * Get a list Papers by username
     * @param String
     * @return object
     * @throws UsernameNotFoundException
     */
//    @Override
//    @Transactional
//    public List<Papers> loadPaperListByStaffYear(String userCode, String year) {
//        try {
//        	List<Papers> papers = paperDAO.loadPaperSummaryListByYear(year);
//        	ArrayList<Papers> retList = new ArrayList<Papers>();
//        	for(Papers p: papers){
//        		String paperCode = p.getPDECL_Code();
//        		List<PaperStaffs> paperStaffs = paperStaffsDAO.loadPaperListByPaperCode(paperCode);
//        		for(PaperStaffs ps: paperStaffs){
//        			if(ps.getPPSTF_StaffCode().equals(userCode)){
//        				retList.add(p);
//        			}
//        		}
//        	}
//        	return retList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        	return null;
//        }
//    }
//    
//    /**
//     * 
//     */
    @Override
    @Transactional
    public List<Papers> loadPaperListByAuthor(String authorCode) {
        try {
        	List<Papers> papers = paperDAO.loadPaperListByAuthor(authorCode);
        	return papers;
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }
//    
//    /**
//     * 
//     */
//    @Override
//    @Transactional
//    public List<Papers> loadPaperListSummary(String paperStaff, String paperCategory, String paperAcademicYear) {
//        try {
//        	return paperDAO.loadPaperListSummary(paperStaff, paperCategory, paperAcademicYear);
//        } catch (Exception e) {
//            e.printStackTrace();
//        	return null;
//        }
//    }
//    
//    /**
//     * Get a list Papers by year
//     * @param String
//     * @return object
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    @Transactional
//    public List<Papers> loadPaperListByYear(String userRole, String currentUserCode, String reportingrYear){
//    	try {
//    		
//    		List<Papers> papers = paperDAO.loadPaperSummaryListByYear(reportingrYear);
//    		List<Papers> retList = new ArrayList<Papers>();
//    		for(Papers p: papers){
//    			String paperCode = p.getPDECL_Code();
//    			List<PaperStaffs> paperStaffs = paperStaffsDAO.loadPaperListByPaperCode(paperCode);
//    			for(PaperStaffs ps: paperStaffs){
//    				if(ps.getPPSTF_StaffCode().equals(currentUserCode)){
//    					retList.add(p);
//    				}
//    			}
//    		}
//    		return retList;
//        } catch (Exception e) {
//        	e.printStackTrace();
//            return null;
//        }
//    }
//    
//    /**
//     * Get a list Papers Summary by year
//     * @param String
//     * @return object
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    @Transactional
//    public List<Papers> loadPaperSummaryListByYear(String reportingrYear){
//    	try {
//        	if(reportingrYear != null){
//        		return paperDAO.loadPaperSummaryListByYear(reportingrYear);
//        	}
//        	return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        	return null;
//        }
//    }
//    
//    /**
//     * Save a paper
//     * @param String
//     * @param String
//     * @param String
//     * @param String
//     * @return int
//     */
//    @Override
//    @Transactional
//    public int saveAPaper(String currentUserName, String paperCatCode, String paperPubName, String paperJConfName, String paperISSN, int paperPubConHours, int paperAutConHours, int paperYear, String paperJIndexCode, 
//    						String paperVolumn, String paperAuthors, String paperReportingAcademicDate, String paperSourceUploadFile, String[] projectMembers, String ApproveStatus, String paperMonth)
//    {
//    	User user = userDAO.getByUsername(currentUserName);
//    	if(user.getUser_Code()  != null){
//    		Papers paper = new Papers();
//            paper.setPDECL_PaperCategory_Code(paperCatCode);
//            paper.setPDECL_User_Code(user.getUser_Code());
//            paper.setPDECL_Code("DEFAULT_CODE");
//            paper.setPDECL_PublicationName(paperPubName);
//            paper.setPDECL_JournalConferenceName(paperJConfName);
//            paper.setPDECL_Volumn(paperVolumn);
//            paper.setPDECL_Year(paperYear);
//            paper.setPDECL_ISSN(paperISSN);
//            paper.setPDECL_IndexCode(paperJIndexCode);
//            paper.setPDECL_PublicationConvertedHours(paperPubConHours);
//            paper.setPDECL_AuthorConvertedHours(paperAutConHours);
//            paper.setPDECL_AuthorList(paperAuthors);
//            paper.setPDECL_ReportingAcademicDate(paperReportingAcademicDate);
//            paper.setPDECL_SourceFile(paperSourceUploadFile);
//            paper.setPDECL_ApproveStatus(ApproveStatus);
//            paper.setPDECL_Month(paperMonth);
//            int i_SaveAPaper = paperDAO.saveAPaper(paper);
//            
//            if(i_SaveAPaper > 0 && projectMembers.length > 0){
//            	String PPSTF_PaperCode = user.getUser_Code()+i_SaveAPaper;
//            	String PPSTF_Code = "";
//            	paper.setPDECL_Code(PPSTF_PaperCode);
//            	paperDAO.editAPaper(paper);
//            	
//            	PaperStaffs paperStaffs = new PaperStaffs();
//	            for (String projectMember : projectMembers) {
//	            	PPSTF_Code = projectMember+PPSTF_PaperCode;
//	            	paperStaffs.setPPSTF_Code(PPSTF_Code);
//	            	paperStaffs.setPPSTF_PaperCode(PPSTF_PaperCode);
//	            	paperStaffs.setPPSTF_StaffCode(projectMember);
//		    	    paperStaffsDAO.saveAPaperStaff(paperStaffs);
//		    	}
//            }
//            
//            return i_SaveAPaper;
//    	}
//        return 0;
//    }
//    
//    /**
//     * load a paper by usercode and it's id
//     * @param String
//     * @param int
//     * @return object
//     */
//    @Override
//    @Transactional
//    public Papers loadAPaperByIdAndUserCode(String userRole, String userCode, int paperId){
//    	try {
//    		return paperDAO.loadAPaperByIdAndUserCode(userRole, userCode, paperId);
//    	} catch (Exception e) {
//            e.printStackTrace();
//    		return null;
//        }
//    }
//    
//    /**
//     * 
//     */
//    @Override
//    @Transactional
//    public Papers loadAPaperById(int paperId){
//    	try {
//    		return paperDAO.loadAPaperById(paperId);
//    	} catch (Exception e) {
//            e.printStackTrace();
//    		return null;
//        }
//    }
//    
//    
//    /**
//     * Edit a paper
//     * @param String
//     * @param int
//     * @return null
//     */
//    
//    /*
//    @Override
//    @Transactional
//    public void editAPaper(String userRole, String userCode, int paperId, String paperCate, String publicationName, String journalName, String ISSN, int publicConvertedHours, int authorConvertedHours, int paperYear, 
//    						String volumn, String authors, String journalIndex, String paperReportingAcademicDate, String paperSourceUploadFile, String[] projectMembers, String paperMonth ){
//    	Papers paper = paperDAO.loadAPaperByIdAndUserCode(userRole, userCode, paperId);
//    	if(paper != null){
//	    	paper.setPDECL_ID(paperId);;
//	    	paper.setPDECL_PaperCategory_Code(paperCate);;
//	    	paper.setPDECL_AuthorConvertedHours(authorConvertedHours);
//	    	paper.setPDECL_ISSN(ISSN);
//	    	paper.setPDECL_PublicationConvertedHours(publicConvertedHours);
//	    	paper.setPDECL_User_Code(userCode);
//	    	paper.setPDECL_Volumn(volumn);
//	    	paper.setPDECL_Year(paperYear);
//	    	paper.setPDECL_JournalConferenceName(journalName);
//	    	paper.setPDECL_IndexCode(journalIndex);
//	    	paper.setPDECL_PublicationName(publicationName);
//	    	paper.setPDECL_AuthorList(authors);
//	    	paper.setPDECL_ReportingAcademicDate(paperReportingAcademicDate);
//	    	paper.setPDECL_Month(paperMonth);
//	    	if(paperSourceUploadFile.equals(""))
//	    	{
//	    		paper.setPDECL_SourceFile(paper.getPDECL_SourceFile());
//	    	}else{
//	    		
//	    		String sOldSourceFile = paper.getPDECL_SourceFile();
//		   		if((sOldSourceFile != null)){
//		   			File oldFile = new File(sOldSourceFile);
//			   		oldFile.delete();
//		   		}
//		   		paper.setPDECL_SourceFile(paperSourceUploadFile);
//	    	}
//	    	paperDAO.editAPaper(paper);
//	    	
//	    	if(projectMembers.length > 0){
//	    		String PPSTF_PaperCode = paper.getPDECL_Code();
//	    		String PPSTF_Code = "";
//	    		List<PaperStaffs> oldPaperStaffsList = paperStaffsDAO.loadPaperListByPaperCode(PPSTF_PaperCode);
//	    		if(oldPaperStaffsList != null && oldPaperStaffsList.size() > 0)
//	    		{
//	    			for (PaperStaffs paperStaff : oldPaperStaffsList) {
//	    				paperStaffsDAO.removeAPaperStaff(paperStaff);
//					}
//	    		}
//		    	PaperStaffs paperStaffs = new PaperStaffs();
//	            for (String projectMember : projectMembers) {
//	            	PPSTF_Code = projectMember+PPSTF_PaperCode;
//	            	paperStaffs.setPPSTF_Code(PPSTF_Code);
//	            	paperStaffs.setPPSTF_PaperCode(PPSTF_PaperCode);
//	            	paperStaffs.setPPSTF_StaffCode(projectMember);
//		    	    paperStaffsDAO.saveAPaperStaff(paperStaffs);
//		    	}
//	    	}
//    	}
//    }
//	*/
//    
//    public String name(){
//    	return "PaperService";
//    }
//    /**
//     * 
//     */
//    
//    
//    @Override
//    @Transactional
//    public void editAPaper(int paperId, String paperCate, String publicationName, String journalName, String ISSN, int publicConvertedHours, int authorConvertedHours, int paperYear, 
//    						String volumn, String authors, String journalIndex, String paperReportingAcademicDate, String paperSourceUploadFile, String[] projectMembers, String paperMonth ){
//    	Papers paper = paperDAO.loadAPaperById(paperId);
//    	if(paper != null){
//	    	paper.setPDECL_ID(paperId);;
//	    	paper.setPDECL_PaperCategory_Code(paperCate);;
//	    	paper.setPDECL_AuthorConvertedHours(authorConvertedHours);
//	    	paper.setPDECL_ISSN(ISSN);
//	    	paper.setPDECL_PublicationConvertedHours(publicConvertedHours);
//	    	paper.setPDECL_Volumn(volumn);
//	    	paper.setPDECL_Year(paperYear);
//	    	paper.setPDECL_JournalConferenceName(journalName);
//	    	paper.setPDECL_IndexCode(journalIndex);
//	    	paper.setPDECL_PublicationName(publicationName);
//	    	paper.setPDECL_AuthorList(authors);
//	    	paper.setPDECL_ReportingAcademicDate(paperReportingAcademicDate);
//	    	paper.setPDECL_Month(paperMonth);
//	    	if(paperSourceUploadFile.equals(""))
//	    	{
//	    		paper.setPDECL_SourceFile(paper.getPDECL_SourceFile());
//	    	}else{
//	    		
//	    		String sOldSourceFile = paper.getPDECL_SourceFile();
//		   		if((sOldSourceFile != null)){
//		   			File oldFile = new File(sOldSourceFile);
//			   		oldFile.delete();
//		   		}
//		   		paper.setPDECL_SourceFile(paperSourceUploadFile);
//	    	}
//	    	paperDAO.editAPaper(paper);
//	    	
//	    	if(projectMembers.length > 0){
//	    		String PPSTF_PaperCode = paper.getPDECL_Code();
//	    		String PPSTF_Code = "";
//	    		List<PaperStaffs> oldPaperStaffsList = paperStaffsDAO.loadPaperListByPaperCode(PPSTF_PaperCode);
//	    		System.out.println(name() + "::editAPaper, paperCode = " + PPSTF_PaperCode + 
//	    				", list of related staffs = " + oldPaperStaffsList.size() + ", projectMembers.length = " + projectMembers.length);
//	    		if(oldPaperStaffsList != null && oldPaperStaffsList.size() > 0)
//	    		{
//	    			for (PaperStaffs paperStaff : oldPaperStaffsList) {
//	    				paperStaffsDAO.removeAPaperStaff(paperStaff);
//	    				System.out.println(name() + "::editAPaper, remove paperStaff " + paperStaff.getPPSTF_Code() + ", paperCode = " + paperStaff.getPPSTF_PaperCode());
//					}
//	    		}
//		    	PaperStaffs paperStaffs = new PaperStaffs();
//	            for (String projectMember : projectMembers) {
//	            	PPSTF_Code = projectMember+PPSTF_PaperCode;
//	            	paperStaffs.setPPSTF_Code(PPSTF_Code);
//	            	paperStaffs.setPPSTF_PaperCode(PPSTF_PaperCode);
//	            	paperStaffs.setPPSTF_StaffCode(projectMember);
//		    	    paperStaffsDAO.saveAPaperStaff(paperStaffs);
//		    	    System.out.println(name() + "::editAPaper, member " + projectMember + ", addPaperStaff with paperCode " + paperStaffs.getPPSTF_PaperCode() + 
//		    	    		", staff = " + paperStaffs.getPPSTF_StaffCode()); 
//		    	}
//	    	}
//    	}
//    }
//    
//    /**
//     * Remove a paper
//     * @param int
//     * @return int
//     */
//    @Override
//    @Transactional
//    public void removeAPaper(int paperId){
//    	paperDAO.removeAPaper(paperId);
//    }
}
