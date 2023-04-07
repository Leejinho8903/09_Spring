package com.greedy.comprehensive.board.dto;

import lombok.Data;

@Data
public class AttachmentDTO {
	
    private Long no;
    private Long refBoardNo;
    private String originalName;
    private String savedName;
    private String savePath;
    private String fileType;
    private String thumbnailPath;
    private String status;

}
