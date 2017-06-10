package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.webapp.modules.researchdeclarationmanagement.dao.PaperCategoryDAO;
import vn.webapp.modules.researchdeclarationmanagement.model.PaperCategory;

@Service("paperCategoryService")
public class PaperCategoryServiceImpl implements PaperCategoryService{
	@Autowired
    private PaperCategoryDAO paperCategoryDAO;

    public void setPaperCategoryDAO(PaperCategoryDAO paperCategoryDAO) {
        this.paperCategoryDAO = paperCategoryDAO;
    }
    
    /**
     * Get all list Paper Category
     * @param null
     * @return List
     */
    @Override
    public List<PaperCategory> list(){
    	return paperCategoryDAO.getList();
    }
    
    /**
     * get a paper category by code
     * @param String
     * @return object
     */
    @Override
    public PaperCategory getPaperCateByCode(String paperCateCode){
    	if(paperCateCode != null){
    		return paperCategoryDAO.getPaperCateByCode(paperCateCode);
    	}
    	return null;
    }
}
