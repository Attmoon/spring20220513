package com.choong.spr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.service.BoardService;

@Controller
@RequestMapping("project")
public class BoardController {
	
	@Autowired
	private BoardService service;

	@GetMapping("board/list")
	public void listBoard(Model model) {
		
		List<BoardDto> list = service.listBoard();
		
		model.addAttribute("boardList",list);
	}
}
