package donation.search.model.dao;

import static donation.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import donation.search.model.vo.Notice;

public class NoticeDao {
	public NoticeDao(){}
		
	public ArrayList<Notice> selectTitleSearch(Connection con, String keyword) {
		// TODO Auto-generated method stub
		System.out.println(keyword);
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from CATEGORY_BOARD "
				+ "where category_title like ? and approval='Y' order by category_no desc";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+keyword + "%");
			rset = pstmt.executeQuery();
			if(rset != null)
			{
				list = new ArrayList<Notice>();
				
				while(rset.next())
				{
					Notice c = new Notice();
					
					c.setCategoryNo(rset.getInt("category_no"));
					c.setUserId(rset.getString("user_Id"));
					c.setCategoryGroup(rset.getInt("category_group"));
					c.setCategoryTitle(rset.getString("category_title"));
					c.setCategoryWriter(rset.getString("category_writer"));
					c.setCategoryContent(rset.getString("category_content"));
					c.setCategoryDate(rset.getDate("category_date"));
					c.setCategoryReadcount(rset.getInt("category_donation"));
					c.setCategoryDonation(rset.getInt("category_donation"));
					c.setWorkDate(rset.getInt("work_date"));
					c.setCategoryLevel(rset.getInt("category_level"));
					c.setCategoryRef(rset.getInt("category_ref"));
					c.setCategoryReplyRef(rset.getInt("category_reply_ref"));
					c.setCategoryReplySeq(rset.getInt("category_reply_seq"));
					c.setPhone(rset.getString("phone"));
					c.setEmail(rset.getString("email"));
					c.setOriginalImage(rset.getString("original_image"));
					c.setRenameImage(rset.getString("rename_image"));
					c.setSpecial(rset.getString("special"));
					c.setApproval(rset.getString("approval"));
					
					list.add(c);
				}
				System.out.println(list.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
		}
		
		return list;
		
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
