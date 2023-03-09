package co.yedam.silhyun;

import java.io.Serializable;

import co.yedam.silhyun.member.vo.UserVO;
import lombok.Data;

@Data
public class SessionUser implements Serializable {
	
	private String id;
	private String role;
	
	public SessionUser(UserVO user) {
		this.id = user.getId();
		this.role = user.getMemCd();
	}
	
	public SessionUser() {}
}
