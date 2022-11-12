package com.javassem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.BoardVO;

@Repository
// BoardDAOImpl.java 에서 Repository 역할을 하도록 애노테이션을 붙인다. 
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	// 클래스 안의 SqlSessionTemplate 이 DB와 연결해주는 커넥션 역할을 한다. 
    // 해당 클래스의 객체를 스프링 컨테이너에서 연결해주도록 애노테이션을 붙인다. 
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList() {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("BoardDAO.getBoardList");
	}
}