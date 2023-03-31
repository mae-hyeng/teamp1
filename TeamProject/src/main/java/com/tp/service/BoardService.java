package com.tp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tp.DTO.BoardDTO;
import com.tp.entity.Board;
import com.tp.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

// DTO瑜� Entity 濡� 蹂��솚�븯嫄곕굹(entity�겢�옒�뒪�뿉�꽌 �옉�뾽)
// Entity瑜� DTO濡� 蹂��솚�븯�뒗 �옉�뾽 怨듦컙(dto �겢�옒�뒪�뿉�꽌 �옉�뾽)

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	public void save(Board board) {
		
		boardRepository.save(board);
		
	}

	public List<Board> Content() {
		
		List<Board> boardlist = boardRepository.findAll();
		List<BoardDTO> boarddtolist = new ArrayList<>();
		
		for(Board board : boardlist) {
			BoardDTO boardDTO = BoardDTO.builder()
					.num(board.getNum())
					.content(board.getContent())
					.genre(board.getGenre())
					.hit(board.getHit())
					.regdate(board.getRegdate())
					.title(board.getTitle())
					.writer(board.getWriter())
					.build();
			boarddtolist.add(boardDTO);
		}
		
		return boardlist;
	}
//	
//	public Page<Board> list(int page) {
//		return boardRepository.findAll(PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC)));
//	}
	
}
