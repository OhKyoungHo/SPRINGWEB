package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
@RequestMapping
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	
	@RequestMapping("getBoardList.do")
	public void getBoardList(Model m) {
		List<BoardVO> list = boardservice.getBoardList();
		m.addAttribute("boardList", list);
		
	}
	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}
	
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO boardVO) {
		//System.out.println(boardVO.getContent());
		boardservice.insertBoard(boardVO);
		return"redirect:getBoardList.do";
	}
	//간략버전
	/*@RequestMapping("getBoard.do")
	public void getBoard(BoardVO boardVO, Model m) {
		m.addAttribute("board",boardservice.getBoard(boardVO));
	}*/
	
	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO boardVO, Model m) {
		BoardVO resultVO =boardservice.getBoard(boardVO);
		m.addAttribute("board");
	}


		

}
