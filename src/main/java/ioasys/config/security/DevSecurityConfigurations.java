package ioasys.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	/*
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
	
	*/
	
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
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(HttpMethod.GET, "/h2/**").permitAll()
		.antMatchers(HttpMethod.POST, "/h2/**").permitAll()
		.and().csrf().disable();
		 http.headers().frameOptions().disable();
;
	}
	
	/*
	//autorizacao
		@Override
		public void configure(WebSecurity web) throws Exception {
			 web.ignoring()
		        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
		}*/
		
	
	

}
