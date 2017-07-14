package vn.webapp.modules.researchdeclarationmanagement.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.webapp.modules.researchdeclarationmanagement.model.PaperCategory;
import vn.webapp.modules.researchdeclarationmanagement.model.Papers;
import vn.webapp.modules.researchdeclarationmanagement.model.Staff;
import vn.webapp.modules.usermanagement.model.User;
import vn.webapp.util.Base;

@Repository("StaffDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class StaffDAOImpl extends Base implements StaffDAO {
	@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(Staff.class);
	
	@Override
	public List<Staff> listStaffs() {
		try {
        	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Staff.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<Staff> staffs = criteria.list();            
            return staffs;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        }
	}

	@Override
	public List<Staff> listStaffByFields(JSONObject field) {
		try {
			Session session = getSession(); 
			Criteria criteria = session.createCriteria(Staff.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			addRestrictions(criteria, field, Staff.class);
			
            List<Staff> list = criteria.list();
            return list;
        } catch (HibernateException e) {
        	logger.error(e.getMessage());
        	return null;
        } 
	}
	
	@Override
	public void editAStaff(Staff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveAStaff(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAStaff(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
