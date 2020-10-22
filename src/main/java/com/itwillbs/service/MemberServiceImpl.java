package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 해당 클래스를 서비스 객체로 처리 하겠다.(스프링에서 인식)

@Service
public class MemberServiceImpl implements MemberService{
	
	// DB처리하기위한 객체 주입
	@Inject
	private MemberDAO mdao;
	
	
	@Override
	public void insertMember(MemberVO vo) {
		// 컨트롤러 -> 서비스 를 호출 -> DAO 를 호출 -> Mapper -> DB
		System.out.println("Service : 회원가입 동작");
		if(vo == null) {
			// 처리
			
			
			
			return;
		}
		
		mdao.insertMember(vo);
	}



	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("S : 컨트롤러에서 호출");
		System.out.println("S : 필요한 정보를 받아서 DAO 전달");
		
		MemberVO returnVO = null;
		// DAO 객체 생성 (DI)
		try {
			returnVO = 
			mdao.readMemberWithIDPW(vo.getUserid(), vo.getUserpw());
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null;
		}
		
		return returnVO;
	}



	@Override
	public MemberVO readMember(String id) {
		System.out.println("S : readMember(id) 호출");
		System.out.println("S : DAO 객체 생성(DI)-메서드 호출");
		
		MemberVO vo = null;
		try {
			vo = mdao.readMember(id);
			
			System.out.println("S : DAO 처리 완료, 정보 리턴");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("S : updateMember(vo) 호출");
		System.out.println("S : DAO 객체 생성후 메서드 호출");
		
		mdao.updateMember(vo);
		
		System.out.println("S : 수정완료");
	}

	@Override
	public void deleteMember(String id) {
		
			try {
				mdao.deleteMember(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		System.out.println("S : 삭제완료");
	}
	
	
	
}
