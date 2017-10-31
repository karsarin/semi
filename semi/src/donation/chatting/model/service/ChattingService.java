package donation.chatting.model.service;

import static donation.common.JDBCTemplate.close;
import static donation.common.JDBCTemplate.commit;
import static donation.common.JDBCTemplate.getConnection;
import static donation.common.JDBCTemplate.rollback;

import java.sql.Connection;

import donation.chatting.model.dao.ChattingDao;

public class ChattingService {
	
	public ChattingService() {}

	public boolean reciverConnectionSt(String reciver) {
		Connection conn = getConnection();
		boolean result = new ChattingDao().reciverConnectionSt(conn, reciver);
		close(conn);
		return result;
	}

	public int insertChat(String sender, String reciver) {
		Connection conn = getConnection();
		int result = new ChattingDao().insertChat(conn, sender, reciver);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public String findReciver(String sender) {
		Connection conn = getConnection();
		String result = new ChattingDao().findReciver(conn, sender);
		close(conn);
		return result;
	}

	public boolean newChat(String reciver) {
		Connection conn = getConnection();
		boolean result = new ChattingDao().newChat(conn, reciver);
		close(conn);
		return result;
	}

	public void deleteChat(String reciver) {
		Connection conn = getConnection();
		int result = new ChattingDao().deleteChat(conn, reciver);
		if(result>0) commit(conn);
		else rollback(conn);
	}
	
	
}
