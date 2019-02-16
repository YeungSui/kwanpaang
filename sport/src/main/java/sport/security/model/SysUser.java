package sport.security.model;

import java.io.Serializable;
import java.util.List;

public class SysUser implements Serializable{
	private List<SysRole> roleList = null;
	private String username = "";
	private String password = "";
	
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
