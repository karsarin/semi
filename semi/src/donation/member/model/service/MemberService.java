package donation.member.model.service;

import static donation.common.JDBCTemplate.close;
import static donation.common.JDBCTemplate.commit;
import static donation.common.JDBCTemplate.getConnection;
import static donation.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import donation.category.vo.CategoryUsed;
import donation.member.model.dao.MemberDao;
import donation.member.model.vo.Member;
import donation.member.model.vo.MyWrite;
public class MemberService {

	public Member login(String memberId, String memberPwd) {
		Connection con = getConnection();
		
		Member member = new MemberDao().selectMember(con,memberId,memberPwd);
		if(member!=null){
			int login = new MemberDao().login(con,memberId);
		}
		close(con);
		return member;
	}

	public int memberInsert(Member member) {
		Connection con = getConnection();
		int result =new MemberDao().memberInsert(con,member);
		if(con != null)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int memberInsertCheck(Member member, String memberPwd2) {
		Connection con = getConnection();
		int result = new MemberDao().memberInsertCheck(con, member, memberPwd2);
		return result;
	}

	public Member memberInformation(String memberId) {
		Connection con = getConnection();
		Member member = new MemberDao().memberInformation(con,memberId);
		close(con);
		return member;
	}

	public int updateMember(Member member,Member memberOrigin) {
		Connection con = getConnection();
		int result = new MemberDao().updateMember(con, member, memberOrigin);
		if(con !=null){
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		return result;
	}

	public Member selectMember(String memberId) {
		Connection con = getConnection();
		Member member = new MemberDao().selectMember(con, memberId);
		close(con);
		return member;
	}

	public int deleteMember(String memberId) {
		Connection con = getConnection();
		int result = new MemberDao().deleteMember(con, memberId);
		if(con!=null)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int memberIdCheck(Member member) {
		Connection con = getConnection();
		int result = new MemberDao().memberIdCheck(con, member);
		close(con);
		return result;
	}
	public int memberNikCheck(Member member) {
		Connection con = getConnection();
		int result = new MemberDao().memberNikCheck(con, member);
		close(con);
		return result;
	}

	public int selectMemberNum() {
		Connection con = getConnection();
		int result = new MemberDao().selectMemberNum(con);
		close(con);
		return result;
	}

	public void logout(String memberId) {
		Connection con = getConnection();
		new MemberDao().logout(con,memberId);
		if(con!=null)
			commit(con);
		else
			rollback(con);
		close(con);
	}

	public ArrayList<MyWrite> selectMyWrite(int currentPage, int limit, String memberId,int boardNo) {
		Connection con = getConnection();
		ArrayList<MyWrite> list = new MemberDao().selectMyWrite(con,currentPage, limit, memberId, boardNo);
		close(con);
		return list;
	}

	public int getListCount(String memberId, int boardNo) {
		Connection con = getConnection();
		int result  = new MemberDao().getListCount(con,memberId, boardNo);
		close(con);
		return result;
	}

	public int getListCount(String memberId) {
		Connection con = getConnection();
		int result  = new MemberDao().getListCount(con,memberId);
		close(con);
		return result;
	}

	public ArrayList<CategoryUsed> selectMyCategoryUsed(int currentPage, int limit, String memberId) {
		Connection con = getConnection();
		ArrayList<CategoryUsed> list = new MemberDao().selectMyCategoryUsed(con,currentPage, limit, memberId);
		close(con);
		return list;
	}

	public ArrayList<Member> memberList() {
		Connection con = getConnection();
		ArrayList<Member> list = new MemberDao().memberList(con);
		close(con);
		return list;
	}

	public String idSearch(String memberName, String memberNo) {
		Connection con = getConnection();
		String member = new MemberDao().idSearch(con,memberName,memberNo);
		close(con);
		return member;
	}

	public String pwdSearch(String memberId, String memberName, String memberNo) {
		Connection con = getConnection();
		String member = new MemberDao().pwdSearch(con,memberId,memberName,memberNo);
		close(con);
		return member;
	}

	public int pwdUpdate(String memberId, String memberPwd) {
		Connection con = getConnection();
		int result = new MemberDao().pwdUpdate(con,memberId,memberPwd);
		if(con!=null)
			commit(con);
		else
			rollback(con);
		close(con);
		
		return result;
	}

	public String mEnrollCk(String memberId, String memberNo, String memberNik, String memberPhone) {
		Connection conn = getConnection();
		String result = new MemberDao().mEnrollCk(conn, memberId, memberNo, memberNik, memberPhone);
		close(conn);
		return result;
	}



}