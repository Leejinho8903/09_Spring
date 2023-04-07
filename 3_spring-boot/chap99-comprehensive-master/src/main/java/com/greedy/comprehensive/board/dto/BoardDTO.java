package com.greedy.comprehensive.board.dto;

import java.sql.Date;
import java.util.List;

import com.greedy.comprehensive.member.dto.MemberDTO;

import lombok.Data;

@Data
public class BoardDTO {
    
	private Long no;
    private Integer type;
    private Long categoryCode;
    private CategoryDTO category;
    private String title;
    private String body;
    private Long writerMemberNo;
    private MemberDTO writer;		            // MemberTable과 join하는 경우 1:1 조인이 될 것이기 때문에 MemberDTO 타입으로 생성
    private int count;
    private Date createdDate;
    private Date modifiedDate;
    private String status;
    private List<ReplyDTO> replyList; 			// ReplyTable과 join하는 경우 1:N 조인이 될 것이기 때문에 List<ReplyDTO> 타입으로 생성
    private List<AttachmentDTO> attachmentList; // AttachmentTable과 join하는 경우 1:N 조인이 될 것이기 때문에 List<AttachmentDTO> 타입으로 생성

}
