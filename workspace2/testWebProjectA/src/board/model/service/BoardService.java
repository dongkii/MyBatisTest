package board.model.service;

import java.sql.*;
import java.util.*;
import board.model.vo.Board;
import board.model.vo.BoardPage;
import board.model.dao.BoardDao;

public class BoardService {
	public BoardService(){}
	
	public int getListCount(){
		return new BoardDao().getListCount();
	}
	
	public ArrayList<Board> selectList(BoardPage bPage){
		return new BoardDao().selectList(bPage);
	}

	public int insertBoard(Board b) {
		return new BoardDao().insertBoard(b);
	}

	public void addReadCount(int bnum) {
		new BoardDao().addReadCount(bnum);
	}
	
	public Board selectBoard(int bnum){
		return new BoardDao().selectBoard(bnum);
	}

	public int deleteBoard(int bnum) {
		return new BoardDao().deleteBoard(bnum);
	}

	public void updateReplySeq(Board replyBoard) {
		new BoardDao().updateReplySeq(replyBoard);
	}

	public int insertReply(Board replyBoard) {
		return new BoardDao().insertReply(replyBoard);
	}

	public int updateReply(Board reply) {
		return new BoardDao().updateReply(reply);
	}

	public int updateBoard(Board b) {
		return new BoardDao().updateBoard(b);
	}

	public ArrayList<Board> selectTop3() {
		return new BoardDao().selectTop3();
	}
}















