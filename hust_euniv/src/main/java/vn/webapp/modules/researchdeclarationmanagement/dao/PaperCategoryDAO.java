package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.List;
import vn.webapp.modules.researchdeclarationmanagement.model.PaperCategory;

public interface PaperCategoryDAO {
	/**
	 * 
	 * @return
	 */
	public List<PaperCategory> getList();
    
	/**
	 * 
	 * @param paperCateCode
	 * @return
	 */
    public PaperCategory getPaperCateByCode(String paperCateCode);
}
