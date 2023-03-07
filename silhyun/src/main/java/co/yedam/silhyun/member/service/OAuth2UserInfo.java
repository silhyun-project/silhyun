package co.yedam.silhyun.member.service;

import java.util.Map;

public interface OAuth2UserInfo {
    Map<String, Object> getAttributes();
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();
    
    //프로필/성별/생일/출생연도/전화번호
    String getprofileImage();
    String getGender();
    String getBirthday();
    String getBirthyear();
    String getMobile();
}
