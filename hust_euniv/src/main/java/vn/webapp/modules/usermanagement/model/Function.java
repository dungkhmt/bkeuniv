/**
 * @author : HaTN 
 * @address : HUST K51
 * @modified : December 27th, 2015
 */
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
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tblfunctions")
public class Function implements GrantedAuthority,Serializable{
	
	@Id
    @GeneratedValue
    private int FUNC_ID;
    private String FUNC_CODE;
    private String FUNC_NAME;
    private int FUNC_INDEX;
    private String FUNC_URL;
    private int FUNC_PARENTID;
    private String FUNC_TITLE_CLASS;
    private String FUNC_SELECTED_CLASS;
    private int FUNC_HAS_CHILDREN;
    
    @ManyToMany(mappedBy="functions", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<User> users = new HashSet<User>();
	    
	public int getFUNC_INDEX() {
		return FUNC_INDEX;
	}
	public void setFUNC_INDEX(int fUNC_INDEX) {
		FUNC_INDEX = fUNC_INDEX;
	}
	public int getFUNC_ID() {
		return FUNC_ID;
	}
	public void setFUNC_ID(int fUNC_ID) {
		FUNC_ID = fUNC_ID;
	}
	public String getFUNC_CODE() {
		return FUNC_CODE;
	}
	public void setFUNC_CODE(String fUNC_CODE) {
		FUNC_CODE = fUNC_CODE;
	}
	public String getFUNC_NAME() {
		return FUNC_NAME;
	}
	public void setFUNC_NAME(String fUNC_NAME) {
		FUNC_NAME = fUNC_NAME;
	}
	public String getFUNC_URL() {
		return FUNC_URL;
	}
	public void setFUNC_URL(String fUNC_URL) {
		FUNC_URL = fUNC_URL;
	}
	public int getFUNC_PARENTID() {
		return FUNC_PARENTID;
	}
	public void setFUNC_PARENTID(int fUNC_PARENTID) {
		FUNC_PARENTID = fUNC_PARENTID;
	}
	public String getFUNC_TITLE_CLASS() {
		return FUNC_TITLE_CLASS;
	}
	public void setFUNC_TITLE_CLASS(String fUNC_TITLE_CLASS) {
		FUNC_TITLE_CLASS = fUNC_TITLE_CLASS;
	}
	public String getFUNC_SELECTED_CLASS() {
		return FUNC_SELECTED_CLASS;
	}
	public void setFUNC_SELECTED_CLASS(String fUNC_SELECTED_CLASS) {
		FUNC_SELECTED_CLASS = fUNC_SELECTED_CLASS;
	}
	public int getFUNC_HAS_CHILDREN() {
		return FUNC_HAS_CHILDREN;
	}
	public void setFUNC_HAS_CHILDREN(int fUNC_HAS_CHILDREN) {
		FUNC_HAS_CHILDREN = fUNC_HAS_CHILDREN;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.FUNC_CODE;
	}		
	
	public void setAuthority(String functionCode){
		this.FUNC_CODE = functionCode;
	}
}
