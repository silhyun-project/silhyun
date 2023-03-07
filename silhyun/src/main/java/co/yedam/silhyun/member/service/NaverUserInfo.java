package co.yedam.silhyun.member.service;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo {
	
    private Map<String, Object> attributes; //OAuth2User.getAttributes();
    private Map<String, Object> attributesResponse;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = (Map<String, Object>) attributes.get("response");
        this.attributesResponse = (Map<String, Object>) attributes.get("response");
    }
    
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getProviderId() {
        return attributesResponse.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return attributesResponse.get("email").toString();
    }

    @Override
    public String getName() {
        return attributesResponse.get("name").toString();
    }

	@Override
	public String getprofileImage() {
		// TODO Auto-generated method stub
		return attributesResponse.get("profile_image").toString();
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return attributesResponse.get("gender").toString();
	}

	@Override
	public String getBirthday() {
		// TODO Auto-generated method stub
		return attributesResponse.get("birthday").toString();
	}

	@Override
	public String getBirthyear() {
		// TODO Auto-generated method stub
		return attributesResponse.get("birthyear").toString();
	}

	@Override
	public String getMobile() {
		// TODO Auto-generated method stub
		return attributesResponse.get("mobile").toString();
	}

}
