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
	//컨트롤러에서 saveBoard.do 요청을 수행할 수 있도록 saveBoard() 메소드를 작성하는데 
	//이 때, name과 BoardVO의 변수명을 동일하게 부여했으므로,
	//인자에 BoardVO를 기술하면 정보를 알아서 가져온다. 
	public String saveBoard(BoardVO boardVO) {
		//System.out.println(boardVO.getContent());
		boardservice.insertBoard(boardVO);
		return"redirect:getBoardList.do";
	}
	//간략버전
	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO boardVO, Model m) {
		m.addAttribute("board",boardservice.getBoard(boardVO));
	}
	

	 @RequestMapping("deleteBoard.do") 
	 public String deleteBoard(BoardVO boardVO) { 
	 boardservice.deleteBoard(boardVO);
	 return "redirect:getBoardList.do";
	 }
	 
	 
	 @RequestMapping("updateBoard.do")
	 public String updateBoard(BoardVO boardVO) {
		 boardservice.updateBoard(boardVO);
		 //해당 경우는 수정된 게시글을 저장해서 이동
		 //return"redirect:getBoard.do?seq=" + boardVO.getSeq();
		 //해당 경우는 수정된 후 게시글 모아진 페이지로 이동
		 return"redirect:getBoardList.do";
	 }
	 
/*	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO boardVO, Model m) {
		BoardVO resultVO =boardservice.getBoard(boardVO);
		m.addAttribute("board");
	}
*/
		

}
