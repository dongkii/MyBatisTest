package board.model.dao;

import board.model.vo.Board;
import board.model.vo.BoardPage;
import member.model.dao.MemberDao;
import java.sql.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
	
	public BoardDao(){	}

	public int getListCount() {
		// 총 게시글 갯수 조회용
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.selectOne("board.selecCount");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	public ArrayList<Board> selectList(BoardPage bp) {
		// 한 페이지에 출력할 게시글 목록 조회용
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//currentPage 에 해당되는 목록만 조회
		/*String query ="select * from ("
				+ "select rownum rnum, board_num, board_title, "
				+ "board_writer, board_content, board_original_filename, "
				+ "board_rename_filename, board_date, board_level, "
				+ "board_ref, board_reply_ref, board_reply_seq, "
				+ "board_readcount from (select * from board "
				+ "order by board_ref desc, board_reply_ref desc, "
				+ "board_level asc, board_reply_seq asc)) "
				+ "where rnum >= ? and rnum <= ?";*/
		String query = prop.getProperty("selectList");
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<Board>();
				
				while(rset.next()){
					Board b = new Board();
					
					b.setBoardNum(rset.getInt("board_num"));
					b.setBoardTitle(rset.getString("board_title"));
					b.setBoardWriter(rset.getString("board_writer"));
					b.setBoardContent(rset.getString("board_content"));
					b.setBoardDate(rset.getDate("board_date"));
					b.setBoardReadCount(rset.getInt("board_readcount"));
					b.setBoardOriginalFileName(rset.getString("board_original_filename"));
					b.setBoardRenameFileName(rset.getString("board_rename_filename"));
					b.setBoardLevel(rset.getInt("board_level"));
					b.setBoardRef(rset.getInt("board_ref"));
					b.setBoardReplyRef(rset.getInt("board_reply_ref"));
					b.setBoardReplySeq(rset.getInt("board_reply_seq"));
					
					list.add(b);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertBoard(Board b) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.insert("board.inserrBoard", b);
			
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
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.update("board.addReadCount", bnum);
			
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
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
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
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.delete("board.deleteBoard", bnum);
			
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
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.update("board.updateReplySeq", replyBoard);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	public int insertReply(Board replyBoard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		//원글의 댓글일 때
		if(replyBoard.getBoardLevel() == 1){
			/*query = "insert into board values ("
					+ "(select max(board_num) + 1 from board), "
					+ "?, ?, ?, null, null, sysdate, default, ?, ?, "
					+ "(select max(board_num) + 1 from board), "
					+ "1)";*/
			query = prop.getProperty("insertReply1");
		}
		
		//댓글의 댓글일 때
		if(replyBoard.getBoardLevel() == 2){
			/*query = "insert into board values ("
					+ "(select max(board_num) + 1 from board), "
					+ "?, ?, ?, null, null, sysdate, default, ?, ?, ?, "
					+ "1)";*/
			query = prop.getProperty("insertReply2");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, replyBoard.getBoardTitle());
			pstmt.setString(2, replyBoard.getBoardWriter());
			pstmt.setString(3, replyBoard.getBoardContent());
			pstmt.setInt(4, replyBoard.getBoardLevel());
			pstmt.setInt(5, replyBoard.getBoardRef());
			
			if(replyBoard.getBoardLevel() == 2)
				pstmt.setInt(6, replyBoard.getBoardReplyRef());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int updateReply(Board reply) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.update("board.updateReply", reply);
			
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
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
			
			result = session.update("board.updateBoard", b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	public ArrayList<Board> selectTop3(Connection con) {
		ArrayList<Board> list = null;
		Statement stmt = null;
		ResultSet rset = null;

		/*String query = "select * from " 
				+ "(select rownum rnum, board_num, " 
				+ "BOARD_TITLE "
				+ "from (select * from board "
				+ "where board_level = 0 " 
				+ "order by board_readcount desc)) " 
				+ "where rnum >= 1 and rnum <= 3";		*/
		String query = prop.getProperty("selectTop3");

		try {
			stmt = con.createStatement();		

			rset = stmt.executeQuery(query);
			if (rset != null) {
				list = new ArrayList<Board>();
				while (rset.next()) {
					Board b = new Board();
					b.setBoardNum(rset.getInt("board_num"));
					b.setBoardTitle(rset.getString("board_title"));
					
					list.add(b);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}
	
	
}
