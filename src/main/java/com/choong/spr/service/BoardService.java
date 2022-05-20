package com.choong.spr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.mapper.BoardMapper;
import com.choong.spr.mapper.ReplyMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	

	public BoardDto getBoard(int id) {
		return mapper.getBoard(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		
		return cnt == 1;
	}
	
	@Transactional
	public boolean removeBoardById(int id) {
		replyMapper.deleteReplyByBoard(id);
		
		int cnt = mapper.removeBoardById(id);
		
		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		
		int cnt = mapper.addBoard(board);
		
		return cnt == 1;
	}

	public List<BoardDto> listBoardPage(int page, int rowPerPage, String keyword, String searchType) {
		int from = (page - 1) * rowPerPage;
		
		return mapper.listBoardPage(from, rowPerPage, keyword, searchType);
	}

	public int countBoard(String keyword, String searchType) {
		return mapper.countBoard(keyword, searchType);
	}
	

}
