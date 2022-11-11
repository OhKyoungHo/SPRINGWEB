package com.javaclass.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.service.SampleService;

@Controller
public class SampleControlLer {
	//SampleService의 객체 service의 sample 메소드 호출
	//con을 "serverTime"로 부르고
	//해당 값을 home.jsp에 리턴한다
	
	@Autowired
	private SampleService service;
	
	@RequestMapping("sample.do")
	public String sample(Model m) {
		String con= service.sample();
		m.addAttribute("serverTime", con);
		return "home";
	}
	

}
