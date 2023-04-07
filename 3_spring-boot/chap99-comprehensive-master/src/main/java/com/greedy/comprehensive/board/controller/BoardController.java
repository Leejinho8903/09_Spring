package com.greedy.comprehensive.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.comprehensive.board.dto.BoardDTO;
import com.greedy.comprehensive.board.dto.ReplyDTO;
import com.greedy.comprehensive.board.service.BoardService;
import com.greedy.comprehensive.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public BoardController(BoardService boardService, MessageSourceAccessor messageSourceAccessor) {
		this.boardService = boardService;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	@GetMapping("/list")
	public String boardList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[BoardController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[BoardController] searchMap : {}", searchMap);
		
		Map<String, Object> boardListAndPaging = boardService.selectBoardList(searchMap, page);
		model.addAttribute("paging", boardListAndPaging.get("paging"));
		model.addAttribute("boardList", boardListAndPaging.get("boardList"));
		
		return "board/boardList";
	}
	
	@GetMapping("/detail")
	public String selectBoardDetail(@RequestParam Long no, Model model) {
		
		BoardDTO boardDetail = boardService.selectBoardDetail(no);
		log.info("[BoardController] boardDetail : {}", boardDetail);
		
		model.addAttribute("board", boardDetail);
		
		return "board/boardDetail";
	}
	
	@PostMapping("/registReply")
	public ResponseEntity<String> registReply(@RequestBody ReplyDTO registReply,
			@AuthenticationPrincipal MemberDTO member) {
		
		registReply.setWriter(member);	// 댓글 작성자는 로그인 유저이므로 설정
		log.info("[BoardController] registReply : {}", registReply);
		
		boardService.registReply(registReply);		
		
		return ResponseEntity.ok("댓글 등록 완료");
	}
	
	@GetMapping("/loadReply")
	public ResponseEntity<List<ReplyDTO>> loadReply(ReplyDTO loadReply) {
		
		log.info("[BoardController] loadReply : {}", loadReply);
		
		List<ReplyDTO> replyList = boardService.loadReply(loadReply);
		
		log.info("[BoardController] replyList : {}", replyList);
		
		return ResponseEntity.ok(replyList);
	}
	
	@PostMapping("/removeReply")
	public ResponseEntity<String> removeReply(@RequestBody ReplyDTO removeReply) {
		
		log.info("[BoardController] removeReply : {}", removeReply);
		
		boardService.removeReply(removeReply);
		
		return ResponseEntity.ok("댓글 삭제 완료");
		
	}
	
	@GetMapping("/regist")
	public String goRegist() {
		
		return "board/boardRegist";
	}
	
	/* 게시글 등록 컨트롤러 핸들러 메소드 */
	@PostMapping("/regist")
	public String registBoard(BoardDTO board, @AuthenticationPrincipal MemberDTO member,
			RedirectAttributes rttr) {
		
		board.setWriter(member);
		log.info("[BoardController] board : {}", board);
		
		boardService.registBoard(board);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("board.regist"));
		
		return "redirect:/board/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
