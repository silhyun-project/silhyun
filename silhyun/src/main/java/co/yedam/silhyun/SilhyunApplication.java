package co.yedam.silhyun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.yedam.silhyun.mypage.vo.ChulcheckVO;

@SpringBootApplication
@MapperScan(basePackages = "co.yedam.silhyun.**.map")
public class SilhyunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SilhyunApplication.class, args);
	}
	
}
