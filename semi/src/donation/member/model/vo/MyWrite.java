package donation.member.model.vo;

import java.sql.Date;

public class MyWrite {
	private int listNo;
	private String boardName;
	private int boardNo;
	private String title;
	private int count;
	private String writer;
	private String writeDate;

	
	public MyWrite() {
		super();
	}
	

	public MyWrite(int listNo, String boardName, int boardNo, String title, int count, String writer,
			String writeDate) {
		super();
		this.listNo = listNo;
		this.boardName = boardName;
		this.boardNo = boardNo;
		this.title = title;
		this.count = count;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	

	public int getListNo() {
		return listNo;
	}


	public void setListNo(int listNo) {
		this.listNo = listNo;
	}


	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}


	@Override
	public String toString(){
		return this.getListNo() + "," + this.getBoardName() + ","+ this.getBoardNo() +"," + this.getTitle()
		+ "," + this.getWriter() + "," + this.getCount() + "," + this.getWriteDate();
	}
	
}
