package sport.fwansoccer.system.model;

import java.util.ArrayList;
import java.util.List;

public class SysRole {
	private String code = "";
	private String name = "";
	private List<SysPermission> permissionList = null;
	
	public SysRole(String c, String n) {
		code = c;
		name = n;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SysPermission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<SysPermission> permissionList) {
		this.permissionList = permissionList;
	}
	
	public void addPermission(SysPermission permission) {
		if(null == permissionList) {
			permissionList = new ArrayList();
		}
		permissionList.add(permission);
	}
}
