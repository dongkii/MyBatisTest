package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {
	public NoticeService(){}
	
	public ArrayList<Notice> selectList(){
		return new NoticeDao().selectList();
	}

	public Notice selectNotice(int no) {
		return new NoticeDao().selectOne(no);
	}

	public void addReadCount(int no) {
		new NoticeDao().updateReadCount(no);
	}

	public int insertNotice(Notice notice) {
		return new NoticeDao().insertNotice(notice);
	}

	public int deleteNotice(int no) {
		return new NoticeDao().deleteNotice(no);
	}

	public int updateNotice(Notice notice) {
		return new NoticeDao().updateNotice(notice);
	}

	public ArrayList<Notice> selectSearch(String keyword) {
		return new NoticeDao().selectTitleSearch(keyword);
	}
	
	
}