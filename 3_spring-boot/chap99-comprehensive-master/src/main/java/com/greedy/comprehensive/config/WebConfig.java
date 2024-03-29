package com.greedy.comprehensive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/* WebMvcConfigurer : WebMvc와 관련 된 설정을 할 수 있는 메소드가 default 메소드로 선언 된 인터페이스 */
	
	/* addResourceHandlers : 정적 리소스와 관련하여 static 경로는 기본으로 설정되어 있으므로 추가적인 정적 리소스 경로를 설정할 때 사용 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		/* upload 경로를 추가하여 업로드 된 이미지를 정적 리소스로 요청할 수 있게 한다. */
		registry.addResourceHandler("/upload/**")
			.addResourceLocations("classpath:/upload/");
		
	}

	
	
}









