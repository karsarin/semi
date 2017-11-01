package donation.notice.model.vo;

import java.sql.Date;

public class CommentNotice {
	private int commentNum;
	private int noticeNum;
	private String writer;
	private Date date;
	private String date2;
	private String content;
	 
	public CommentNotice() {}
	
	public CommentNotice(int commentNum, int noticeNum, String writer, Date date, String content) {
		super();
		this.commentNum = commentNum;
		this.noticeNum = noticeNum;
		this.writer = writer;
		this.date = date;
		this.content = content;
	}
	public CommentNotice(int noticeNum, String writer, String content) {
		super();
		this.noticeNum = noticeNum;
		this.writer = writer;
		this.content = content;
	}

	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getnoticeNum() {
		return noticeNum;
	}
	public void setnoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDateString() {
		return this.date2;
	}
	
	public void setDateString(String date2) {
		this.date2 = date2;
	}


}

