package core.web.security.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class GlobalAuthorityStrategy {
	private Map<String, List<String>> antMatchers = new HashMap();
	/**
	 * 构造antMatchers，指定访问某种模式的url所需要的用户角色
	 * @param role 用户角色
	 * @param patterns ant形式的url
	 */
	public GlobalAuthorityStrategy addUrlAccessRole(String role, String... patterns) {
		List<String> urlPatterns = antMatchers.get(role);
		if (urlPatterns == null) {
			urlPatterns = new ArrayList<String>();
			antMatchers.put(role, urlPatterns);
		}
		for(int i = 0; i < patterns.length; i++) {
			urlPatterns.add(patterns[i]);
		}
		return this;
	}
	/**
	 * 默认的全局授权策略，/和/index允许所有人访问，其他所有路径需要授权；登录页地址/login，错误返回页面"/login-error.html，所有人都可访问；登出跳转页面/index
	 * @param http
	 * @throws Exception
	 */
	public void configureByDefault(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","index").permitAll().anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login-error.html").permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/index");
		Set<String> keySet = antMatchers.keySet();
		for(String role:keySet) {
			List<String> urlPatterns = antMatchers.get(role);
			for(String pattern:urlPatterns) {
				http.authorizeRequests().antMatchers(pattern).hasRole(role);
			}
		}
	}
	
}
