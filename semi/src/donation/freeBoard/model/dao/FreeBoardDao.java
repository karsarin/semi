package donation.freeBoard.model.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import donation.freeBoard.model.vo.CommentBoard;
import donation.freeBoard.model.vo.FreeBoard;
import donation.notice.model.vo.Notice;
import donation.question.model.vo.Question;

import static donation.common.JDBCTemplate.*;

public class FreeBoardDao {

	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from freeboard";
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return result;
		
		
		
	}

	public ArrayList<FreeBoard> selectList(Connection con, int currentPage, int limit) {
		ArrayList<FreeBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, FREEBOARD_NO, FREEBOARD_TITLE, FREEBOARD_WRITER, FREEBOARD_CONTENT, FREEBOARD_DATE, ORIGINAL_IMAGENAME, RENAME_IMAGENAME, READ_COUNT, BOARDTYPE, BOARD_NO  from (select * from FREEBOARD order by FREEBOARD_NO desc))where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage - 1) * limit + 1 ;
		int endRow = startRow + limit - 1;
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,  startRow);
			pstmt.setInt(2,  endRow);
			
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				
				list = new ArrayList<FreeBoard>();
				while(rset.next()) {
					FreeBoard fboard = new FreeBoard();
					fboard.setfreeBoardNo(rset.getInt("FREEBOARD_NO"));
					fboard.setfreeBoardTitle(rset.getString("FREEBOARD_TITLE"));
					fboard.setfreeBoardWriter(rset.getString("FREEBOARD_WRITER"));
					fboard.setfreeBoardContent(rset.getString("FREEBOARD_CONTENT"));
					fboard.setfreeBoardDate(rset.getDate("FREEBOARD_DATE"));
					fboard.setOriginalImageName(rset.getString("ORIGINAL_IMAGENAME"));
					fboard.setRenameImageName(rset.getString("RENAME_IMAGENAME"));
					fboard.setReadCount(rset.getInt("READ_COUNT"));
					fboard.setBoardType(rset.getString("BOARDTYPE"));
					fboard.setBoard_no(rset.getInt("BOARD_NO"));
					
					list.add(fboard);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	
	////
	

	public FreeBoard selectOne(Connection con, int no) {
		FreeBoard fboard = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from freeboard where freeBoard_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,  no);
			
			rset = pstmt.executeQuery();
			if(rset.next())//pk로 조회한건 결과가 한개니까 if문 사용
			{
				fboard = new FreeBoard();
				fboard.setfreeBoardNo(rset.getInt("FREEBOARD_NO"));
				fboard.setfreeBoardTitle(rset.getString("FREEBOARD_TITLE"));
				fboard.setfreeBoardWriter(rset.getString("FREEBOARD_WRITER"));
				fboard.setfreeBoardContent(rset.getString("FREEBOARD_CONTENT"));
				fboard.setfreeBoardDate(rset.getDate("FREEBOARD_DATE"));
				fboard.setOriginalImageName(rset.getString("ORIGINAL_IMAGENAME"));
				fboard.setRenameImageName(rset.getString("RENAME_IMAGENAME"));
				fboard.setReadCount(rset.getInt("READ_COUNT"));
				fboard.setBoardType(rset.getString("BOARDTYPE"));
				fboard.setBoard_no(rset.getInt("BOARD_NO"));
			
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return fboard;
	}

	public static int updateReadCount(Connection con, int no) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = "update freeboard set read_count = read_count + 1 where freeboard_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}		
		return result;
	}

	public int insertFreeBoard(Connection con, FreeBoard fboard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into freeboard values "
				+ "((select max(freeboard_no) + 1 from freeboard), "
				+ "?, ?, ?, default, ?, ?, default, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fboard.getfreeBoardTitle());
			pstmt.setString(2, fboard.getfreeBoardWriter());
			pstmt.setString(3, fboard.getfreeBoardContent());
			pstmt.setString(4, fboard.getOriginalImageName());
			pstmt.setString(5, fboard.getRenameImageName());
			pstmt.setString(6, fboard.getBoardType());
			pstmt.setInt(7, fboard.getBoard_no());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close(pstmt);
		}			
		return result;
	}

	public int updateFreeBoard(FreeBoard fboard, Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update freeboard set freeboard_title=?, freeboard_content = ?, ORIGINAL_IMAGENAME=?, RENAME_IMAGENAME=? where freeboard_no = ?";
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, fboard.getfreeBoardTitle());
			pstmt.setString(2, fboard.getfreeBoardContent());
			pstmt.setString(3, fboard.getOriginalImageName());
			pstmt.setString(4, fboard.getRenameImageName());
			pstmt.setInt(5, fboard.getfreeBoardNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close(pstmt);
		}
		return result;
	}

	public int deleteFreeBoard(Connection con, int no) {

		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = "delete from freeboard where freeboard_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,  no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}		
		return result;
	}

	public ArrayList<FreeBoard> selectTitleSearch(Connection con, String type, String keyword, int currentPage, int limit) {
		ArrayList<FreeBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		String query = "";
		if(type.equals("작성자")) {
			
			 query ="select * from ("
						+ "select rownum rnum, freeboard_NO, freeboard_TITLE, "
						+ "freeboard_WRITER, freeboard_CONTENT, freeboard_DATE, "
						+ "ORIGINAL_IMAGENAME, RENAME_IMAGENAME, READ_COUNT, BOARDTYPE, BOARD_NO "
						+ "from (select * from freeboard where FREEBOARD_WRITER like ? order by freeboard_NO desc "
						+ " )) "
						+ "where rnum >= ? and rnum <= ?";
				
			
		}else if(type.equals("내용")) {
		
			 query ="select * from ("
						+ "select rownum rnum, freeboard_NO, freeboard_TITLE, "
						+ "freeboard_WRITER, freeboard_CONTENT, freeboard_DATE, "
						+ "ORIGINAL_IMAGENAME, RENAME_IMAGENAME, READ_COUNT, BOARDTYPE, BOARD_NO "
						+ "from (select * from freeboard where FREEBOARD_CONTENT like ? order by freeboard_NO desc "
						+ " )) "
						+ "where rnum >= ? and rnum <= ?";
				
		}else if(type.equals("분류")) {
			
			 query ="select * from ("
						+ "select rownum rnum, freeboard_NO, freeboard_TITLE, "
						+ "freeboard_WRITER, freeboard_CONTENT, freeboard_DATE, "
						+ "ORIGINAL_IMAGENAME, RENAME_IMAGENAME, READ_COUNT, BOARDTYPE, BOARD_NO "
						+ "from (select * from freeboard where BOARDTYPE like ? order by freeboard_NO desc "
						+ " )) "
						+ "where rnum >= ? and rnum <= ?";
				
		}else if(type.equals("제목")) {
			
			query ="select * from ("
					+ "select rownum rnum, freeboard_NO, freeboard_TITLE, "
					+ "freeboard_WRITER, freeboard_CONTENT, freeboard_DATE, "
					+ "ORIGINAL_IMAGENAME, RENAME_IMAGENAME, READ_COUNT, BOARDTYPE, BOARD_NO "
					+ "from (select * from freeboard where FREEBOARD_TITLE like ? order by freeboard_NO desc "
					+ " )) "
					+ "where rnum >= ? and rnum <= ?";
		}
	
		//currentPage 에 해당되는 목록만 조회
	
		
		
		System.out.println("currentPage :" + currentPage);
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
		//	pstmt.setString(1, type);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<FreeBoard>();
				
				while(rset.next()){
					FreeBoard fboard = new FreeBoard();
					
					fboard.setfreeBoardNo(rset.getInt("FREEBOARD_NO"));
					fboard.setfreeBoardTitle(rset.getString("FREEBOARD_TITLE"));
					fboard.setfreeBoardWriter(rset.getString("FREEBOARD_WRITER"));
					fboard.setfreeBoardContent(rset.getString("FREEBOARD_CONTENT"));
					fboard.setfreeBoardDate(rset.getDate("FREEBOARD_DATE"));
					fboard.setOriginalImageName(rset.getString("ORIGINAL_IMAGENAME"));
					fboard.setRenameImageName(rset.getString("RENAME_IMAGENAME"));
					fboard.setReadCount(rset.getInt("READ_COUNT"));
					fboard.setBoardType(rset.getString("BOARDTYPE"));
					fboard.setBoard_no(rset.getInt("BOARD_NO"));
					
					list.add(fboard);
					
					System.out.println(list.toString());
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

	public int getSearchListCount(Connection con, String type, String keyword) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		System.out.println("Dao단 type :" + type);
		
		String query = "";
		if(type.equals("작성자")) {
			
			query = "select count(*) from freeboard where FREEBOARD_WRITER like ?";
			
		}else if(type.equals("내용")) {
		
			 query = "select count(*) from freeboard where FREEBOARD_CONTENT like ?";
		}else if(type.equals("분류")) {
			
			 query = "select count(*) from freeboard where BOARDTYPE like ?";
		}else if(type.equals("제목")) {
			
			 query = "select count(*) from freeboard where FREEBOARD_TITLE like ?";
		}
	
		
		
		//여기서 like 뒤에 % 쓰면안됨 여기는 ?만 쓰고 setString할 때 문자열 값으로 추가시켜줘야됨
		try {
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1, type);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				result = rset.getInt(1);
			
		} 
		
		
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		

		
		System.out.println(result);
		return result;

		
		
		
	}

	public int insertReplyBoard(Connection con, CommentBoard cboard) {

		int result = 0;
		PreparedStatement pstmt = null;
		 
		String query ="insert into BOARD_COMMENT values ((select max(COMMENT_NUM) + 1 from BOARD_COMMENT), ?, ?, sysdate, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cboard.getBoardNum());
			pstmt.setString(2, cboard.getWriter());
			pstmt.setString(3, cboard.getContent());
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close(pstmt);
		}			
		return result;
	}

	public ArrayList<CommentBoard> selectReplyList(Connection con, int boardNum) {
		ArrayList<CommentBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select COMMENT_BOARD_NUM, COMMENT_NUM, COMMENT_ID, to_char(COMMENT_DATE), COMMENT_CONTENT  from BOARD_COMMENT where COMMENT_BOARD_NUM = ? order by COMMENT_NUM asc";			
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNum );
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				
				list = new ArrayList<CommentBoard>();
				while(rset.next()) {
					CommentBoard rboard = new CommentBoard();
					rboard.setBoardNum(rset.getInt(1));
					rboard.setCommentNum(rset.getInt(2));
					rboard.setWriter(rset.getString(3));
					rboard.setDateString(rset.getString(4));
					rboard.setContent(rset.getString(5));
					
				
					
					
					list.add(rboard);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int deleteCommentBoard(Connection con, int commentNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from BOARD_COMMENT where COMMENT_NUM = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, commentNum);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);			
		}
		
		return result;
	}
	public ArrayList<FreeBoard> selectTop3(Connection con) {
		ArrayList<FreeBoard> list = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from " 
				+ "(select rownum rnum, FREEBOARD_NO, " 
				+ "FREEBOARD_TITLE "
				+ "from (select * from FREEBOARD "
				+ "where BOARDTYPE like '후기' "
				+ "order by READ_COUNT desc)) " 
				+ "where rnum >= 1 and rnum <= 3";		

		try {
			stmt = con.createStatement();		

			rset = stmt.executeQuery(query);
			if (rset != null) {
				list = new ArrayList<FreeBoard>();
				while (rset.next()) {
					FreeBoard q = new FreeBoard();
					q.setfreeBoardNo(rset.getInt("FREEBOARD_NO"));
					q.setfreeBoardTitle(rset.getString("FREEBOARD_title"));
					
					list.add(q);
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
