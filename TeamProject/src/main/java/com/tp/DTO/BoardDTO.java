package com.tp.DTO;

import java.sql.Timestamp;

import javax.persistence.Column;

import com.tp.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {

	private Long num;
	private String genre;
	private String writer;
	private String title;
	private String content;
	private Timestamp regdate;
	private int hit;
	
	public static Board toEntity(final BoardDTO dto) {
		return Board.builder()
				.num(dto.getNum())
				.genre(dto.getGenre())
				.writer(dto.getWriter())
				.title(dto.getTitle())
				.content(dto.getContent())
				.regdate(dto.getRegdate())
				.hit(0)
				.build();
	}
}
