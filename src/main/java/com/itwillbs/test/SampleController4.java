package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController4 {
	// 로그정보 처리 객체
	private static final Logger logger
			= LoggerFactory.getLogger(SampleController4.class);

	// * 페이지 이동 redirect 동작
	// 메서드 String 리턴시 이동할 주소앞에 "redirect:" 
	
	
	// http://localhost:8080/test/doE
	@RequestMapping("/doE")
	public String doE(Model model,RedirectAttributes rttr) {
		logger.info("doE() 호출");
		
		//model.addAttribute("msg", "1234doE!");
		//model.addAttribute("1234doE");
		
		//model.addAttribute("msg", new ProductVO("test",1234));
		// -> redirect: 전달 X
		
		//rttr.addAttribute("msg", "Add!!!!!");
		rttr.addFlashAttribute("msg", "flash!!!!");
		
		// * RedirectAttributes 객체 : URI에 보이지 않게 데이터 전달
		// addAttribute() : 	URI에 표시 O, EL표현식 O, jsp표현식 O, F5(새로고침) 계속유지
		// addFlashAttribute() : URI에 표시 X, EL표현식 O, jsp표현식 X, F5(새로고침) 1회성 데이터
		
		//return "doF";
		//return "redirect:/doF"; // 주소변경O, 페이지이동
		//return "forward:/doF"; // 주소변경X, 페이지이동 
		
		//return "redirect:/doF?msg=test1234";
		//return "redirect:/doF?msg="+test;
		return "redirect:/doF";
		// -> model.addAttribute(); 데이터전달할때
		// 저장한 데이터는 파라미터형태로 전달이 된다.
	}
	
	// http://localhost:8080/test/doF
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg")String msg) {
		logger.info("doF() 호출");
		
	}
	
}
