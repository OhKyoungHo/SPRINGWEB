package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

// @Controller + @ResponseBody  같은 역할
@RestController
public class SampleController {
	
	@GetMapping(value="getText", produces="text/plain;charset=utf-8")
	public String getText() {
		return "컨트롤러에서 보냄";
	}
	
	@GetMapping(value="getObject")
	public SampleVO getObject() {
		SampleVO vo = new SampleVO("홍길동",22,"화이팅");
		return vo;
	}
	
	@GetMapping(value="getList")
	public List<SampleVO> getListst() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길자",22,"오늘도 화이팅"));
		list.add(new SampleVO("오경호",22,"오늘도 화이팅"));
		list.add(new SampleVO("ㅋㅋㅋ",22,"오늘도 화이팅"));
		return list;
	}
	
	@GetMapping("sample/{cate}/{cno}")
	public String[] sample(@PathVariable String cate, @PathVariable String cno) {
		
		return new String[] {"카테고리 :"  +cate, "상품번호 :" + cno}; 
	}
	
	
	@PostMapping(value="sample/data")
	public SampleVO post(SampleVO vo) {
		System.out.println("sample/data 요청");
		return vo;
	}
	
}
