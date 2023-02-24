package co.yedam.silhyun.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.silhyun.portfolio.service.AroundService;

@RestController
public class AroundRestController {

	@Autowired
	private AroundService aroundService;

	@RequestMapping(value = "/AjaxAroundList", produces = "application/json;charset=UTF-8")
	public String ajaxAroundList(Model model) {
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(aroundService.getAroundList());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("호출되었니");
		return str;

	}
}
