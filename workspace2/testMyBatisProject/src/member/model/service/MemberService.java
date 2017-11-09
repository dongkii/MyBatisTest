package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import java.sql.*;
import java.util.ArrayList;

public class MemberService {
	public MemberService(){}
	
	//로그인 처리용 메소드
	public Member loginCheck(Member member){
		return new MemberDao().selectMember(member);
	}
	
	//회원 정보 조회 처리용 메소드
	public Member selectMember(String userId){
		return new MemberDao().selectMember(userId);
	}

	//회원 정보 수정 처리용 메소드
	public int updateMember(Member member) {
		return new MemberDao().updateMember(member);
	}

	public int insertMember(Member member) {
		return new MemberDao().insertMember(member);
	}

	public int deleteMember(String userId) {
		return new MemberDao().deleteMember(userId);
	}

	public ArrayList<Member> selectAll() {
		return new MemberDao().selectList();
	}
	
}


















