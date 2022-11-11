package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {
	
	@RequestMapping("insert.do")
	public String test() {
		//****************
		//return "select";
		//★★★리다이렉팅
		return"redirect:select.do";
	}
	@RequestMapping("select.do")
	public void test2(Model m) {
		m.addAttribute("info", "디비에서 넘어온 값");
	}

}
