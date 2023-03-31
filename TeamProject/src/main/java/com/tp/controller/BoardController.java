package com.tp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.DTO.BoardDTO;
import com.tp.entity.Board;
//import com.tp.entity.BoardVO;
import com.tp.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardservice;
	
	@RequestMapping("/board")
	public String main(Model model) {
		
		List<Board> list = boardservice.Content();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("register")
	public String write() {
		return "board/register";
	}
	
	@GetMapping("/save")
	public String saveForm() {
		return "board/list";
	}
	
	@PostMapping("/save")
	public String postsave(Board board) {
		
		boardservice.save(board);
		
		return "board/list";
		
	}
	
//	@RequestMapping("/board/list")
//	public List<BoardVO> blist() {
//		return boardservice.getAllList();
//	}
}
