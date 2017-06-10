package vn.webapp.modules.usermanagement.dao;

import java.util.List;

import vn.webapp.modules.usermanagement.model.User;

public interface UserDAO {
	
	public List<User> getList();
	public User getByID(int id);
	public User getByUsernameAndPassword(String username, String password);
	public User getByUsername(String username);
	public void save(User user);
	public void delete(User user);
	
	
}
