package vn.webapp.modules.usermanagement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblusers")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private int User_ID;
	private String Username;
	private String Password;	
	private String User_Code;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Role.class)  
    @JoinTable(name="tbluserroles", 
    		   joinColumns=@JoinColumn(name="Username", referencedColumnName = "Username"), 
    		   inverseJoinColumns=@JoinColumn(name="Role", referencedColumnName = "ROLE_CODE")) 
	private Set<Role> roles = new HashSet<Role>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Function.class)  
    @JoinTable(name="tbluserfunctions", 
    		   joinColumns=@JoinColumn(name="USERFUNC_USERCODE", referencedColumnName = "User_Code"), 
    		   inverseJoinColumns=@JoinColumn(name="USERFUNC_FUNCCODE", referencedColumnName = "FUNC_CODE")) 
	private Set<Function> functions = new HashSet<Function>();
		
	public User(){		
	}
	
	public User(String username, String password, HashSet<Role> roles){
		this.Username = username;
		this.Password = password;
		this.setAuthorities(roles);
	}		

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Role> getAuthorities() {
		return roles;
	}

	public void setAuthorities(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUser_Code() {
		return User_Code;
	}

	public void setUser_Code(String user_Code) {
		User_Code = user_Code;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}	
	
}
