package first.member.model.service;

import static first.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import first.member.model.dao.MemberDao;
import first.member.model.vo.Member;

public class MemberService {
	
	public MemberService() {}

	public ArrayList<Member> selectAll() {
		Connection con = getConnection();
		ArrayList<Member> list = new MemberDao().selectAll(con);
		close(con);
		return list;
	}
}
