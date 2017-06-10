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

import vn.webapp.modules.researchdeclarationmanagement.model.AcademicYear;
import vn.webapp.modules.researchdeclarationmanagement.model.PaperCategory;

@Repository("paperCategoryDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class PaperCategoryDAOImpl implements PaperCategoryDAO {
	/**
     * Get all list Paper Category
     * @param null
     * @return List
     */
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(PaperCategory.class);
	
	@Override
    public List<PaperCategory> getList(){
    	try {
    		Session session = this.sessionFactory.getCurrentSession();            
            Criteria criteria = session.createCriteria(PaperCategory.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.setFirstResult(0);
            List<PaperCategory> paperCategory = criteria.list();
            return paperCategory;
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    
	/**
     * Get a paper category by code
     * @param String
     * @return object
     */
	@Override
    public PaperCategory getPaperCateByCode(String paperCateCode){
    	try {
    		Session session = this.sessionFactory.getCurrentSession();            
            Criteria criteria = session.createCriteria(PaperCategory.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
            criteria.add(Restrictions.eq("paperCategory.PCAT_Code", paperCateCode));
            PaperCategory paperCategory = (PaperCategory) criteria.uniqueResult();
            return paperCategory;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        } 
    }
}
