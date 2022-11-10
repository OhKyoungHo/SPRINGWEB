package myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myclass.model.MemberVO;

@Controller
public class ModelValueController {
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping("modelValue.do")
	public ModelAndView test() {
		System.out.println("modelValue.do 요청됨");
		ModelAndView mv = new ModelAndView();
		//보여질 페이지 대상 설정
		mv.setViewName("01_modelValue");
		//vo라는 객체에 memberVO가져가기
		// addObject( "key" , "Value" ) : 페이지에 출력될 내용
		mv.addObject("vo",memberVO);
		return mv;
	}

}
