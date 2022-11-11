package com.javaclass.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SampleDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//sqlSession에 mapper에서 만든 sampleDAO.sample을 가져와서 넣기
	public String sample() {
	return	sqlSession.selectOne("sampleDAO.sample");
	}
	

}
