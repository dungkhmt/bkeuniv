package vn.webapp.modules.usermanagement.service;

import java.util.HashSet;
import java.util.List;

import vn.webapp.modules.usermanagement.model.Role;
import vn.webapp.modules.usermanagement.model.User;

public interface UserService {
	
	public List<User> getList();
	public User getByID(int id);
	public User getByUsernameAndPassword(String username, String password);
	public User getByUsername(String username);
	public void save(String username, String password, HashSet<Role> roles);
	public void delete(int id);

}
