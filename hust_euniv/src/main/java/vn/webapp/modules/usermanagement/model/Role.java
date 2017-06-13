package vn.webapp.modules.usermanagement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tblroles")
public class Role implements GrantedAuthority,Serializable{
	
	@Id
	@GeneratedValue
	private int ROLE_ID;
	private String ROLE_CODE;
	
	@ManyToMany(mappedBy="roles", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<User> users = new HashSet<User>();
		
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(int rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public String getROLE_CODE() {
		return ROLE_CODE;
	}

	public void setROLE_CODE(String rOLE_CODE) {
		ROLE_CODE = rOLE_CODE;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return ROLE_CODE;
	}		
}
