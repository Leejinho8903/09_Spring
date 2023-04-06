package com.greedy.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@PropertySource("classpath:config/common.properties")
public class FileUploadController {
	
	@Value("${file.path}")
	private String filePath;

	@PostMapping("/single-file")
	public String singleFileUpload(@RequestParam MultipartFile singleFile,
			@RequestParam String singleFileDescription, Model model) {
		
		/* 파일 업로드 관련 라이브러리 추가 - pom.xml 의존성 추가 
		 * 1. commons-io
		 * 2. commons-fileupload
		 * 
		 * CommonsMultipartResolver - servlet-context.xml에 bean 등록
		 * 
		 * multipart로 전송 된 요청에 대한 인코딩 처리를 해주어야 하는데 일반 인코딩 필터보다 구현하기 어려우므로
		 * 스프링에서 제공하는 인코딩 필터를 사용해서 설정 - web.xml 추가
		 * */
		
		System.out.println(singleFile);
		System.out.println(singleFile.getOriginalFilename());
		System.out.println(singleFileDescription);
		System.out.println(filePath);
		
		/* 파일을 저장할 경로가 있는지 확인하여 없으면 생성하는 구문 */
		File mkdir = new File(filePath);
		if(!mkdir.exists()) mkdir.mkdirs();
		
		/* 파일명을 고유한 값으로 변경하는 처리 - 원본 파일명 사용시 중복되면 겹쳐쓰기 될 가능성이 있음 */
		String originalFileName = singleFile.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedName = UUID.randomUUID().toString() + ext;
		
		System.out.println("savedName : " + savedName);
		
		/* 파일을 저장 */
		try {
			singleFile.transferTo(new File(filePath + "/" + savedName));
			model.addAttribute("message", "파일 업로드가 완료 되었습니다.");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "result";
	}
	
	@PostMapping("multi-file")
	public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
			@RequestParam String multiFileDescription, Model model) {
		
		System.out.println("multiFiles : " + multiFiles);
		System.out.println("multiFileDescription : " + multiFileDescription);
		
		/* 파일을 저장할 경로가 있는지 확인하여 없으면 생성하는 구문 */
		File mkdir = new File(filePath);
		if(!mkdir.exists()) mkdir.mkdirs();
		
		/* 파일과 관련 된 정보를 추출하여 보관하고 추후에는 DB에 insert할 때 전달 */
		List<Map<String, String>> files = new ArrayList<>();
		
		for(MultipartFile file : multiFiles) {
			
			/* 파일명 변경 처리 */
			String originalFileName = file.getOriginalFilename();
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			String savedName = UUID.randomUUID().toString() + ext;
			
			/* 1개의 파일에 대한 정보를 Map에 보관 */
			Map<String, String> fileInfo = new HashMap<>();
			fileInfo.put("originalFileName", originalFileName);
			fileInfo.put("savedName", savedName);
			fileInfo.put("filePath", filePath);
			
			/* 여러 개의 파일 정보 보관하는 List에 Map 추가 */
			files.add(fileInfo);
		}
		
		try {
			/* 파일 저장 */
			for(int i = 0; i < multiFiles.size(); i++) {
				multiFiles.get(i).transferTo(new File(filePath + "/" + files.get(i).get("savedName")));
			}
			
			model.addAttribute("message", "다중 파일 업로드가 완료되었습니다.");
		} catch (IllegalStateException | IOException e) {
			/* 업로드 실패 시 이전에 저장된 파일을 삭제한다. - 서버에 저장할 필요가 없음 */
			for(Map<String, String> fileInfo : files) {
				new File(filePath + "/" + fileInfo.get("savedName")).delete();
			}
			
			model.addAttribute("message", "다중 파일 업로드에 실패하였습니다.");
		}
		
		return "result";
	}
	
	
	
	
	
	
}















