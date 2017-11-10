package notice.model.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.vo.Board;
import member.model.dao.MemberDao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao(){}
	
	public ArrayList<Notice> selectList(){
		ArrayList<Notice> list = null;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			list = new ArrayList<Notice>(session.selectList("notice.selectList"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return list;
	}

	public Notice selectOne(int no) {
		Notice notice = null;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			notice = session.selectOne("notice.selectOne", no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return notice;
	}

	public int updateReadCount(int no) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.update("notice.updateReadCount", no);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public int insertNotice(Notice notice) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			if(notice.getOriginalFileName()!=null)
				result = session.insert("notice.insertNotice", notice);
			else
				result = session.insert("notice.insertNotice2", notice);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public int deleteNotice(int no) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.insert("notice.deleteNotice", no);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}
	

	public int updateNotice(Notice notice) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			if(notice.getOriginalFileName()!=null)
				result = session.update("notice.updateNotice", notice);
			else
				result = session.update("notice.updateNotice2", notice);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return result;
	}

	public ArrayList<Notice> selectTitleSearch(String keyword) {
		ArrayList<Notice> list = null;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			list = new ArrayList<Notice>(session.selectList("notice.selectTitleSearch", "%" + keyword + "%"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}	
		return list;
	}	
	
}