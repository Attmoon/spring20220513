package com.choong.spr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.ReplyService;

@Controller
@RequestMapping("project")
public class ReplyController {
	
	@Autowired
	private ReplyService service; // ReplyService로부터 데이터를 받아오기위해 선언
	
	// /project/reply/add 경로로 post방식의 요청이 날아오면 
	// ReplyDto형식으로 추가할 reply내용을 얻어온뒤에
	// /project/board/ + reply.getBoardId() 경로로 redirect시킴
	// 이때 BoardId는 board_id컬럼을 BoardId라는 별칭으로 바꿔준것.
	@PostMapping("reply/add")
	public String addReply(ReplyDto reply) {
		service.addReply(reply);
		
		return "redirect:/project/board/" + reply.getBoardId();
	}
	
	// /project/reply/remove 경로로 post방식의 요청이 날아오면
	// ReplyDto형식으로 지울 reply의 id를 얻어서 지운뒤에
	// /project/board/" + reply.getBoardId() 경로로 redirect시킴
	@PostMapping("reply/remove")
	public String removeReply(ReplyDto reply) {
		service.removeReplyById(reply.getId());
		
		return "redirect:/project/board/" + reply.getBoardId();
	}
	
	// /project/reply/modify 경로로 post방식의 요청이 날아오면
	// ReplyDto형식으로 수정할 reply내용을 얻어온뒤에
	// /project/board/" + reply.getBoardId() 경로로 redirect시킴
	@PostMapping("reply/modify")
	public String modifyReply(ReplyDto reply) {
		service.modifyReply(reply);
		
		return "redirect:/project/board/" + reply.getBoardId(); 
	}
}
