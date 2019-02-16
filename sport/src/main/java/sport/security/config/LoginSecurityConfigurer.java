package sport.security.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import core.web.security.config.GlobalAuthorityStrategy;
import core.web.security.service.SysUserDetailsService;
import sport.security.model.SysPermission;
import sport.security.service.SysPermissionService;

@Configuration
public class LoginSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private SysUserDetailsService sysUserDetailsService;
	@Autowired
	private SysPermissionService sysPermissionService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		GlobalAuthorityStrategy strategy = new GlobalAuthorityStrategy();
		List<SysPermission> permissions = sysPermissionService.findAll();
		for(SysPermission permission:permissions) {
			strategy.addUrlAccessRole(permission.getCode(), permission.getUrlPattern());
		}
		strategy.configureByDefault(http);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(sysUserDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
