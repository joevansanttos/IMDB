package ioasys.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ioasys.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
@Profile(value={"prod", "test"})
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	//autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	//recursos estaticos jaavscript 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();*/
		
		http.authorizeRequests()
		
		.antMatchers(HttpMethod.GET, "/filmes").permitAll()
		.antMatchers(HttpMethod.GET, "/filmes/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.DELETE, "/topicos/*").hasRole("ADMINISTRADOR")
		.antMatchers(HttpMethod.GET, "/h2/**").permitAll()
		.antMatchers(HttpMethod.POST, "/h2/**").permitAll()
		.anyRequest().authenticated()
		// Make H2-Console non-secured; for debug purposes
		.and().csrf().ignoringAntMatchers("/h2/**")
		// Allow pages to be loaded in frames from
		// the same origin; needed for H2-Console
		.and().headers().frameOptions().sameOrigin()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
	}
	
	//autorizacao
		@Override
		public void configure(WebSecurity web) throws Exception {
			 web.ignoring()
		        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
		}
		
	
	

}
