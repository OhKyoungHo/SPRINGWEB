package myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myclass.model.MemberVO;

@Controller
public class ParamDoController {
	@RequestMapping("param*.do")
	public String test(MemberVO vo) {
		//System.out.println(vo.getId());
		//System.out.println(vo.getName());
		//System.out.println(vo.getAge());
		return "param";
		
	}
	
}
