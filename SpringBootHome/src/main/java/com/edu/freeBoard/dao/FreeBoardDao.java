package com.edu.freeBoard.dao;

import java.util.List;
import java.util.Map;

import com.edu.freeBoard.domain.FreeBoardVo;

public interface FreeBoardDao {
	//게시물 전체 조회
	public List<FreeBoardVo> freeBoardSelectList(int start, int end);
	// 게시물 페이징 준비물
	public int freeBoardSelectTotalCount();
	// 게시물 추가 단일
	public void freeBoardInsertOne(FreeBoardVo freeBoardVo);
	
	public FreeBoardVo freeBoardSelectOne(int freeBoardId);
	public void freeBoardUpdateOne(FreeBoardVo freeBoardVo);
	
	public void freeBoardFileInsertOne(Map<String, Object> map);
}
