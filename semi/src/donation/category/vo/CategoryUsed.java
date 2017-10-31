package donation.category.vo;

import java.sql.Date;

public class CategoryUsed {
	private int useNo;
	private String categoryName;
	private String categoryTitle;
	private String use_id;
	private String writer_id;
	private Date usedDate;
	
	public CategoryUsed() {
		super();
	}

	public CategoryUsed(int useNo, String categoryName, String categoryTitle, String use_id, String writer_id,
			Date usedDate) {
		super();
		this.useNo = useNo;
		this.categoryName = categoryName;
		this.categoryTitle = categoryTitle;
		this.use_id = use_id;
		this.writer_id = writer_id;
		this.usedDate = usedDate;
	}

	public int getUseNo() {
		return useNo;
	}

	public void setUseNo(int useNo) {
		this.useNo = useNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getUse_id() {
		return use_id;
	}

	public void setUse_id(String use_id) {
		this.use_id = use_id;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}
	
	
	
}
