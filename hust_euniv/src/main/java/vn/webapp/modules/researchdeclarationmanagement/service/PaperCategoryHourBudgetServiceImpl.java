package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.webapp.modules.researchdeclarationmanagement.dao.PaperCategoryHourBudgetDAO;
import vn.webapp.modules.researchdeclarationmanagement.model.PapersCategoryHourBudget;

@Service("paperCategoryHourBudgetService")
public class PaperCategoryHourBudgetServiceImpl implements PaperCategoryHourBudgetService{
	@Autowired
    private PaperCategoryHourBudgetDAO paperCategoryHourBudgetDAO;
 
	
	/**
     * 
     */
    @Override
    public List<PapersCategoryHourBudget> loadPaperCategoryHourBudgets(){
    	return paperCategoryHourBudgetDAO.loadPaperCategoryHourBudgets();
    }
    
    /**
     * 
     */
    @Override
    public List<PapersCategoryHourBudget> loadPaperCategoryHourBudgetByYear(String reportingrYear){
    	if(!"".equals(reportingrYear)){
    		return paperCategoryHourBudgetDAO.loadPaperCategoryHourBudgetByYear(reportingrYear);
    	}
    	return null;
    }
	
    /**
     * 
     */
    @Override
	public PapersCategoryHourBudget loadPaperCategoryHourBudgetByCategoryAndYear(String paperCategoryCode, String reportingrYear){
    	if( !("".equals(paperCategoryCode)) || !("".equals(reportingrYear)) ){
    		return paperCategoryHourBudgetDAO.loadPaperCategoryHourBudgetByCategoryAndYear(paperCategoryCode, reportingrYear);
    	}
    	return null;
    }
    
    /**
     * 
     */
    @Override
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetByCode(String code){
    	if(!"".equals(code)){
    		return paperCategoryHourBudgetDAO.loadPaperCategoryHourBudgetByCode(code);
    	}
    	return null;
    }
    
    /**
     * 
     */
    @Override
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetById(int id){
    	if(id > 0){
    		return paperCategoryHourBudgetDAO.loadPaperCategoryHourBudgetById(id);
    	}
    	return null;
    }
}
