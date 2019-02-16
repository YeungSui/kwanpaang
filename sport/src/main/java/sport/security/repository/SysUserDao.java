package sport.security.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import core.repository.CompoundExpression;
import core.repository.ExpressionComponent;
import core.repository.GenericDao;
import sport.security.model.SysUser;

@Repository
public class SysUserDao extends GenericDao<SysUser> {
	public SysUser findSysUserByName(String username) {
		CompoundExpression ce = new CompoundExpression();
		ce.and(new ExpressionComponent(SysUser.class, "username","=",username));
		List<SysUser> users = findByExpression(ce);
		if(users.size() > 0) {
			return users.get(0);
		}
		else return null;
	}
}
