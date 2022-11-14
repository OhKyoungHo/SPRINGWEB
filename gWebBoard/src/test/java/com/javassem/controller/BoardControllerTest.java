package com.javassem.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
//스프링제이유닛 테스트하는 것임
@WebAppConfiguration
//애플리케이션 컨텍스트의 웹 버전을 생성하는 데 사용되는 클래스 레벨 어노테이션
@ContextConfiguration(
		{"file:src/main/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/WEB-INF/spring/root-context.xml"})
//자동으로 만들어줄 애플리케이션 컨텍스트의 설정파일위치를 지정한 것

public class BoardControllerTest {
	
	private WebApplicationContext context;
	
	private MockMvc mockMvc;		//Mock : 모조품(테스트를 하기 위한 모조품 구조)
	
	@Autowired 
	BoardController boardController;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
		
	}

	@Test
	public void test() throws Exception{
		//System.out.println("테스트 확인");	
		mockMvc.perform(get("/test.do")).andDo(print()).andExpect(status().isOk());
	}
	
}
