package co.yedam.silhyun.member.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.PrincipalDetails;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;


@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	@Autowired MemberService memberService;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		OAuth2UserInfo oAuth2UserInfo = null;
		String provider = userRequest.getClientRegistration().getRegistrationId(); //naver
		
        //추가
        if(provider.equals("naver")){
            oAuth2UserInfo =  new NaverUserInfo(oAuth2User.getAttributes());
        }
		
		String providerId = oAuth2UserInfo.getProviderId(); 
		String username = provider+"_"+providerId;  //임의로 만들어 줌
		
		String uuid = UUID.randomUUID().toString().substring(0, 6);
		String password = uuid;
		//String password = bCryptPasswordEncoder.encode("패스워드"+uuid);  // 임의로 만들어준다ㅣ.// 암호화한 후 주석풀기
		
		String role = "M1";
		String email = oAuth2UserInfo.getEmail();
		MemberVO vo = new MemberVO();
		
		vo.setEmail(email);
		vo.setPwd(password);
		vo.setMemCd(role);
		vo.setId(username);
		
		MemberVO mvo = new MemberVO();
		UserVO uvo = new UserVO();
		mvo = memberService.memeberSelect(vo);
		if(mvo == null) {
			memberService.memberInsert(vo);
			uvo.setId(vo.getId());
			uvo.setMemCd(vo.getMemCd());
			uvo.setPwd(vo.getPwd());
		}

		return new PrincipalDetails(uvo, oAuth2UserInfo);	//수정
	}
	
	
}
