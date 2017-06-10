package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.List;

import vn.webapp.modules.researchdeclarationmanagement.model.Papers;

public interface PaperDAO {
	/**
	 * 
	 * @param userRole
	 * @param userCode
	 * @return
	 */
	public List<Papers> listAll();
	
	public List<Papers> loadPaperListByStaff(String userRole, String userCode);
	
	public List<Papers> loadPaperListByAuthor(String authorCode);
	
	/**
	 * 
	 * @param paperStaff
	 * @param paperCategory
	 * @param paperAcademicYear
	 * @return
	 */
	public List<Papers> loadPaperListSummary(String paperStaff, String paperCategory, String paperAcademicYear);
    
	/**
	 * 
	 * @param userRole
	 * @param userCode
	 * @param reportingrYear
	 * @return
	 */
    public List<Papers> loadPaperListByYear(String userRole, String userCode, String reportingrYear);
    
    /**
     * 
     * @param reportingrYear
     * @return
     */
    public List<Papers> loadPaperSummaryListByYear(String reportingrYear);
    
    /**
     * 
     * @param paper
     * @return
     */
    public void saveAPaper(Papers paper);
    
    /**
     * 
     * @param userRole
     * @param userCode
     * @param paperId
     * @return
     */
    public Papers loadAPaperByIdAndUserCode(String userRole, String userCode, int paperId);
    
    /**
     * 
     * @param paperId
     * @return
     */
    public Papers loadAPaperById(int paperId);
    
    /**
     * 
     * @param paper
     */
    public void editAPaper(Papers paper);
    
    /**
     * 
     * @param paperId
     * @return
     */
    public void removeAPaper(int paperId);
}
