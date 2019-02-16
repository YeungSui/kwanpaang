package core.web.security.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sport.security.model.SysPermission;
import sport.security.model.SysRole;
import sport.security.model.SysUser;
import sport.security.service.SysUserService;

public class SysUserDetailsService implements UserDetailsService {
	@Autowired
	private SysUserService sysUserService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = sysUserService.getSysUserByName(username);
		if(null == sysUser) {
			throw new UsernameNotFoundException(username);
		}
		Set<SimpleGrantedAuthority> authorities = new HashSet();
		// retrieve user authorities(roles)
		for(SysRole role:sysUser.getRoleList()) {
			for(SysPermission permission:role.getPermissionList()) {
				authorities.add(new SimpleGrantedAuthority(permission.getCode()));
			}
		}
		return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
	}
}
