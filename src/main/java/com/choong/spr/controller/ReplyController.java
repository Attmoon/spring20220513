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
	private ReplyService service;
	
	@PostMapping("reply/add")
	public String addReply(ReplyDto reply) {
		service.addReply(reply);
		
		return "redirect:/project/board/" + reply.getBoardId();
	}
	
	@PostMapping("reply/remove")
	public String removeReply(ReplyDto reply) {
		service.removeReplyById(reply.getId());
		
		return "redirect:/project/board/" + reply.getBoardId();
	}
	
	@PostMapping("reply/modify")
	public String modifyReply(ReplyDto reply) {
		service.modifyReply(reply);
		
		return "redirect:/project/board/" + reply.getBoardId(); 
	}
}
