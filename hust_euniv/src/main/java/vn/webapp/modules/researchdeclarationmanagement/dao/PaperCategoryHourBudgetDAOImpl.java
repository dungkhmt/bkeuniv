package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.webapp.modules.researchdeclarationmanagement.model.PapersCategoryHourBudget;

@Repository("paperCategoryHourBudgetDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class PaperCategoryHourBudgetDAOImpl implements PaperCategoryHourBudgetDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(PapersCategoryHourBudget.class);
    
    /**
     * 
     * @param null
     * @return List
     */
    @Override
    public List<PapersCategoryHourBudget> loadPaperCategoryHourBudgets(){
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(PapersCategoryHourBudget.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<PapersCategoryHourBudget> paperCategoryBudget = criteria.list();
            return paperCategoryBudget;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     * @param null
     * @return List
     */
    @Override
    public List<PapersCategoryHourBudget> loadPaperCategoryHourBudgetByYear(String reportingrYear)
    {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();            
            Criteria criteria = session.createCriteria(PapersCategoryHourBudget.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.eq("paperCategoryBudget.PCAHOBUD_AcademicYearCode", reportingrYear));
            List<PapersCategoryHourBudget> paperCategoryBudget = criteria.list();            
            return paperCategoryBudget;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
    }
    
    /**
     * 
     * @param null
     * @return List
     */
    @Override
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetByCategoryAndYear(String paperCategoryCode, String reportingrYear){
        try {
        	Session session = this.sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(PapersCategoryHourBudget.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.eq("paperCategoryBudget.PCAHOBUD_PaperCategoryCode", paperCategoryCode));
            criteria.add(Restrictions.eq("paperCategoryBudget.PCAHOBUD_AcademicYearCode", reportingrYear));
            PapersCategoryHourBudget paperCategoryBudget = (PapersCategoryHourBudget) criteria.uniqueResult();            
            return paperCategoryBudget;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        } 
    }
    
    /**
     * 
     */
    @Override
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetByCode(String code){
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(PapersCategoryHourBudget.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.eq("paperCategoryBudget.PCAHOBUD_Code", code));
            PapersCategoryHourBudget paperCategoryBudget = (PapersCategoryHourBudget) criteria.uniqueResult();            
            return paperCategoryBudget;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     */
    @Override
    public PapersCategoryHourBudget loadPaperCategoryHourBudgetById(int id){
    	try {
    		Session session = this.sessionFactory.getCurrentSession();            
            Criteria criteria = session.createCriteria(PapersCategoryHourBudget.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.eq("paperCategoryBudget.PCAHOBUD_ID", id));
            PapersCategoryHourBudget paperCategoryBudget = (PapersCategoryHourBudget) criteria.uniqueResult();            
            return paperCategoryBudget;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        } 
    }

}
