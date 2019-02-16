package sport.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import sport.security.model.SysUser;
import sport.security.repository.SysUserDao;

public class SysUserService {
	@Autowired
	SysUserDao sysUserDao;
	
	public SysUser getSysUserByName(String username) {
		return sysUserDao.findSysUserByName(username);
	}

}
