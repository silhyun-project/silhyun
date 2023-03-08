package co.yedam.silhyun;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.nimbusds.oauth2.sdk.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class OAuthAttributes {
    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String id;
    private final String name;
    private final String pwd;
    private final Date birthDate;
    private final String genCd;
    private final String email;
    private final String tel;
    private final String token;
    private final String reToken;
    private final String loginCd;
    private final String profile;
    
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
       // if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        //}
//        else {
//            return ofKakao("id", attributes);
//        }
    }
    
    
    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
    	Map<String, Object> response = (Map<String, Object>) attributes.get("response");
    	
    	String loginCd = "LN";
    	String email = (String) response.get("email");
    	String id = email.split("@")[0];
    	
		String uuid = UUID.randomUUID().toString().substring(0, 6);
		String password = uuid;
		//String password = bCryptPasswordEncoder.encode("패스워드"+uuid);  // 임의로 만들어준다ㅣ.// 암호화한 후 주석풀기
		
		String birth = ((String) response.get("birthyear")) + "-" + ((String) response.get("birthday"));
		java.util.Date birthDate = null;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		String token = (String) attributes.get("resultcode");
		
		try {
			birthDate = sdf.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
    	return OAuthAttributes.builder()
    			.attributes(response)
    			.nameAttributeKey(userNameAttributeName)
    			.id(id)
    			.name((String) response.get("name"))
    			.pwd(password)
    			.birthDate(birthDate)
    			.genCd((String) response.get("gender"))
    			.email(email)
    			.tel((String) response.get("mobile"))
    			.token(token)
    			.loginCd(loginCd)
    			.profile((String) response.get("profile_image"))
    			.build();
    }
    
    
}

