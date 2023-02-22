package co.yedam.silhyun.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.silhyun.member.service.PtgService;

@RestController
public class ReserRestController {

	@Autowired
	PtgService ptgService;
	
	@RequestMapping(value = "/AjaxPtgList", produces ="application/json;charset=UTF-8" )
	public String ajaxPtgList(Model model) {
	String str = null;
	ObjectMapper json = new ObjectMapper();
	try {
		str = json.writeValueAsString(ptgService.getPtgLsit());
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	System.out.println("호출되었니");
	return str;
	
	}
}
