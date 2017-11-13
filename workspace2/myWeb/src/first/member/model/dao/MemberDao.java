package first.member.model.dao;

import java.sql.*;
import java.util.ArrayList;

import first.member.model.vo.Member;

import static first.common.JDBCTemplate.*;

public class MemberDao {

	public MemberDao() {}
	
	public ArrayList<Member> selectAll(Connection con) {
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM TEST_MEMBER";
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				while(rset.next()) {
					list.add(new Member(rset.getString("ID"),rset.getString("PASSWD"),
							rset.getString("NAME"),rset.getString("EMAIL")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

}
