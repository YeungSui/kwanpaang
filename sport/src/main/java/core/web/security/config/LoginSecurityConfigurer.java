package core.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import core.web.security.service.SysUserDetailsService;

@Configuration
public class LoginSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private SysUserDetailsService sysUserDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","index").permitAll().anyRequest().authenticated()
		.antMatchers("/admin","/admin/**/*").hasRole("ADMIN") // 管理页面权限控制
		.antMatchers("/non-free/**/*").hasRole("MEMBER") // 付费内容权限控制
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login-error.html").permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/index");
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
