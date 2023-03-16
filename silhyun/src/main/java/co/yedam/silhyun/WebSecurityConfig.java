package co.yedam.silhyun;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import co.yedam.silhyun.member.service.OAuthUserService;
import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig{
	
	private final OAuthUserService userService;  //로그인 api디비 연결

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
    
	//rememberMe
	private final DataSource dataSource;
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource); //내꺼랑 연결
		return repo;
	}
	
	
	//페이지 권한 설정
	@Bean //<bean id="" class="">
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() //토근을 무조건 넘겨야하는데 안넘기면 오류난다.
			.authorizeHttpRequests()
				.antMatchers("/", "/home", "/silhyun/**", "/img/**","/css/**", "/fonts/**", "/js/**", "/saveImg/**", "/vendor/**", "/scss/**", "/manage/**").permitAll() //모든권한
				//.anyRequest().authenticated() //나머지 모든 요청은 로그인(세세한 권한은 회원가입 리뷰 마무리때쯤)
			.and()
			.rememberMe()
				.tokenValiditySeconds(86400 + 43200) //토큰 유효시간 36시간
				.rememberMeParameter("remember-me")
				.tokenRepository(persistentTokenRepository())
			.and()
			.logout()
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID", "remember-me")
			.and()
			.formLogin()
				.loginPage("/login")
				.successHandler(new CustomLoginSuccessHandler())
				.permitAll()
			.and()
			.oauth2Login()
			     .loginPage("/login/oauth")
				.permitAll()
				.userInfoEndpoint()
				.userService(userService);
			


		return http.build();
	}

	

}