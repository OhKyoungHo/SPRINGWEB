package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("요청받음");
		ModelAndView mv = new ModelAndView();
		//보낼값 설정
		mv.addObject("message","즐거운하루");
		mv.addObject("data", "중요한데이터");
		//뷰페이지 설정
		mv.setViewName("secret");
			// WEB-INF/views/ + secret +.jsp
		return mv;
	}

}
