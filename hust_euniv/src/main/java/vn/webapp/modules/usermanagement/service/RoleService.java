package vn.webapp.modules.usermanagement.service;

import java.util.List;

import vn.webapp.modules.usermanagement.model.Role;

public interface RoleService {
	
	public List<Role> getList();
	public Role getByName(String name);
	public List<Role> getByUser(String Username);

}
