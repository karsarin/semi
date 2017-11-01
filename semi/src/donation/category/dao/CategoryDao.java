package donation.category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import static donation.common.JDBCTemplate.*;


import donation.category.vo.Category;

public class CategoryDao {

	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from category_board where approval='Y'";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				result = rset.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}
		
		return result;
	}

	public ArrayList<Category> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Category> category = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * "
				+ "from(select rownum rnum, T.* from category_board T) a " 
				+ "where a.rnum >= ? and a.rnum <= ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			if(rset != null)
			{
				category = new ArrayList<Category>();
				
				while(rset.next())
				{
					Category c = new Category();
					c.setCategoryNo(rset.getInt("category_no"));
					c.setUserId(rset.getString("user_Id"));
					c.setCategoryGroup(rset.getInt("category_group"));
					c.setCategoryTitle(rset.getString("category_title"));
					c.setCategoryWriter(rset.getString("category_writer"));
					c.setCategoryContent(rset.getString("category_content"));
					c.setCategoryDate(rset.getDate("category_date"));
					c.setCategoryReadcount(rset.getInt("category_readcount"));
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
					
					category.add(c);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			
		}
		return category;
	}

	public int addReadCount(Connection con, int cnum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update category_board set category_readcount = category_readcount + 1 where category_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection con, int cnum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from category_board where category_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertCategory(Connection con, Category c) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into category_board values((select max(category_no) + 1 from category_board), ?, ?, ?, ?, ?, sysdate, 0, ?, ?, (select max(category_no) + 1 from category_board), 0, 0, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, default, default, default)";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, c.getUserId());
			pstmt.setInt(2, c.getCategoryGroup());
			pstmt.setString(3, c.getCategoryTitle());
			pstmt.setString(4, c.getUserId());
			pstmt.setString(5, c.getCategoryContent());
			pstmt.setInt(6, c.getCategoryDonation());
			pstmt.setInt(7, c.getWorkDate());
			pstmt.setString(8, c.getPhone());
			pstmt.setString(9, c.getEmail());
			pstmt.setString(10, c.getOriginalImage());
			pstmt.setString(11, c.getRenameImage());
			pstmt.setString(12, c.getAddImage1());
			pstmt.setString(13, c.getAddRenameImage1());
			pstmt.setString(14, c.getAddImage2());
			pstmt.setString(15, c.getAddRenameImage2());
			pstmt.setString(16, c.getAddImage3());
			pstmt.setString(17, c.getAddRenameImage3());
			pstmt.setString(18, c.getAddImage4());
			pstmt.setString(19, c.getAddRenameImage4());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}

	public Category selectCategory(Connection con, int cnum) {
		Category category = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from category_board where category_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				category = new Category();
				
				category.setCategoryNo(rset.getInt("CATEGORY_NO"));
				category.setCategoryTitle(rset.getString("CATEGORY_TITLE"));
				category.setCategoryWriter(rset.getString("CATEGORY_WRITER"));
				category.setCategoryContent(rset.getString("category_content"));
				category.setUserId(rset.getString("USER_ID"));
				category.setCategoryGroup(rset.getInt("CATEGORY_GROUP"));
				category.setCategoryDate(rset.getDate("category_date"));
				category.setCategoryReadcount(rset.getInt("category_readcount"));
				category.setCategoryDonation(rset.getInt("category_donation"));
				category.setWorkDate(rset.getInt("work_date"));
				category.setCategoryLevel(rset.getInt("category_level"));
				category.setCategoryRef(rset.getInt("category_ref"));
				category.setCategoryReplyRef(rset.getInt("category_reply_ref"));
				category.setCategoryReplySeq(rset.getInt("category_reply_seq"));
				category.setPhone(rset.getString("phone"));
				category.setEmail(rset.getString("email"));
				category.setOriginalImage(rset.getString("original_image"));
				category.setRenameImage(rset.getString("rename_image"));
				
				category.setAddImage1(rset.getString("add_Image1"));
				category.setAddImage2(rset.getString("add_Image2"));
				category.setAddImage3(rset.getString("add_Image3"));
				category.setAddImage4(rset.getString("add_Image4"));
				
				category.setAddRenameImage1(rset.getString("add_rename_image1"));
				category.setAddRenameImage2(rset.getString("add_rename_image2"));
				category.setAddRenameImage3(rset.getString("add_rename_image3"));
				category.setAddRenameImage4(rset.getString("add_rename_image4"));
				category.setSpecial(rset.getString("special"));
				category.setApproval(rset.getString("approval"));
				category.setPurchaseCount(rset.getInt("purchase_count"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return category;
	}

	//분류별 카테고리 리스트 가져오기
	public ArrayList<Category> cfselectList(Connection con, int currentPage, int limit, String str) {
		
		ArrayList<Category> category = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int cfNum = 8;
		if(str.equals("IT")){
			cfNum = 1; 
		}else if(str.equals("Design")){
			cfNum = 2;
		}else if(str.equals("Marketing")){
			cfNum = 3;
		}else if(str.equals("Music")){
			cfNum = 4;
		}else if(str.equals("Knowhow")){
			cfNum = 5;
		}else if(str.equals("Translation")){
			cfNum = 6;
		}else if(str.equals("Health")){
			cfNum = 7;
		}else{
			cfNum = 8;
		}
		
		
		String query = "select * from (select * from category_board order by category_ref desc, category_reply_ref desc, category_level asc, category_reply_seq asc) "
				+ "where rownum >= ? and rownum <= ? and category_group = ? and approval='Y'";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, cfNum);
			
			rset = pstmt.executeQuery();
			
			if(rset != null)
			{
				category = new ArrayList<Category>();
				
				while(rset.next())
				{
					Category c = new Category();
					c.setCategoryNo(rset.getInt("category_no"));
					c.setUserId(rset.getString("user_Id"));
					c.setCategoryGroup(rset.getInt("category_group"));
					c.setCategoryTitle(rset.getString("category_title"));
					c.setCategoryWriter(rset.getString("category_writer"));
					c.setCategoryContent(rset.getString("category_content"));
					c.setCategoryDate(rset.getDate("category_date"));
					c.setCategoryReadcount(rset.getInt("category_readcount"));
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
					c.setAddImage1(rset.getString("add_Image1"));
					c.setAddImage2(rset.getString("add_Image2"));
					c.setAddImage3(rset.getString("add_Image3"));
					c.setAddImage4(rset.getString("add_Image4"));
					
					c.setAddRenameImage1(rset.getString("add_rename_image1"));
					c.setAddRenameImage2(rset.getString("add_rename_image2"));
					c.setAddRenameImage3(rset.getString("add_rename_image3"));
					c.setAddRenameImage4(rset.getString("add_rename_image4"));
					c.setSpecial(rset.getString("special"));
					c.setApproval(rset.getString("approval"));
					c.setPurchaseCount(rset.getInt("purchase_count"));
					
					category.add(c);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			
		}
		return category;
		
		
	}

	public int addPurchaseCount(Connection con, int cnum) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = "update category_board set purchase_count = purchase_count + 1 where category_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		return result;
	}

	public int insertPurchaseList(Connection con, int categoryNo, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		
				
		String query = "insert into CATEGORY_USED values((select max(use_no) + 1 from category_used), ?, ?, default)";
		
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setInt(2, categoryNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		return result;
	}

	public int updateCategory(Connection con, Category c) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update category_board set category_group = ?, "
						+ "category_title = ?, category_content = ?, "
						+ "category_donation = ?, work_date = ?, "
						+ "phone = ?, email = ?, original_image = ?, rename_image = ?, "
						+ "add_image1 = ?, add_image2 = ?, add_image3 = ?, add_image4 = ?, "
						+ "add_rename_image1 = ?, add_rename_image2 = ?, add_rename_image3 = ?, "
						+ "add_rename_image4 = ? "
						+ "where category_no = ? ";
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, c.getCategoryGroup());
			pstmt.setString(2, c.getCategoryTitle());
			pstmt.setString(3, c.getCategoryContent());
			pstmt.setInt(4, c.getCategoryDonation());
			pstmt.setInt(5, c.getWorkDate());
			pstmt.setString(6, c.getPhone());
			pstmt.setString(7, c.getEmail());
			pstmt.setString(8, c.getOriginalImage());
			pstmt.setString(9, c.getRenameImage());
			pstmt.setString(10, c.getAddImage1());
			pstmt.setString(11, c.getAddImage2());
			pstmt.setString(12, c.getAddImage3());
			pstmt.setString(13, c.getAddImage4());

			pstmt.setString(14, c.getAddRenameImage1());
			pstmt.setString(15, c.getAddRenameImage2());
			pstmt.setString(16, c.getAddRenameImage3());
			pstmt.setString(17, c.getAddRenameImage4());
			pstmt.setInt(18, c.getCategoryNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
					e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateApprove(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update category_board set approval='Y' where category_no=?";
		try {
			pstmt = con.prepareStatement(query);			
			pstmt.setInt(1, cno);			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}

	public int deletePurchase(Connection con, int cnum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from category_used where category_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
}
