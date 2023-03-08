package co.yedam.silhyun.member.service;


import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.OAuthAttributes;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final MemberService memberService;
	//private final HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId(); //naver or kakao
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();  //각 계정마다의 유니크한 id값을 전달\
		
		//카카오랑 네이버 구별 
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

		UserVO user = saveOrUpdate(attributes);
		
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getMemCd())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
	}
	
    private UserVO saveOrUpdate(OAuthAttributes attributes) {
        MemberVO vo = new MemberVO();
        vo.setId(attributes.getId());
        vo.setPwd(attributes.getPwd());
        vo.setName(attributes.getName());
        vo.setTel(attributes.getTel());
        vo.setBirthDate(attributes.getBirthDate());
        vo.setGenCd(attributes.getGenCd());
        vo.setLoginCd(attributes.getLoginCd());
        vo.setToken(attributes.getToken());
        
        MemberVO mvo = new MemberVO();
		UserVO uvo = new UserVO();
		mvo = memberService.memeberSelect(vo);
		if(mvo == null) {
			memberService.memberInsert(vo);
			vo = memberService.memeberSelect(vo);
			uvo.setId(vo.getId());
			uvo.setMemCd(vo.getMemCd());
			uvo.setPwd(vo.getPwd());
		}

        return uvo;
    }

}
