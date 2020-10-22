package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {
	// 로그정보 처리 객체
	private static final Logger logger
			= LoggerFactory.getLogger(SampleController5.class);
	
	// http://localhost:8080/test/doJSON
	// JSON 데이터 처리 => REST API
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		
		//@ResponseBody : 리턴하는 객체의정보를 JSON타입으로 변경해서 리턴
		
		logger.info("doJSON() 실행!");
		
		ProductVO vo = new ProductVO("test", 1234);
		
		
		return vo;
	}
	
	
	
}
