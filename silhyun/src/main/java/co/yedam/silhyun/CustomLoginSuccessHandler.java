package co.yedam.silhyun;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import co.yedam.silhyun.member.vo.UserVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		request.getSession().setAttribute("id", authentication.getName());
		request.getSession().setAttribute("role", authentication.getAuthorities());
		System.out.println(authentication.getName()+"뭐라고 저장???????????????????");
		response.sendRedirect("/");

	}

}
