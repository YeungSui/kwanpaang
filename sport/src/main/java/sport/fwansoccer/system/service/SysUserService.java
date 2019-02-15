package sport.fwansoccer.system.service;

import org.springframework.beans.factory.annotation.Autowired;

import sport.fwansoccer.system.model.SysUser;
import sport.fwansoccer.system.repository.SysUserDao;

public class SysUserService {
	@Autowired
	SysUserDao sysUserDao;
	
	public SysUser getSysUserByName(String username) {
		return sysUserDao.findUserByName(username);
	}

}
