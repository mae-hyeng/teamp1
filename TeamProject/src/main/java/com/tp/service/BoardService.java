package com.tp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tp.DTO.BoardDTO;
import com.tp.entity.Board;
import com.tp.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

// DTO를 Entity 로 변환하거나(entity클래스에서 작업)
// Entity를 DTO로 변환하는 작업 공간(dto 클래스에서 작업)

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	public void save(Board board) {
		
		boardRepository.save(board);
		
	}

	public List<BoardDTO> Content() {
		
		List<Board> boardlist = boardRepository.findAll();
		List<BoardDTO> dtolist = new ArrayList<>();
		
		for(BoardDTO dto : dtolist) {
			Board board2 = Board.builder()
					.num(dto.getNum())
					.content(dto.getContent())
					.genre(dto.getGenre())
					.title(dto.getTitle())
					.writer(dto.getWriter())
					.regdate(dto.getRegdate()).build();
		}
		
		return dtolist;
	}
	
}
