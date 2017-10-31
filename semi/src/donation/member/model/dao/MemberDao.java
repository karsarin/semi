package donation.member.model.dao;

import static donation.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import donation.category.vo.CategoryUsed;
import donation.donate.model.vo.Donate;
import donation.member.model.vo.Member;
import donation.member.model.vo.MyWrite;

public class MemberDao {

	public Member selectMember(Connection con, String memberId, String memberPwd) {
		PreparedStatement pstmt = null;
		ResultSet  rset = null;
		
		String query = "select * from member where member_id = ? and member_pwd = ?";
		
		Member member=null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member = new Member();
				member.setMemberId(memberId);
				member.setMemberPwd(memberPwd);
				member.setMemberName(rset.getString("member_name"));
				member.setMemberNo(rset.getString("member_no"));
				member.setMemberNik(rset.getString("member_nik"));
				member.setMemberAddress(rset.getString("member_address"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberDate(rset.getDate("signup_date"));
				member.setConnection(rset.getString("connection"));
				member.setTalent(rset.getString("talent"));
				member.setMgrChat(rset.getString("manager_chatting"));
				member.setMgrLogin(rset.getString("manager_login"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
			
		}
		return member;
	}

	public int memberInsert(Connection con, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into member values(?,?,?,?,?,?,?,?,default,default,?,default,default)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberNo());
			pstmt.setString(5, member.getMemberNik());
			pstmt.setString(6, member.getMemberAddress());
			pstmt.setString(7, member.getMemberEmail());
			pstmt.setString(8, member.getMemberPhone());
			pstmt.setString(9, member.getTalent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
	public int memberInsertCheck(Connection con, Member member, String memberPwd2){
		
		int result = 0;



		if(!(member.getMemberId().length() >= 8 && member.getMemberId().length() <= 15)){
			 return 1;//아이디 길이 오류
		}
		int num = 0;
		int spal = 0;
		for(int i=0;i<member.getMemberId().length();i++){
			if(!((member.getMemberId().charAt(i) >= 'a'&&member.getMemberId().charAt(i) <= 'z')||(member.getMemberId().charAt(i) >= 'a'&&member.getMemberId().charAt(i) <= 'z')||(member.getMemberId().charAt(i) >= '0'&&member.getMemberId().charAt(i) <= '9'))){
				return 2;//아이디 영문숫자 오류
			}else if(!(member.getMemberId().toUpperCase().charAt(i)>='A'&&member.getMemberId().toUpperCase().charAt(i)<='Z')){
				num +=1;
			}else{
				spal +=1;
			}
		}
		if(member.getMemberId().length() == num || member.getMemberId().length()==spal){
			return 3;//아이디 영문숫자조합 오류
		}
		if(!(member.getMemberPwd().equals(memberPwd2))){
			return 4;// 비밀먼호 확인 실패
		}
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		String query = "select * from member";
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset !=null){
				list = new ArrayList<Member>();
				while(rset.next()){
					Member m = new Member();
					m.setMemberNo(rset.getString("member_no"));
					m.setMemberPhone(rset.getString("member_phone"));
					list.add(m);
				}
				
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		for(Member mem : list){
			if(member.getMemberNo() == mem.getMemberNo()){
				return 5;//주민번호 중복체크 
			}
		}
		for(Member mem : list){
			if(member.getMemberEmail() == mem.getMemberEmail()){
				return 6;//이메일 중복체크 
			}
		}
		for(Member mem : list){
			if(member.getMemberPhone() == mem.getMemberPhone()){
				return 7;//전화번호 중복체크 
			}
		}
		return result;
	}
	public int memberIdCheck(Connection con,Member member){
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		String query = "select * from member";
		int result = 0;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset !=null){
				list = new ArrayList<Member>();
				while(rset.next()){
					Member m = new Member();
					m.setMemberId(rset.getString("member_id"));
					list.add(m);
				}
				
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		for(Member mem : list){
			if(member.getMemberId() == mem.getMemberId()){
				return 1; //아이디 중복체크
			}
		}
		return result;
	}
	public int memberNikCheck(Connection con,Member member){
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		String query = "select * from member";
		int result = 0;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset !=null){
				list = new ArrayList<Member>();
				while(rset.next()){
					Member m = new Member();
					m.setMemberNik(rset.getString("member_nik"));
					
					list.add(m);
				}
				
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		for(Member mem : list){
			if(member.getMemberNik() == mem.getMemberNik()){
				return 1;//닉네임 중복체크 
			}
		}
		return result;
	}
	public Member memberInformation(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "select * from member where member_id = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()){
			member = new Member();
			member.setMemberId(memberId);
			member.setMemberPwd(rset.getString("member_pwd"));
			member.setMemberName(rset.getString("member_name"));
			member.setMemberNo(rset.getString("member_no"));
			member.setMemberNik(rset.getString("member_nik"));
			member.setMemberAddress(rset.getString("member_address"));
			member.setMemberEmail(rset.getString("member_email"));
			member.setMemberPhone(rset.getString("member_phone"));
			member.setMemberDate(rset.getDate("signup_date"));
			member.setConnection(rset.getString("connection"));
			member.setTalent(rset.getString("talent"));
			member.setMgrChat(rset.getString("manager_chatting"));
			member.setMgrLogin(rset.getString("manager_login"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int updateMember(Connection con, Member member, Member memberOrigin) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println(member);
		System.out.println(memberOrigin);
		String query = "update member set member_pwd=?,member_name=?,member_nik=?,member_address=?,member_email=?,member_phone=?,talent=? where member_id=?";
		try {
			pstmt = con.prepareStatement(query);
			if(member.getMemberPwd()!=null&&member.getMemberPwd()!="")
				pstmt.setString(1, member.getMemberPwd());
			else
				pstmt.setString(1, memberOrigin.getMemberPwd());
			if(member.getMemberName() != null&&member.getMemberName()!="")
				pstmt.setString(2, member.getMemberName());
			else
				pstmt.setString(2, memberOrigin.getMemberName());
			if(member.getMemberNik() !=null&&member.getMemberNik()!="")
				pstmt.setString(3, member.getMemberNik());
			else
				pstmt.setString(3, memberOrigin.getMemberNik());
			if(member.getMemberAddress() !=null&&member.getMemberAddress()!="")
				pstmt.setString(4, member.getMemberAddress());
			else
				pstmt.setString(4, memberOrigin.getMemberAddress());
			if(member.getMemberEmail() !=null&&member.getMemberEmail()!="")
				pstmt.setString(5, member.getMemberEmail());
			else
				pstmt.setString(5, memberOrigin.getMemberEmail());
			if(member.getMemberPhone() !=null&&member.getMemberPhone()!="")
				pstmt.setString(6, member.getMemberPhone());
			else
				pstmt.setString(6, memberOrigin.getMemberPhone());
			pstmt.setString(7, member.getTalent());
			pstmt.setString(8, member.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet  rset = null;
		
		String query = "select * from member where member_id = ?";
		
		Member member=null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member = new Member();
				member.setMemberId(memberId);
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberNo(rset.getString("member_no"));
				member.setMemberNik(rset.getString("member_nik"));
				member.setMemberAddress(rset.getString("member_address"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberDate(rset.getDate("signup_date"));
				member.setConnection(rset.getString("connection"));
				member.setTalent(rset.getString("talent"));
				member.setMgrChat(rset.getString("manager_chatting"));
				member.setMgrLogin(rset.getString("manager_login"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
			
		}
		return member;
	}

	public int deleteMember(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where member_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int selectMemberNum(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "select count(*) from member";
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()){
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		return result;
	}

	public int login(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query="update member set connection = ? where member_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public void logout(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		
		String query="update member set connection = ? where member_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "N");
			pstmt.setString(2, memberId);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
	}

	public ArrayList<MyWrite> selectMyWrite(Connection con, int currentPage, int limit, String memberId,int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String date1 = "yy/MM/dd";
		String date2 = "yy/MM/dd/hh:mi:ss";
		String date3 = "hh:mi:ss";
		String query = null;
		if(boardNo==0){
			query = "select * from "
					+ "(select rownum rnum,board_no,board_name,category_no,"
					+ "category_title,freeboard_no,freeboard_title,"
					+ "question_num,question_title,count,member_id,"
					+ "case when to_char(sysdate,?) = to_char(to_date(board_date,?),?)"
					+ "then to_char(to_date(board_date,?),?)"
					+ "else to_char(to_date(board_date,?),?)"
					+ "end board_date "
					+ "from(select board_no,board_name,category_no,category_title,"
					+ "freeboard_no,freeboard_title,question_num,question_title,"
					+ "CATEGORY_READCOUNT||QUESTION_READCOUNT||READ_COUNT count,"
					+ "user_id||question_writer||freeboard_writer member_id,"
					+ "to_char(category_date,?) || to_char(freeboard_date,?) || to_char(question_date,?) board_date "
					+ "from board full outer join CATEGORY_BOARD using (board_no) "
					+ "full outer join freeboard using(board_no)"
					+ " full outer join question using(board_no) "
					+ "order by board_date desc)where member_id=?) where rnum>=? and rnum<=?";
			}else{
				query = "select * from "
						+ "(select rownum rnum,board_no,board_name,category_no,"
						+ "category_title,freeboard_no,freeboard_title,"
						+ "question_num,question_title,count,member_id,"
						+ "case when to_char(sysdate,?) = to_char(to_date(board_date,?),?)"
						+ "then to_char(to_date(board_date,?),?)"
						+ "else to_char(to_date(board_date,?),?)"
						+ "end board_date "
						+ "from(select board_no,board_name,category_no,category_title,"
						+ "freeboard_no,freeboard_title,question_num,question_title,"
						+ "CATEGORY_READCOUNT||QUESTION_READCOUNT||READ_COUNT count,"
						+ "user_id||question_writer||freeboard_writer member_id,"
						+ "to_char(category_date,?) || to_char(freeboard_date,?) || to_char(question_date,?) board_date "
						+ "from board full outer join CATEGORY_BOARD using (board_no) "
						+ "full outer join freeboard using(board_no)"
						+ " full outer join question using(board_no) "
						+ "order by board_date desc)where member_id=? and board_no = ?) where rnum>=? and rnum<=?";
			}
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit -1;
		 ArrayList<MyWrite> list = null;
		 try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, date1);
			pstmt.setString(2, date2);
			pstmt.setString(3, date1);
			pstmt.setString(4, date2);
			pstmt.setString(5, date3);
			/*pstmt.setString(6, date3);*/
			pstmt.setString(6, date2);
			pstmt.setString(7, date1);
			pstmt.setString(8, date2);
			/*pstmt.setString(10, date1);*/
			pstmt.setString(9, date2);
			pstmt.setString(10, date2);
			pstmt.setString(11, memberId);
			if(boardNo!=0){
				pstmt.setInt(12, boardNo);
				pstmt.setInt(13, startRow);
				pstmt.setInt(14, endRow);
			}else{
				pstmt.setInt(12, startRow);
				pstmt.setInt(13, endRow);
			}
			
			rset = pstmt.executeQuery();
			if(rset != null){
				list = new ArrayList<MyWrite>();
				
				while(rset.next()){
					MyWrite mwriter = new MyWrite();
					mwriter.setListNo(rset.getInt("rnum"));
					mwriter.setBoardName(rset.getString("board_name"));
					if(rset.getInt("board_no")==1){
						mwriter.setBoardNo(rset.getInt("category_no"));
						mwriter.setTitle(rset.getString("category_title"));	
					}else if(rset.getInt("board_no")==2){
						mwriter.setBoardNo(rset.getInt("freeboard_no"));
						mwriter.setTitle(rset.getString("freeboard_title"));	
					}else if(rset.getInt("board_no")==3){
						mwriter.setBoardNo(rset.getInt("question_num"));
						mwriter.setTitle(rset.getString("question_title"));	
					}
					mwriter.setWriter(memberId);
					mwriter.setCount(rset.getInt("count"));
					mwriter.setWriteDate(rset.getString("board_date"));
					
					list.add(mwriter);
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

	public int getListCount(Connection con, String memberId, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = null;
		if(boardNo==0){
			query = "select count(*)"
					+ "from board "
					+ "join CATEGORY_BOARD using (board_no)"
					+ "full outer join freeboard using(board_no)"
					+ "full outer join question using(board_no)"
					+ "where user_id || question_writer || freeboard_writer = ?";
		}else{
			query = "select count(*)"
					+ "from board "
					+ "join CATEGORY_BOARD using (board_no)"
					+ "full outer join freeboard using(board_no)"
					+ "full outer join question using(board_no)"
					+ "where user_id || question_writer || freeboard_writer = ? and board_no = ?";
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			if(boardNo !=0)
				pstmt.setInt(2, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next())
				result = rset.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}

	public int getListCount(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) "
				+ "from CATEGORY_USED "
				+ "join CATEGORY_BOARD using(category_no) "
				+ "join CATEGORY_GROUP on (CATEGORY_BOARD.CATEGORY_GROUP = CATEGORY_GROUP.GROUP_NO) "
				+ "where use_id = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next())
				result = rset.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<CategoryUsed> selectMyCategoryUsed(Connection con, int currentPage, int limit, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from "
				+ "(select rownum rnum, use_no, group_name,"
				+ "category_title,use_id,user_id,used_date "
				+ "from (select * from CATEGORY_USED "
				+ "join CATEGORY_BOARD using(category_no) "
				+ "join CATEGORY_GROUP on (CATEGORY_BOARD.CATEGORY_GROUP = CATEGORY_GROUP.GROUP_NO) order by 2)"
				+ "where use_id = ? order by rnum) where rnum >= ? and rnum <= ?";

		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit -1;
		
		 ArrayList<CategoryUsed> list = null;
		 try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			if(rset != null){
				list = new ArrayList<CategoryUsed>();
				
				while(rset.next()){
					CategoryUsed cused = new CategoryUsed();
					cused.setUseNo(rset.getInt("use_no"));
					cused.setCategoryName(rset.getString("group_name"));
					cused.setCategoryTitle(rset.getString("category_title"));
					cused.setUse_id(rset.getString("use_id"));
					cused.setWriter_id(rset.getString("user_id"));
					cused.setUsedDate(rset.getDate("used_date"));
					list.add(cused);
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

	public ArrayList<Member> memberList(Connection con) {
		Statement stmt = null;
		ResultSet  rset = null;
		
		String query = "select * from member";
		
		ArrayList<Member> list = null;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null){
				list = new ArrayList<Member>();
				while(rset.next()){
					Member member = new Member();
					member.setMemberId(rset.getString("member_id"));
					member.setMemberPwd(rset.getString("member_pwd"));
					member.setMemberName(rset.getString("member_name"));
					member.setMemberNo(rset.getString("member_no"));
					member.setMemberNik(rset.getString("member_nik"));
					member.setMemberAddress(rset.getString("member_address"));
					member.setMemberEmail(rset.getString("member_email"));
					member.setMemberPhone(rset.getString("member_phone"));
					member.setMemberDate(rset.getDate("signup_date"));
					member.setConnection(rset.getString("connection"));
					member.setTalent(rset.getString("talent"));
					member.setMgrChat(rset.getString("manager_chatting"));
					member.setMgrLogin(rset.getString("manager_login"));
					
					list.add(member);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
			
		}
		return list;
	}

	public String idSearch(Connection con, String memberName, String memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select member_id from member where member_name = ? and member_no = ?";
		
		String member = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				member = rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public String pwdSearch(Connection con, String memberId, String memberName, String memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select member_id from member where member_id = ? and member_name = ? and member_no = ?";
		
		String member = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberName);
			pstmt.setString(3, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				member = rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int pwdUpdate(Connection con, String memberId, String memberPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set member_pwd = ? where member_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberPwd);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
}
