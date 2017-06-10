package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import vn.webapp.modules.researchdeclarationmanagement.model.PapersCategoryHourBudget;

public interface PaperCategoryHourBudgetService {
	
	public List<PapersCategoryHourBudget> loadPaperCategoryHourBudgets();
	
	public List<PapersCategoryHourBudget> loadPaperCategoryHourBudgetByYear(String reportingrYear);
	
	public PapersCategoryHourBudget loadPaperCategoryHourBudgetByCategoryAndYear(String paperCategoryCode, String reportingrYear);
    
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetByCode(String code);
    
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetById(int id);
}
