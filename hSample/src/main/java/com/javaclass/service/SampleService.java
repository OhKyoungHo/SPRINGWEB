package com.javaclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.repository.SampleDAO;

@Service
public class SampleService {
	//SampleDAO 객체 dao의 메소드 sample 호출해서 값 리턴
	@Autowired
	private SampleDAO dao;
	
	@RequestMapping
	public String sample() {
		return dao.sample();
		
	}

}
