package com.choong.spr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.choong.spr.domain.BoardDto;

public interface BoardMapper {

//	List<BoardDto> listBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int removeBoardById(int id);

	int addBoard(BoardDto board);
	
	// 2개이상 파라미터가 있을때는 컴파일할때 잃어버리는 이름을 유지할수있도록 param어노테이션 붙여야함
	List<BoardDto> listBoardPage(@Param("from") int from, @Param("row") int row);

	int countBoard();

}
