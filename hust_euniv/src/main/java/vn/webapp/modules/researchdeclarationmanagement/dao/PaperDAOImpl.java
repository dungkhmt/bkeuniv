package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.webapp.modules.researchdeclarationmanagement.model.Papers;

@Repository("paperDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class PaperDAOImpl implements PaperDAO{
	@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(Papers.class);
    
    /**
     * Get department list
     * @param null
     * @return List
     */
    @Override
    public List<Papers> listAll() {
        try {
        	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        	criteria.addOrder(Order.desc("papers.PDECL_ID"));
            List<Papers> papers = criteria.list();            
            return papers;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
    }
    
    public List<Papers> loadPaperListByAuthor(String authorCode) {
    	
    	 try {
    		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class, "p");         	
         	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
         	.createAlias("p.authors", "authors")
         	.add(Restrictions.eq("authors.Staff_Code", authorCode))
         	.addOrder(Order.desc("p.PDECL_ID"))         	
         	.list();
         	
            List<Papers> papers = criteria.list();            
            return papers;
         } catch (HibernateException e) {
         	logger.error(e.getMessage());
         	return null;
         }
    	
    }

    /**
     * 
     */
    @Override
    public List<Papers> loadPaperListByStaff(String userRole, String userCode) {
        try {
        	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
        	//if(!userRole.equals("ROLE_ADMIN")){
            	criteria.add(Restrictions.eq("papers.PDECL_User_Code", userCode));
            //}
            criteria.addOrder(Order.desc("papers.PDECL_ID"));
            List<Papers> papers = criteria.list();            
            return papers;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
    }
    
    /**
     * 
     */
    @Override
    public List<Papers> loadPaperListSummary(String paperStaff, String paperCategory, String paperAcademicYear) {
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        	
            if(paperStaff != null && (!"".equals(paperStaff))){
            	criteria.add(Restrictions.eq("PDECL_User_Code", paperStaff));
            }
            if(paperCategory != null && (!"".equals(paperCategory))){
            	criteria.add(Restrictions.eq("PDECL_PaperCategory_Code", paperCategory));
            }
            
            if(paperAcademicYear != null && (!"".equals(paperAcademicYear))){
            	criteria.add(Restrictions.eq("PDECL_ReportingAcademicDate", paperAcademicYear));
            }
            criteria.addOrder(Order.desc("PDECL_ID"));
            List<Papers> papers = criteria.list();
            return papers;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
    }
    
    /**
     * Get papers list by year and user
     * @param null
     * @return List
     */
    @Override
    public List<Papers> loadPaperListByYear(String userRole, String userCode, String reportingrYear){
    	try {
    		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    		if(!userRole.equals("SUPER_ADMIN")){
            	criteria.add(Restrictions.eq("papers.PDECL_User_Code", userCode));
            }
            criteria.add(Restrictions.eq("papers.PDECL_ReportingAcademicDate", reportingrYear));
            criteria.addOrder(Order.asc("papers.PDECL_PublicationName"));
            List<Papers> papers = criteria.list();            
            return papers;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        }
    }
    
    /**
     * Get papers list by year
     * @param null
     * @return List
     */
    @Override
    public List<Papers> loadPaperSummaryListByYear(String reportingrYear){
    	try {
    		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    		criteria.add(Restrictions.eq("papers.PDECL_ReportingAcademicDate", reportingrYear));
            criteria.addOrder(Order.asc("papers.PDECL_PublicationName"));
            List<Papers> papers = criteria.list();
            return papers;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
    }
    
    /**
     * Save a paper
     * @param object
     * @return int
     */
    @Override
    public void saveAPaper(Papers paper) 
    {
        try {
        	Session session = this.sessionFactory.getCurrentSession();
			session.persist(paper);		
		} catch (HibernateException e) {
			logger.error(e.getMessage());			
		} 
        
    }
    
    /**
     * Load A Paper by id and User code
     * @param object
     * @return int
     */
    @Override
    public Papers loadAPaperByIdAndUserCode(String userRole, String userCode, int paperId){
    	try {
    		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    		criteria.add(Restrictions.eq("PDECL_ID", paperId));
            //if(!userRole.equals("ROLE_ADMIN")){
            	criteria.add(Restrictions.eq("PDECL_User_Code", userCode));
            //}
            Papers paper = (Papers) criteria.uniqueResult();
            return paper;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
    }
    
    /**
     * 
     */
    @Override
    public Papers loadAPaperById(int paperId){
    	try {
    		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Papers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    		criteria.add(Restrictions.eq("PDECL_ID", paperId));
            Papers paper = (Papers) criteria.uniqueResult();
            return paper;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        }
    }

    public String name(){
    	return "mPaperDAOImpl";
    }
    /**
     * Edit a paper
     * @param object
     * @return int
     */
    @Override
    public void editAPaper(Papers paper){
    	System.out.println(name() + "::editAPaper, paperId = " + paper.getPDECL_ID() + ", userCode = " + paper.getPDECL_User_Code());
        try {
        	sessionFactory.getCurrentSession().update(paper);           
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
		} 
    }
    
    /**
     * Remove a paper
     * @param paperId
     * @return
     */
    @Override
    public void removeAPaper(int paperId){
    	//mPapers paper = new mPapers();
    	//paper.setPDECL_ID(paperId);
    	Papers paper = loadAPaperById(paperId);
        try {
        	sessionFactory.getCurrentSession().delete(paper);        	
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        }
    }
}
