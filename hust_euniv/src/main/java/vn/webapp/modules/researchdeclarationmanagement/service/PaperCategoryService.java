package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import vn.webapp.modules.researchdeclarationmanagement.model.PaperCategory;

public interface PaperCategoryService {
	/**
	 * 
	 * @return
	 */
	public List<PaperCategory> list();
    
	/**
	 * 
	 * @param paperCateCode
	 * @return
	 */
    public PaperCategory getPaperCateByCode(String paperCateCode);
}
