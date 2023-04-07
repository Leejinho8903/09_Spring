package com.greedy.comprehensive.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.comprehensive.board.dao.BoardMapper;
import com.greedy.comprehensive.board.dto.AttachmentDTO;
import com.greedy.comprehensive.board.dto.BoardDTO;
import com.greedy.comprehensive.board.dto.ReplyDTO;
import com.greedy.comprehensive.common.paging.Pagenation;
import com.greedy.comprehensive.common.paging.SelectCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BoardService {
	
	private final BoardMapper boardMapper;
	
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	public Map<String, Object> selectBoardList(Map<String, String> searchMap, int page) {
		
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = boardMapper.selectTotalCount(searchMap);
		log.info("[BoardService] totalCount : {}", totalCount);
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 10;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[BoardService] selectCriteria : {}", selectCriteria);
		
		/* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
		List<BoardDTO> boardList = boardMapper.selectBoardList(selectCriteria);
		log.info("[BoardService] boardList : {}", boardList);
		
		Map<String, Object> boardListAndPaging = new HashMap<>();
		boardListAndPaging.put("paging", selectCriteria);
		boardListAndPaging.put("boardList", boardList);
		
		return boardListAndPaging;
	}

	public BoardDTO selectBoardDetail(Long no) {
		
		/* 1. 조회수 증가 로직 */
		int result = boardMapper.incrementBoardCount(no);
		
		/* 2. 게시글 상세 내용 조회 후 리턴 */
		return boardMapper.selectBoardDetail(no);
	}

	public void registReply(ReplyDTO reply) {
		
		boardMapper.insertReply(reply);
		
	}

	public List<ReplyDTO> loadReply(ReplyDTO reply) {
		
		return boardMapper.selectReplyList(reply);
	}

	public void removeReply(ReplyDTO reply) {
		
		boardMapper.deleteReply(reply);
		
	}

	/* 게시글 등록 서비스 메소드 */
	public void registBoard(BoardDTO board) {
		
		boardMapper.insertBoard(board);
		
	}

	public void registThumbnail(BoardDTO board) {
		
		/* 1. Board 테이블에 데이터 저장 */
		boardMapper.insertThumbnailContent(board);
		
		/* 2. Attachment 테이블에 데이터 저장(첨부된 파일만큼) */
		for(AttachmentDTO attachment : board.getAttachmentList()) {
			boardMapper.insertAttachment(attachment);
		}
		
	}

	public Map<String, Object> selectThumbnailList(int page) {
		
		int totalCount = boardMapper.selectThumbnailTotalCount();
		log.info("[ThumbmailService] totalCount : {}", totalCount);
		
		int limit = 9;
		int buttonAmount = 5;
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[ThumbmailService] selectCriteria : {}", selectCriteria);
		
		List<BoardDTO> thumbnailList = boardMapper.selectThumbnailBoardList(selectCriteria);
		log.info("[ThumbmailService] thumbnailList : {}", thumbnailList);
		
		Map<String, Object> thumbnailListAndPaging = new HashMap<>();
		thumbnailListAndPaging.put("paging", selectCriteria);
		thumbnailListAndPaging.put("thumbnailList", thumbnailList);
		
		return thumbnailListAndPaging;
	}

	public BoardDTO selectThumbnailDetail(Long no) {
		
		int result = boardMapper.incrementBoardCount(no);
		
		log.info("[BoardService] result : {}", result);
		
		return boardMapper.selectThumbnailBoardDetail(no);
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
