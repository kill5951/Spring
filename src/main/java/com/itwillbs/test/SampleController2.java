package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	
	// 로그정보 처리 객체
	private static final Logger logger
			= LoggerFactory.getLogger(SampleController2.class);
	
	// 메서드를 사용해서 특정 주소에 따른 처리
	// *메서드 리턴타입이 String일때 [리턴되는 문자열.jsp] 페이지 호출
	// -> 주소와 보여지는 뷰페이지 이름이 다름.
	// 
	
	// http://localhost:8080/test/doC
	@RequestMapping("doC")
	public String doC() {
		logger.info("doC() 메서드 호출@@@@");
		
		//return "abc";
		return "home";
	}
	
	// doC.jsp 페이지로 이동(파라미터 정보를 가지고 이동)
	// http://localhost:8080/test/doC1
	// http://localhost:8080/test/doC1?msg="hello"
	@RequestMapping(value = "doC1")
	public String doC1(@ModelAttribute("msg")String msg) {
		// Spring에서 지원하는 에노테이션을 통해서 해당 파라미터값 전달
		
		logger.info("파라미터 : "+msg);
		
		return "doC";
	}
		
	// 주소 : ../test/doTotalC
	// 파라미터값 2개 전달 : name="사용자",tel=010-1234-4567
	// 정보확인 페이지 : total.jsp
	
	// http://localhost:8080/test/doTotalC?name="사용자"&tel="010-1234-4567"
	@RequestMapping("doTotalC")
	public String doTotal(@ModelAttribute("name")String name, @ModelAttribute("tel")String tel) {
		
		logger.info("주소 : /test/doTotalC dototal() 호출");
		
		return "total";
	}
	
		
}
