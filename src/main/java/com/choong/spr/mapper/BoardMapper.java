package com.choong.spr.mapper;

import java.util.List;

import com.choong.spr.domain.BoardDto;

public interface BoardMapper {

	List<BoardDto> listBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int removeBoardById(int id);

	int addBoard(BoardDto board);

}
