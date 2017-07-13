package vn.webapp.util;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class Base {

    @Autowired
    private SessionFactory sessionFactory;
    private static final ThreadLocal THREAD = new ThreadLocal();
	
	
	
	/*
	 * @param JSONObject<JSONObject||JSONArray<OR>>
	 */
	public static Criteria addRestrictions(Criteria criteria, JSONObject field) {
		Set<String> keys = field.keySet();
		for(String k: keys) {
			if(field.get(k) instanceof JSONObject) {
				criteria = addRestrictions(criteria, (JSONObject)field.get(k));
			} else {
				if(field.get(k) instanceof JSONArray) {
					JSONArray JSONArr = (JSONArray) field.get(k);
					for(int i = 0, len = JSONArr.size(); i < len; ++i) {
						criteria = addRestrictions(criteria, (JSONObject)JSONArr.get(i));
					}
				} else {
					if(field.get(k) instanceof String) {
						criteria.add(Restrictions.eq(k, field.get(k).toString()));
					} else {
						if(field.get(k) instanceof Integer) {
							criteria.add(Restrictions.eq(k, (Integer)field.get(k)));
						}
					}
				}
			}
		}
		return criteria;
	}
	
	public Session getSession() {
        Session session = (Session) this.THREAD.get();
        if (session == null) {
            session = sessionFactory.openSession();
            this.THREAD.set(session);
            getSession().setFlushMode(FlushMode.COMMIT);
        }
        return session;
    }
	
}
