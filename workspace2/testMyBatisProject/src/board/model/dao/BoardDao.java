package board.model.dao;

import board.model.vo.Board;
import board.model.vo.BoardPage;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
	public BoardDao(){}

	public int getListCount() {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.selectOne("board.getListCount");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public ArrayList<Board> selectList(BoardPage bPage) {
		ArrayList<Board> list = null;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			list = new ArrayList<Board>(session.selectList("board.selectList", bPage));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return list;
	}

	public int insertBoard(Board b) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			if(b.getBoardOriginalFileName()!=null)
				result = session.insert("board.insertBoard", b);
			else
				result = session.insert("board.insertBoard2", b);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public int addReadCount(int bnum) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.insert("board.addReadCount", bnum);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public Board selectBoard(int bnum) {
		Board board = null;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			board = session.selectOne("board.selectBoard", bnum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return board;
	}

	public int deleteBoard(int bnum) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.delete("board.deleteBoard", bnum);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public int updateReplySeq(Board replyBoard) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.update("board.updateReplySeq", replyBoard);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public int insertReply(Board replyBoard) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			if(replyBoard.getBoardLevel() == 1){ // 원글의 댓글
				result = session.insert("board.insertReply1", replyBoard);
			}			
			if(replyBoard.getBoardLevel() == 2){ // 대댓글
				result = session.insert("board.insertReply2", replyBoard);
			}			
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}			
		return result;
	}

	public int updateReply(Board reply) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.update("board.updateReply", reply);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public int updateBoard(Board b) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.update("board.updateBoard", b);
			if(result>0) session.commit();
			else session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}

	public ArrayList<Board> selectTop3() {
		ArrayList<Board> list = null;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			list = new ArrayList<Board>(session.selectList("board.selectTop3"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
}

