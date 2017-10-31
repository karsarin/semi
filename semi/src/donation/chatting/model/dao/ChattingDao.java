package donation.chatting.model.dao;


import static donation.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChattingDao {
	public ChattingDao() {}

	public boolean reciverConnectionSt(Connection conn, String reciver) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		String query = "select member_id from member where member_id=? and connection='Y'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reciver);
			rset = pstmt.executeQuery();
			if(rset.next()) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertChat(Connection conn, String sender, String reciver) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into chat values(?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sender);
			pstmt.setString(2, reciver);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String findReciver(Connection conn, String sender) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null;
		String query = "select sender from chat where reciver=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sender);
			rset = pstmt.executeQuery();
			if(rset.next()) result = rset.getString("sender");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public boolean newChat(Connection conn, String reciver) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		String query = "select sender from chat where reciver=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reciver);
			rset = pstmt.executeQuery();
			if(rset.next()) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int deleteChat(Connection conn, String reciver) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete chat where reciver=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reciver);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
