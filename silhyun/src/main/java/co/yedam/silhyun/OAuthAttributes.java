package co.yedam.silhyun;


import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


import lombok.Data;


@Data
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

    
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String id, String name, String pwd,
			Date birthDate, String genCd, String email, String tel, String token, String reToken, String loginCd,
			String profile) {
		super();
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.birthDate = birthDate;
		this.genCd = genCd;
		this.email = email;
		this.tel = tel;
		this.token = token;
		this.reToken = reToken;
		this.loginCd = loginCd;
		this.profile = profile;
	}
	

    
    // 해당 로그인인 서비스가 kakao인지 google인지 구분하여, 알맞게 매핑을 해주도록 합니다.
    // 여기서 registrationId는 OAuth2 로그인을 처리한 서비스 명("kakao","naver"..)이 되고,
    // userNameAttributeName은 해당 서비스의 map의 키값이 되는 값이됩니다. {, kakao="id", naver="response"}
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if (registrationId.equals("kakao")) {
            return ofKakao(userNameAttributeName, attributes);
        }else
            return ofNaver(userNameAttributeName,attributes);
        
    }
    
    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
    	Map<String, Object> response = (Map<String, Object>) attributes.get("response");
    	
    	
    	String loginCd = "LN";
    	String email = (String) response.get("email");
    	String id = "naver"+"_"+email.split("@")[0];
    	
		String uuid = UUID.randomUUID().toString().substring(0, 6);
		String password = uuid;
		//String password = bCryptPasswordEncoder.encode("패스워드"+uuid);  // 임의로 만들어준다ㅣ.// 암호화한 후 주석풀기
		
		String birth = ((String) response.get("birthyear")) + "-" + ((String) response.get("birthday"));
		java.util.Date birthDate = null;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			birthDate = sdf.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String token = "";
		String reToken = "";
    	
        return new OAuthAttributes(
        		attributes
                ,userNameAttributeName
    			,id
    			,(String) response.get("name")
    			,password
    			,birthDate
    			,(String) response.get("gender")
    			,email
    			,(String) response.get("mobile")
    			,token
    			,reToken
    			,loginCd
    			,(String) response.get("profile_image")
        		);
    }
    
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");  // 카카오로 받은 데이터에서 계정 정보가 담긴 kakao_account 값을 꺼낸다.
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");   // 마찬가지로 profile(nickname, image_url.. 등) 정보가 담긴 값을 꺼낸다.

    	System.out.println(kakao_account);
    	String loginCd = "LK";
    	String email = (String) kakao_account.get("email");
    	System.out.println(email);
    	String id = "kakao"+"_"+email.split("@")[0];
    	
		String uuid = UUID.randomUUID().toString().substring(0, 6);
		String password = uuid;
		//String password = bCryptPasswordEncoder.encode("패스워드"+uuid);  // 임의로 만들어준다ㅣ.// 암호화한 후 주석풀기
		
		String birth = ((String) kakao_account.get("birthday"));
		java.util.Date birthDate = null;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMdd");
		
		try {
			birthDate = sdf.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((String) profile.get("nickname"));
		String token = "";
		String reToken = "";
		String tel = "";
        
        return new OAuthAttributes(
        		attributes
                ,userNameAttributeName
    			,id
    			,(String) profile.get("nickname")
    			,password
    			,birthDate
    			,(String) kakao_account.get("gender")
    			,email
    			,tel
    			,token
    			,reToken
    			,loginCd
    			,(String) profile.get("profile_image_url")
        		);
    }





    
}

