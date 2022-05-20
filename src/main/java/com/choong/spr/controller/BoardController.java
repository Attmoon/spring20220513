package com.choong.spr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.domain.PageInfoDto;
import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.BoardService;
import com.choong.spr.service.ReplyService;

@Controller
@RequestMapping("project")
public class BoardController {
	
	@Autowired // BoardService로부터 데이터를 받아오기위해 선언
	private BoardService service;
	
	@Autowired // ReplyService로부터 데이터를 받아오기위해 선언
	private ReplyService replyService;
	
	
	// board/list에서 페이지관련된 정보, keyword, searchType으로 title을 받아오기위해
	// 파라미터로 정보를 얻어옴 
	@GetMapping("board/list")
	public void listBoard(@RequestParam(name = "page", defaultValue = "1")int page, 
						Model model, String keyword, String searchType) {
		int rowPerPage = 10; // 한페이지에 몇개를 보여줄건지
		
		List<BoardDto> list = service.listBoardPage(page, rowPerPage, keyword, searchType);
		int totalRecords = service.countBoard(keyword, searchType);
		
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		pageInfo.setKeyword(keyword);
		
		model.addAttribute("boardList",list);
		model.addAttribute("pageInfo", pageInfo);
	}
	
	// /project/board/get으로 요청보낼때 파라미터로받아온 id번째 board를 불러옴
	@GetMapping("board/{id}")
	public String getBoard(@PathVariable("id") int id, Model model) {
		BoardDto dto = service.getBoard(id);
		List<ReplyDto> replyList = replyService.listReplyByBoardId(id);
		
		model.addAttribute("board", dto);
		model.addAttribute("replyList", replyList);
		
		return "/project/board/get";
	}
	
	// /project/board/modfiy 경로로 post방식의 요청이 날아오면
	// board를 update한 내용물을 BoardDto 형식으로 받아서 update하고
	// /project/board/" + board.getId() 경로로 redirect시킴
	@PostMapping("board/modify")
	public String modifyBoard(BoardDto board) {
		service.updateBoard(board);
		
		return "redirect:/project/board/" + board.getId();
	}
	
	// /project/board/remove 경로로 post방식의 요청이 날아오면
	// remove할 board의 id를 받아서 지우고
	// /project/board/list 경로로 redirect시킴
	@PostMapping("board/remove")
	public String removeBoard(int id) {
		service.removeBoardById(id);
		
		return "redirect:/project/board/list";
	}
	
	// /project/board/write 경로로 get방식의 요청을 보냄
	@GetMapping("board/write")
	public void writeBoard() {
		
	}
	
	// /project/board/write 경로로 post방식의 요청이 날아오면
	// BoardDto 형식으로 추가할 board내용을 얻어온뒤에
	// /project/board/list 경로로 redirect시킴
	@PostMapping("board/write")
	public String writeBoardProcess(BoardDto board) {
		service.addBoard(board);
		
		return "redirect:/project/board/list";
	}
	
}
