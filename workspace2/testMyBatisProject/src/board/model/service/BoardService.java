package board.model.service;

import java.sql.*;
import java.util.*;
import board.model.vo.Board;
import board.model.vo.BoardPage;
import board.model.dao.BoardDao;

public class BoardService {
	public BoardService(){}
	
	//전체 게시글 갯수 조회용
	public int getListCount(){
		return new BoardDao().getListCount();
	}
	
	//페이지별 목록 조회용
	public ArrayList<Board> selectList(BoardPage bp){
		return new BoardDao().selectList(bp);
	}

	//원글 등록 처리용
	public int insertBoard(Board b) {
		return new BoardDao().insertBoard(b);
	}

	public void addReadCount(int bnum) {
		return new BoardDao().addReadCount(bnum);
	}
	
	public Board selectBoard(int bnum){
		return new BoardDao().selectBoard(bnum);
	}

	public int deleteBoard(int bnum) {
		return new BoardDao().deleteBoard(bnum);
	}

	public void updateReplySeq(Board replyBoard) {
		return new BoardDao().updateReplySeq(replyBoard);
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















