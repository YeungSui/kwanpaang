package sport.fwansoccer.system.repository;

import org.springframework.stereotype.Repository;

import sport.fwansoccer.system.model.SysUser;

@Repository
public class SysUserDao extends GenericDao<SysUser> {
	public SysUser findSysUserByName(String username) {
		CompoundExpression ce = new CompoundExpression();
		ce.and(ExpressionComponen("username","=",username));
		return findByExpression(ce);
	}
}
