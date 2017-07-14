package vn.webapp.util;


import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
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
	public static void addRestrictions(Criteria criteria, JSONObject field, Class c) {
		Set<String> keys = field.keySet();
		for(String k: keys) {
			if(field.get(k) instanceof JSONObject) {
				addRestrictions(criteria, (JSONObject)field.get(k), c);
			} else {
				if(field.get(k) instanceof JSONArray) {
					addRestrictions(criteria, (JSONArray)field.get(k), c, k, Restrictions.disjunction());
				} else {
					criteria.add(Restrictions.eq(k, field.get(k)));
				}
			}
		}
	}
	
	/*
	 * @param JSONObject<JSONObject||JSONArray<OR>>
	 */
	public static void addRestrictions(Criteria criteria, JSONArray field, Class c, String key, Disjunction disjunction) {
		for(int i = 0, len = field.size(); i < len; ++i) {
			if(field.get(i) instanceof JSONObject) {
				JSONObject temp = (JSONObject)field.get(i);
				Set<String> keys = temp.keySet();
				for(String k: keys) {
					if(temp.get(k) instanceof JSONObject) {
						addRestrictions(criteria, (JSONObject)temp.get(k), c);
					} else {
						if(temp.get(k) instanceof JSONArray) {
							addRestrictions(criteria, (JSONArray)temp.get(k), c, k, disjunction);
						} else {
							disjunction.add(Restrictions.or(Restrictions.eq(k, temp.get(k))));
						}
					}
				}
			} else {
				if(field.get(i) instanceof JSONArray) {
					addRestrictions(criteria, (JSONArray)field.get(i), c, key, disjunction);
				} else {
					disjunction.add(Restrictions.or(Restrictions.eq(key, field.get(i))));
				}
			}
			
		}
		criteria.add(disjunction);
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
