package com.tp.test;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tp.entity.Board;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class RepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void Insert() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			Board board = Board.builder().content("Test").build();
			boardRepository.save(board);
		});
	}
	
}
