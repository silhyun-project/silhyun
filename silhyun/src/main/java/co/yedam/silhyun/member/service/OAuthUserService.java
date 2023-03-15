package co.yedam.silhyun.member.service;


import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.nimbusds.oauth2.sdk.AuthorizationCode;

import co.yedam.silhyun.OAuthAttributes;
import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final MemberService memberService;
	private final HttpSession httpSession;
	
    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(oAuth2UserRequest);
        
        // 현재 진행중인 서비스를 구분하기 위해 문자열로 받음. oAuth2UserRequest.getClientRegistration().getRegistrationId()에 값이 들어있다. {registrationId='naver'} 이런식으로
        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();

        // OAuth2 로그인 시 키 값이 된다. 구글은 키 값이 "sub"이고, 네이버는 "response"이고, 카카오는 "id"이다. 각각 다르므로 이렇게 따로 변수로 받아서 넣어줘야함.
        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

	// OAuth2 로그인을 통해 가져온 OAuth2User의 attribute를 담아주는 of 메소드.
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
   
        //밑의 함수에 담기
		UserVO user = saveOrUpdate(attributes);
		
		//세션보에 담기
		//httpSession.setAttribute("user", new SessionUser(user));
		httpSession.setAttribute("id", attributes.getId());
		//httpSession.setAttribute("so", );
		System.out.println(attributes.getId() + "ddddddddddddddddddddddddddddddddddddd");
		httpSession.setAttribute("role", user.getMemCd());
		
		
        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getMemCd()))
                , attributes.getAttributes()
                , attributes.getNameAttributeKey());
	}
	
    private UserVO saveOrUpdate(OAuthAttributes attributes) {
    	//보에 담아서 인써트
        MemberVO vo = new MemberVO();
        vo.setId(attributes.getId());
        vo.setPwd(attributes.getPwd());
        vo.setName(attributes.getName());
        vo.setTel(attributes.getTel());
        vo.setBirthDate(attributes.getBirthDate());
        vo.setGenCd(attributes.getGenCd());
        vo.setLoginCd(attributes.getLoginCd());
        vo.setToken(attributes.getToken());
        vo.setEmail(attributes.getEmail());
        vo.setProfile(attributes.getProfile());
        
        MemberVO mvo = new MemberVO();
		UserVO uvo = new UserVO();
		mvo = memberService.memeberSelect(vo);
		if(mvo == null) {
			memberService.memberInsert(vo);
			vo = memberService.memeberSelect(vo);
			uvo.setId(vo.getId());
			uvo.setMemCd(vo.getMemCd());
			uvo.setPwd(vo.getPwd());
		}else {
			//디비에 값이있음 uvo에만 담아준다.
			uvo.setId(mvo.getId());
			uvo.setMemCd(mvo.getMemCd());
			uvo.setPwd(mvo.getPwd());
		}

        return uvo;
    }

}
