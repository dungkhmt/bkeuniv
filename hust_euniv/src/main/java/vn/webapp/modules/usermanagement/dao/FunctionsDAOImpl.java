/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : October 13th, 2015
 */
package vn.webapp.modules.usermanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.webapp.modules.usermanagement.model.Function;
import vn.webapp.modules.usermanagement.model.Role;
import vn.webapp.modules.usermanagement.model.User;

@Repository("functionsDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class FunctionsDAOImpl implements FunctionsDAO{
	@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private static final Logger logger = LoggerFactory.getLogger(Function.class);

    /**
     * Get functions list
     * @param null
     * @return List
     */
    
    
    
    @Override
    public List<Function> loadFunctionsList(){
        try {
        	Session session = this.sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Function.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<Function> funcsList = criteria.list();            
            return funcsList;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());           
            return null;
        }
    }
    
    /**
     * Get functions list
     * @param null
     * @return List
     */
    @Override
    public List<Function> loadFunctionsParentHierachyList(){
        try {
        	Session session = this.sessionFactory.getCurrentSession();            
            Criteria criteria = session.createCriteria(Function.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.eq("FUNC_PARENTID", 0));
            criteria.addOrder(Order.asc("FUNC_INDEX"));
            List<Function> funcsList = criteria.list();            
            return funcsList;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        } 
    }
    
    /**
     * Get functions list
     * @param null
     * @return List
     */
    @Override
    public List<Function> loadFunctionsChildHierachyList(){
        try {
        	Session session = this.sessionFactory.getCurrentSession();            
            Criteria criteria = session.createCriteria(Function.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.gt("FUNC_PARENTID", 0));
            criteria.addOrder(Order.asc("FUNC_INDEX"));
            List<Function> funcsList = criteria.list();            
            return funcsList;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
            return null;
        } 
    }
    
    public List<Function> loadFunctionsListByUser(String Usercode){
		
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Function.class, "f");         	
         	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
         	.createAlias("f.users", "users")
         	.add(Restrictions.eq("users.User_Code", Usercode));
         	         	
            List<Function> functions = criteria.list();            
            return functions;
         } catch (HibernateException e) {
         	logger.error(e.getMessage());
         	return null;
         }
		
	}
    
    public List<Function> loadFunctionsParentHierachyList(String Usercode){
    	try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Function.class, "f");         	
         	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
         	.addOrder(Order.asc("f.FUNC_INDEX"))
         	.createAlias("f.users", "users")
         	.add(Restrictions.eq("f.FUNC_PARENTID", 0))            
         	.add(Restrictions.eq("users.User_Code", Usercode));         	
         	         	
            List<Function> functions = criteria.list();            
            return functions;
         } catch (HibernateException e) {
         	logger.error(e.getMessage());
         	return null;
         }
    }
	
	public List<Function> loadFunctionsChildHierachyList(String Usercode){
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Function.class, "f");         	
         	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
         	.addOrder(Order.asc("f.FUNC_INDEX"))
         	.createAlias("f.users", "users")
         	.add(Restrictions.gt("f.FUNC_PARENTID", 0))            
         	.add(Restrictions.eq("users.User_Code", Usercode));  
         	
            List<Function> functions = criteria.list();            
            return functions;
         } catch (HibernateException e) {
         	logger.error(e.getMessage());
         	return null;
         }
	}
	
	public String loadCodeByFunctionUrl(String Func_Url){
		try {
			
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(
					"select FUNC_CODE from tblfunctions s where s.FUNC_URL = :Func_Url")
					.setParameter("Func_Url", Func_Url);
			String result = (String)query.uniqueResult();
			return result;
				
         } catch (HibernateException e) {
         	logger.error(e.getMessage());
         	return null;
         }
	}

}
