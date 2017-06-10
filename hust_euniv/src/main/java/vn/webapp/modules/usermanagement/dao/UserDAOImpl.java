package vn.webapp.modules.usermanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.webapp.modules.usermanagement.model.User;

@Repository("userDAO")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	public List<User> getList(){
		
		try {
			Session session = this.sessionFactory.getCurrentSession();			
			Criteria criteria = session.createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<User> candidates = criteria.list();			
			return candidates;
		} catch (HibernateException e) {
			logger.error(e.getMessage());			
			return null;
		}		
	}
	
	public User getByID(int id){		
		try {			
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("id", id));
			User candidate = (User)criteria.uniqueResult();			
			return candidate;
		} catch (HibernateException e) {
			logger.error(e.getMessage());			
			return null;
		}		
	}	
	
	@Override
	public User getByUsernameAndPassword(String username, String password) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("Username", username));
			criteria.add(Restrictions.eq("Password", password));
			User candidate = (User)criteria.uniqueResult();			
			return candidate;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	@Override
	public User getByUsername(String username) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(
					"select * from tblusers s where s.Username = :Username")
					.addEntity(User.class)
					.setParameter("Username", username);
			User result = (User)query.uniqueResult();
			return result;
		} catch (HibernateException e) {
			logger.error(e.getMessage());			
			return null;
		}
	}

	public void save(User user) {		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(user);		
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			
		} 
	}
	public void delete(User user) {		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(user);	
		} catch (HibernateException e) {
			logger.error(e.getMessage());
		} 
	}
}
