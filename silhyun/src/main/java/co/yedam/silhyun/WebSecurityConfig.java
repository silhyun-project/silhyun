package co.yedam.silhyun;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import co.yedam.silhyun.member.service.OAuthUserService;
import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig{
	
	private final OAuthUserService userService;

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	};
    
	//페이지 권한 설정
	@Bean //<bean id="" class="">
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() //토근을 무조건 넘겨야하는데 안넘기면 오류난다.
			.authorizeHttpRequests()
				.antMatchers("/", "/home", "/silhyun/**", "/img/**","/css/**", "/fonts/**", "/js/**", "/saveImg/**", "/vendor/**", "/scss/**", "/manage/**").permitAll() //모든권한
				//.anyRequest().authenticated() //나머지 모든 요청은 로그인(세세한 권한은 회원가입 리뷰 마무리때쯤)
			.and()
			.logout().logoutSuccessUrl("/")
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(new CustomLoginSuccessHandler())
			.and()
			.oauth2Login()
			     .loginPage("/login/oauth")
				.permitAll()
				.successHandler(new CustomLoginSuccessHandler())
				.userInfoEndpoint()
				.userService(userService);
			


		return http.build();
	}

	

}