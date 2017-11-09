package common;

import java.sql.*;
/*import javax.naming.*;
import javax.sql.*;*/
import java.util.*;
import java.io.*;


public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");*/
			
			//context.xml resource 앨리먼트 값으로 db 연결 처리
			//톰켓이 제공하는 dbcp(database connetion pool) 이용하는 방법임
			/*Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/oraDB");
			con = ds.getConnection();*/
			
			//db 연결에 필요한 설정정보를 가진 파일을 읽어와서, 연결에 사용하는 방법
			Properties prop = new Properties();
			String currentPath = JDBCTemplate.class.getResource("./").getPath();
			//System.out.println("currentPath : " + currentPath);
			prop.load(new FileReader(currentPath + "driver.properties"));
			//System.out.println("prop : " + prop);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pwd = prop.getProperty("passwd");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
