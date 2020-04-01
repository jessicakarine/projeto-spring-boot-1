package br.com.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();
//	}

	// @Autowired

	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	/**
	 * O código comentado abaixo é a melhor maneira de se fazer, porém apenas para
	 * meios educativos usamos o DEScomentado, não é recomentada para sistemas
	 * reais.
	 *
	 * auth.inMemoryAuthentication()
	 * .withUser("jessica").password("spring").roles("USER") .and()
	 * .withUser("adm").password("spring").roles("USER", "ADM");
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication()
				// .withUser("jessica").password("{noop}password").roles("USER")
				.withUser("jessica").password(encoder.encode("password")).roles("USER")
				.and()
				.withUser("adm").password("{noop}password").roles("USER", "ADM");

	}

}
