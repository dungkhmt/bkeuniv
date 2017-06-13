package vn.webapp.modules.usermanagement.dao;

import java.util.List;

import vn.webapp.modules.usermanagement.model.Role;

public interface RoleDAO {
	
	public List<Role> getList();
	public Role getByName(String name);
	public List<Role> getByUser(String Username);
}
