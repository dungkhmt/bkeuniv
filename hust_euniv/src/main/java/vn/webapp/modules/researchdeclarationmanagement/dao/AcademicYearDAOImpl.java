package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.webapp.modules.researchdeclarationmanagement.model.AcademicYear;
import vn.webapp.modules.usermanagement.model.Role;

@Repository("academicYearDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class AcademicYearDAOImpl implements AcademicYearDAO{
	/**
     * Get all list Staff Category
     * @param null
     * @return List
     */
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final Logger logger = LoggerFactory.getLogger(AcademicYear.class);
	
    public List<AcademicYear> getList(){
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(AcademicYear.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
            criteria.setFirstResult(0);
            List<AcademicYear> academicYear = criteria.list();
            return academicYear;
        } catch (HibernateException e) {
    		logger.error(e.getMessage());    		
            return null;
        } 
    };
}
