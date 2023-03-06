package co.yedam.silhyun;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import co.yedam.silhyun.member.service.UsersService;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

	//static 폴더 무시
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	};
	
	//페이지 권한 설정
	@Bean //<bean id="" class="">
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home", "/silhyun/**").permitAll() //모든권한
				.anyRequest().authenticated() //나머지 모든 요청은 로그인
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				.successHandler(new CustomLoginSuccessHandler())
			)
			.logout((logout) -> logout.permitAll().logoutSuccessUrl("/"))
			.csrf().disable(); //토근을 무조건 넘겨야하는데 안넘기면 오류난다.

		return http.build();
	}

	

}