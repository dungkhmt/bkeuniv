package vn.webapp.modules.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.webapp.modules.usermanagement.dao.RoleDAO;
import vn.webapp.modules.usermanagement.model.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;	
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	@Transactional
	public List<Role> getList(){
		return roleDAO.getList();
	}
	
	@Override
	@Transactional
	public Role getByName(String name){
		return roleDAO.getByName(name);
	}

}
