package com.greedy.comprehensive.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.comprehensive.board.dto.AttachmentDTO;
import com.greedy.comprehensive.board.dto.BoardDTO;
import com.greedy.comprehensive.board.dto.ReplyDTO;
import com.greedy.comprehensive.common.paging.SelectCriteria;

@Mapper
public interface BoardMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<BoardDTO> selectBoardList(SelectCriteria selectCriteria);

	int incrementBoardCount(Long no);

	BoardDTO selectBoardDetail(Long no);

	void insertReply(ReplyDTO reply);

	List<ReplyDTO> selectReplyList(ReplyDTO reply);

	void deleteReply(ReplyDTO reply);

	void insertBoard(BoardDTO board);

	void insertThumbnailContent(BoardDTO board);

	void insertAttachment(AttachmentDTO attachment);

	int selectThumbnailTotalCount();

	List<BoardDTO> selectThumbnailBoardList(SelectCriteria selectCriteria);

	BoardDTO selectThumbnailBoardDetail(Long no);

}
