package vn.webapp.modules.usermanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.webapp.modules.usermanagement.model.Role;

@Repository("roleDAO")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RoleDAOImpl implements RoleDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(Role.class);
	
	public List<Role> getList(){
		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Role> candidates = criteria.list();			
			return candidates;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			return null;
		} 	
	}
	
	public Role getByName(String name){
		
		try {
			Session session = this.sessionFactory.getCurrentSession();			
			Criteria criteria = session.createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("name", name));
			Role candidate = (Role)criteria.uniqueResult();			
			return candidate;
		} catch (HibernateException e) {
			logger.error(e.getMessage());			
			return null;
		}		
	}
	
	public List<Role> getByUser(String Username){
		
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class, "role");         	
         	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
         	.createAlias("role.users", "users")
         	.add(Restrictions.eq("users.Username", Username));
         	         	
            List<Role> roles = criteria.list();            
            return roles;
         } catch (HibernateException e) {
         	logger.error(e.getMessage());
         	return null;
         }
		
	}
	
	
}
