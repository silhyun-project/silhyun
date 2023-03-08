package co.yedam.silhyun;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import co.yedam.silhyun.member.service.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

	@Autowired private PrincipalOauth2UserService principalOauth2UserService;
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	};
    
	//페이지 권한 설정
	@Bean //<bean id="" class="">
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() //토근을 무조건 넘겨야하는데 안넘기면 오류난다.
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home", "/silhyun/**", "/img/**","/css/**", "/fonts/**", "/js/**", "/saveImg/**", "/vendor/**", "/scss/**").permitAll() //모든권한
				.anyRequest().authenticated() //나머지 모든 요청은 로그인(세세한 권한은 회원가입 리뷰 마무리때쯤)
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				.successHandler(new CustomLoginSuccessHandler())
			)
			.oauth2Login((oauth2Login) -> oauth2Login //OAuth2기반 로그인인 경우
				.loginPage("/login") // 인증이 필요한 곳에 접근하면 이동하는곳
				.permitAll() 
				.successHandler(new CustomLoginSuccessHandler())  //로그인 성공시
				.failureUrl("/login") //로그인실패시
				.userInfoEndpoint() //로그인 성공 후 사용자 정보 가져온다.
				.userService(principalOauth2UserService) //사용자 정보 처리할 때 사용
			)
			.logout((logout) -> logout.permitAll().logoutSuccessUrl("/"));


		return http.build();
	}

	

}