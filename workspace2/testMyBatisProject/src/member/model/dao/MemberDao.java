package member.model.dao;

import member.model.vo.Member;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MemberDao {	
	
	public MemberDao(){}
	
	//로그인 조회 처리용
	public Member selectMember(Member m){
		Member member = null;
		SqlSession session = null;		
		
		try {
			/*마이바티스 config 설정파일의 내용을 읽어서 db 연결하고,
			 * statement 객체 생성과 동일한 의미를 가진 코드임*/
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			//매퍼 파일 안에 작성된 쿼리문 실행시키고 결과 받음
			member = session.selectOne("member.selectMember", m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return member;
	}

	public int updateMember(Member member) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.update("member.updateMember", member);	
			
			if(result > 0)	session.commit();
			else		session.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	//회원 정보 조회 처리용
	public Member selectMember(String userId) {
		Member member = null;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			member = session.selectOne("member.selectInfo", userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return member;
	}

	public int insertMember(Member member) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.insert("member.insertMember", member);
			
			if(result > 0)	session.commit();
			else session.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		
		return result;
	}

	public int deleteMember(String userId) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.insert("member.deleteMember", userId);
			
			if(result > 0)	session.commit();
			else session.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	public ArrayList<Member> selectList() {
		List<Member> list = null;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			list = session.selectList("member.selectAll");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return (ArrayList<Member>)list;
	}
}