package com.choong.spr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.ReplyDto;
import com.choong.spr.mapper.ReplyMapper;

@Service
public class ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	public boolean addReply(ReplyDto reply) {
		
		int cnt = mapper.addReply(reply);
		
		return cnt == 1;
	}

	public List<ReplyDto> listReplyByBoardId(int BoardId) {
		return mapper.selectReplyByBoardId(BoardId);
	}

	public boolean removeReplyById(int id) {
		int cnt = mapper.deleteReplyById(id);
		return cnt == 1;
		
	}

	public boolean modifyReply(ReplyDto reply) {
		int cnt = mapper.updateReply(reply);
		
		return cnt == 1;
	}

}
