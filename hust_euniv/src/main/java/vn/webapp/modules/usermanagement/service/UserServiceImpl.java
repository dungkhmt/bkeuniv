package vn.webapp.modules.usermanagement.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.webapp.modules.usermanagement.dao.UserDAO;
import vn.webapp.modules.usermanagement.model.Role;
import vn.webapp.modules.usermanagement.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}	
	
	@Override
	@Transactional
	public List<User> getList(){
		return userDAO.getList();
	}
	
	@Override
	@Transactional
	public User getByID(int id){
		return userDAO.getByID(id);
	}
	
	@Override
	@Transactional
	public User getByUsernameAndPassword(String username, String password){
		return userDAO.getByUsernameAndPassword(username, password);
	}
	
	@Override
	@Transactional
	public User getByUsername(String username){
		return userDAO.getByUsername(username);
	}
	
	@Override
	@Transactional
	public void save(String username, String password, HashSet<Role> roles){
		userDAO.save(new User(username, password, roles));
	}
	
	@Override
	@Transactional
	public void delete(int id){
		User user = userDAO.getByID(id);
		if(user != null)
			userDAO.delete(user);		
	}
}
