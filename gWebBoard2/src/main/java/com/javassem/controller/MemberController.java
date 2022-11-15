package com.javassem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("user")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/*
	 * @RequestMapping("userJoin.do") public void userJoin() {
	 * System.out.println("userJoin 확인"); 
	 * }
	 * 
	 * @RequestMapping("userLogin.do") public void userLogin() {
	 * System.out.println("userLogin 확인");
	 * }
	 */
	
	@RequestMapping("{url}.do")
	public String userPage(@PathVariable String url) {
		System.out.println("확인");
		return "/user/" + url;
		//"/user/"를 안쓰면 [/WEB-INF/views/userLogin.jsp]로 받아서 404오류 발생
	}
	
	/*
	 * 요청 : /user/userInsert.do
	 * 뷰페이지 :  user/userJoin_ok.jsp
	 */
	
	@RequestMapping("userInsert.do")
	public ModelAndView userInsert(MemberVO memberVO) {
		System.out.println(memberVO.getUserName());
		
		int result = memberService.userInsert(memberVO);
		String message ="가입되지 않았습니다.";
		if(result==1) message = memberVO.getUserName() + "님 가입을 축하합니다.";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin_ok");
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping("login.do")
	//************
	//세션 사용 -> 인자에 httpSession 변수 선언
	public String login(MemberVO vo, HttpSession session) {
		MemberVO result = memberService.idCheck_Login(vo);
		if(result==null || result.getUserId()==null) {
			System.out.println("로그인 실패");
			return "/user/userLogin";
		}else {
			System.out.println("로그인 성공");
			//세션에 저장
			session.setAttribute("login", vo.getUserId());
			return "/user/login_ok";
		}
	}
	
	@RequestMapping(value="idCheck.do", produces="application/text;charset=utf-8")
	//***************
	//일반요청함수에서 String 리턴 : 뷰페이지 지정
	// 이 요청에 Ajax 통신에 의해 값을 전송해야 함
	@ResponseBody
	public String checkId(MemberVO vo) {
		
		System.out.println("idCheck.do 요청 :" + vo.getUserId());
		
		MemberVO result =  memberService.idCheck_Login(vo);
		String message = "사용가능한 아이디입니다.";
		if(result != null) message = "중복된 아이디가 있습니다.";
		
		return message;
	}

	
}
