package donation.question.model.dao;

import static donation.common.JDBCTemplate.*;

import donation.question.model.vo.Question;
import java.sql.*;
import java.util.*;

public class QuestionDao {
	public QuestionDao(){}


	// �� �Խñ� ���� ��ȸ��
	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from Question";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				result = rset.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		
		return result;
	}

	// �� �������� ����� �Խñ� ��� ��ȸ��
	public ArrayList<Question> selectList(Connection con, 
			int currentPage, int limit) {
		ArrayList<Question> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//currentPage �� �ش�Ǵ� ��ϸ� ��ȸ
		String query ="select * from ("
				+ "select rownum rnum, Question_num, Question_title, "
				+ "Question_writer, Question_content, QUESTION_ORIGINAL_IMAGENAME, "
				+ "QUESTION_RENAME_IMAGENAME, Question_date, Question_level, "
				+ "Question_ref, Question_reply_ref, Question_reply_seq, "
				+ "Question_readcount, BOARD_NO from (select * from Question "
				+ "order by Question_ref desc, Question_reply_ref desc, "
				+ "Question_level asc, Question_reply_seq asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<Question>();
				
				while(rset.next()){
					Question q = new Question();
					
					q.setQuestionNum(rset.getInt("Question_num"));
					q.setQuestionTitle(rset.getString("Question_title"));
					q.setQuestionWriter(rset.getString("Question_writer"));
					q.setQuestionContent(rset.getString("Question_content"));
					q.setQuestionDate(rset.getDate("Question_date"));
					q.setQuestionReadCount(rset.getInt("Question_readcount"));
					q.setQuestionOriginalImageName(rset.getString("QUESTION_ORIGINAL_IMAGENAME"));
					q.setQuestionRenameImageName(rset.getString("QUESTION_RENAME_IMAGENAME"));
					q.setQuestionLevel(rset.getInt("Question_level"));
					q.setQuestionRef(rset.getInt("Question_ref"));
					q.setQuestionReplyRef(rset.getInt("Question_reply_ref"));
					q.setQuestionReplySeq(rset.getInt("Question_reply_seq"));
					q.setBoard_no(rset.getInt("board_no"));
					
					list.add(q);
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

	
	//�Խñ� ��� ó��
	public int insertQuestion(Connection con, Question q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Question values ("
				+ "(select max(Question_num) + 1 from Question), "
				+ "?, ?, ?, ?, ?, sysdate, default, 0, "
				+ "(select max(Question_num) + 1 from Question), NULL, "
				+ "default, default, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, q.getQuestionTitle());
			pstmt.setString(2, q.getQuestionWriter());
			pstmt.setString(3, q.getQuestionContent());
			pstmt.setString(4, q.getQuestionOriginalImageName());
			pstmt.setString(5, q.getQuestionRenameImageName());
			pstmt.setInt(6, q.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	
	//��ȸ�� ���� ó��
	public int addReadCount(Connection con, int qnum) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update Question set Question_readcount = Question_readcount + 1 where Question_num = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
				
		return result;
	}


	public Question selectQuestion(Connection con, int qnum) {
		Question q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from Question where Question_num = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnum);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()){
				q = new Question();
				q.setQuestionNum(rset.getInt("Question_num"));
				q.setQuestionTitle(rset.getString("Question_title"));
				q.setQuestionWriter(rset.getString("Question_writer"));
				q.setQuestionContent(rset.getString("Question_content"));
				q.setQuestionDate(rset.getDate("Question_date"));
				q.setQuestionReadCount(rset.getInt("Question_readcount"));
				q.setQuestionOriginalImageName(rset.getString("QUESTION_ORIGINAL_IMAGENAME"));
				q.setQuestionRenameImageName(rset.getString("QUESTION_RENAME_IMAGENAME"));
				q.setQuestionLevel(rset.getInt("Question_level"));
				q.setQuestionRef(rset.getInt("Question_ref"));
				q.setQuestionReplyRef(rset.getInt("Question_reply_ref"));
				q.setQuestionReplySeq(rset.getInt("Question_reply_seq"));
				q.setBoard_no(rset.getInt("BOARD_NO"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close(rset);
			close(pstmt);
		}		
		
		return q;
	}


	public int deleteQuestion(Connection con, int qnum) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		
		String query = "delete from Question where Question_num = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,  qnum);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}		
				

				
		return result;
	}


	public int updateReplySeq(Connection con, Question replyQuestion) {
		int result = 0 ;
		PreparedStatement pstmt = null;
				
		String query = "update Question set Question_reply_seq = Question_reply_seq + 1 where Question_ref = ? and Question_level = ? and Question_reply_ref = ?";
		
		try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, replyQuestion.getQuestionRef());
		pstmt.setInt(2,  replyQuestion.getQuestionLevel());
		pstmt.setInt(3, replyQuestion.getQuestionReplyRef());
		
		result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	

	public int insertReply(Connection con, Question originQuestion, Question replyQuestion) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		//������ ����� ��
		if(replyQuestion.getQuestionLevel() == 1){
			query = "insert into Question values ("
					+ "(select max(Question_num) + 1 from Question), "
					+ "?, ?, ?, null, null, sysdate, default, ?, ?, "
					+ "(select max(Question_num) + 1 from Question), "
					+ "1, 'Y', ?)";
		}
		
		//����� ����� ��
		if(replyQuestion.getQuestionLevel() == 2){
			query = "insert into Question values ("
					+ "(select max(Question_num) + 1 from Question), "
					+ "?, ?, ?, null, null, sysdate, default, ?, ?, ?, "
					+ "1, 'Y', ?)";
		}
		
		try {
			if(replyQuestion.getQuestionLevel() == 1) {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, replyQuestion.getQuestionTitle());
			pstmt.setString(2, replyQuestion.getQuestionWriter());
			pstmt.setString(3, replyQuestion.getQuestionContent());
			pstmt.setInt(4, replyQuestion.getQuestionLevel());
			pstmt.setInt(5, replyQuestion.getQuestionRef());
			pstmt.setInt(6, replyQuestion.getBoard_no());
			}
			else if(replyQuestion.getQuestionLevel() == 2) {
				pstmt = con.prepareStatement(query);
			pstmt.setString(1, replyQuestion.getQuestionTitle());
			pstmt.setString(2, replyQuestion.getQuestionWriter());
			pstmt.setString(3, replyQuestion.getQuestionContent());
			pstmt.setInt(4, replyQuestion.getQuestionLevel());
			pstmt.setInt(5, replyQuestion.getQuestionRef());			
				pstmt.setInt(6, replyQuestion.getQuestionReplyRef());			
				pstmt.setInt(7, replyQuestion.getBoard_no());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}



	public int updateReply(Connection con, Question reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update Question set Question_title=?, Question_content =? where Question_num = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,  reply.getQuestionTitle());
			pstmt.setString(2,  reply.getQuestionContent());
			pstmt.setInt(3,  reply.getQuestionNum());
			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}


	public int updateQuestion(Connection con, Question q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Question set Question_title = ?, "
				+ "Question_content = ?, "
				+ "QUESTION_ORIGINAL_IMAGENAME = ?, "
				+ "QUESTION_RENAME_IMAGENAME = ? "
				+ "where Question_num = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, q.getQuestionTitle());
			pstmt.setString(2, q.getQuestionContent());
			pstmt.setString(3, q.getQuestionOriginalImageName());
			pstmt.setString(4, q.getQuestionRenameImageName());
			pstmt.setInt(5, q.getQuestionNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	public ArrayList<Question> selectTop3(Connection con) {
		ArrayList<Question> list = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from " 
				+ "(select rownum rnum, Question_num, " 
				+ "Question_TITLE "
				+ "from (select * from Question "
				+ "where Question_level = 0 " 
				+ "order by Question_readcount desc)) " 
				+ "where rnum >= 1 and rnum <= 3";		

		try {
			stmt = con.createStatement();		

			rset = stmt.executeQuery(query);
			if (rset != null) {
				list = new ArrayList<Question>();
				while (rset.next()) {
					Question q = new Question();
					q.setQuestionNum(rset.getInt("Question_num"));
					q.setQuestionTitle(rset.getString("Question_title"));
					
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
	
	
	
	///////////////////////
	
	public ArrayList<Question> selectTitleSearch(Connection con, String keyword, int currentPage, int limit) {
		/*ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where notice_title like ? order by notice_no desc";
																//���⼭ like �ڿ� % ����ȵ� ����� ?�� ���� setString�� �� ���ڿ� ������ �߰�������ߵ�
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<Notice>();
								
				while(rset.next()){
					Notice n = new Notice();
					n.setNoticeNo(rset.getInt("NOTICE_NO"));
					n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
					n.setNoticeWriter(rset.getString("NOTICE_WRITER"));
					n.setNoticeContent(rset.getString("NOTICE_CONTENT"));
					n.setNoticeDate(rset.getDate("NOTICE_DATE"));
					n.setOriginalFileName(rset.getString("ORIGINAL_FILENAME"));
					n.setRenameFileName(rset.getString("RENAME_FILENAME"));
					n.setReadCount(rset.getInt("READ_COUNT"));
					
					
					list.add(n); //map���� ��ü�� �;ߵǴµ� n.getNoticeNo()�� int��, �ٵ�  AutoBoxing ��
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		
		return list;	*/
		
		
	
		
		ArrayList<Question> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//currentPage �� �ش�Ǵ� ��ϸ� ��ȸ
		String query ="select * from (select rownum rnum, Question_num, Question_title, Question_writer, Question_content, QUESTION_ORIGINAL_IMAGENAME, QUESTION_RENAME_IMAGENAME, Question_date, Question_level, Question_ref, Question_reply_ref, Question_reply_seq, Question_readcount, BOARD_NO from (select * from Question where question_title like ? order by Question_ref desc, Question_reply_ref desc, Question_level asc, Question_reply_seq asc))	where rnum >= ? and rnum <= ?";
		
		
		
	
		
		System.out.println("currentPage :" + currentPage);
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			

		
			 
			 
			if(rset != null){
				list = new ArrayList<Question>();
				while(rset.next()){
					Question q = new Question();
					
					q.setQuestionNum(rset.getInt("Question_num"));
					q.setQuestionTitle(rset.getString("Question_title"));
					q.setQuestionWriter(rset.getString("Question_writer"));
					q.setQuestionContent(rset.getString("Question_content"));
					q.setQuestionDate(rset.getDate("Question_date"));
					q.setQuestionReadCount(rset.getInt("Question_readcount"));
					q.setQuestionOriginalImageName(rset.getString("QUESTION_ORIGINAL_IMAGENAME"));
					q.setQuestionRenameImageName(rset.getString("QUESTION_RENAME_IMAGENAME"));
					q.setQuestionLevel(rset.getInt("Question_level"));
					q.setQuestionRef(rset.getInt("Question_ref"));
					q.setQuestionReplyRef(rset.getInt("Question_reply_ref"));
					q.setQuestionReplySeq(rset.getInt("Question_reply_seq"));
					q.setBoard_no(rset.getInt("BOARD_NO"));
					list.add(q);


				}
				 System.out.println(" list : " + list.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	public int getSearchListCount(Connection con, String keyword) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from question where question_title like ?";
		//���⼭ like �ڿ� % ����ȵ� ����� ?�� ���� setString�� �� ���ڿ� ������ �߰�������ߵ�
		try {
			pstmt = con.prepareStatement(query);
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


	public int updateOriginQAnswer(Connection con, Question originQuestion) {
		int result = 0;
		PreparedStatement pstmt = null;		
		String query = "update Question set answer='Y'"
					 + "where Question_num=?";		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, originQuestion.getQuestionNum());			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}		
		return result;
	}	  
}














