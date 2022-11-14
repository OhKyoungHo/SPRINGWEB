package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.BoardDAO;
import com.javassem.domain.BoardVO;


@Service
//서비스 역할을 할 BoardServiceImpl.java 에 빈을 생성하여 컨트롤러에서 찾아올 수 있도록 애노테이션을 붙인다. 
public class BoardServiceImpl implements BoardService {
	@Autowired
	//클래스 내의 BoardDAOImpl 에 대해서도 스프링 컨테이너에서 객체를 찾아서 연결해주도록 애노테이션을 붙인다. 
	private BoardDAO boardDAO;

	
	public void insertBoard(BoardVO vo) {

		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	//서비스에서 수행하는 getBoardList( ) 메소드는 BoardDAOImpl 의 getBoardList( ) 메소드를 호출한다. 
	public List<BoardVO> getBoardList(HashMap map) {
		return boardDAO.getBoardList(map);
	}
}