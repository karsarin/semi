package donation.freeBoard.model.vo;

import java.sql.Date;

public class FreeBoard implements java.io.Serializable{
	private static final long serialVersionUID = 10001L;
	 
	
	
	private int freeBoardNo;
	private String freeBoardTitle;
	private String freeBoardWriter;
	private String freeBoardContent;
	private Date freeBoardDate;
	private String originalImageName;
	private String renameImageName;
	private int readCount;
	private String boardType;
	private int board_no;
	
	public FreeBoard(){}
	
	
	public FreeBoard(int freeBoardNo, String freeBoardTitle, String freeBoardWriter, String freeBoardContent, Date freeBoardDate,
			String originalImageName, String renameImageName, int readCount, String boardType, int board_no) {
		super();
		this.freeBoardNo = freeBoardNo;
		this.freeBoardTitle = freeBoardTitle;
		this.freeBoardWriter = freeBoardWriter;
		this.freeBoardContent = freeBoardContent;
		this.freeBoardDate = freeBoardDate;
		this.originalImageName = originalImageName;
		this.renameImageName = renameImageName;
		this.readCount = readCount;
		this.boardType = boardType;
		this.board_no = board_no;
	}


	public int getBoard_no() {
		return board_no;
	}


	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}


	public String getBoardType() {
		return boardType;
	}


	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}


	public int getfreeBoardNo() {
		return freeBoardNo;
	}
	public void setfreeBoardNo(int freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}
	public String getfreeBoardTitle() {
		return freeBoardTitle;
	} 
	public void setfreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}
	public String getfreeBoardWriter() {
		return freeBoardWriter;
	}
	public void setfreeBoardWriter(String freeBoardWriter) {
		this.freeBoardWriter = freeBoardWriter;
	}
	public String getfreeBoardContent() {
		return freeBoardContent;
	}
	public void setfreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public Date getfreeBoardDate() {
		return freeBoardDate;
	}
	public void setfreeBoardDate(Date freeBoardDate) {
		this.freeBoardDate = freeBoardDate;
	}
	public String getOriginalImageName() {
		return originalImageName;
	}
	public void setOriginalImageName(String originalImageName) {
		this.originalImageName = originalImageName;
	}
	public String getRenameImageName() {
		return renameImageName;
	}
	public void setRenameImageName(String renameImageName) {
		this.renameImageName = renameImageName;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
	@Override
	public String toString(){
		return this.freeBoardNo + ", " +  this.freeBoardTitle + ", " + this.freeBoardWriter + ", " +
				this.freeBoardContent + ", " +  this.freeBoardDate + ", " +  this.originalImageName + ", " +  
				this.renameImageName + ", " +  this.readCount;
	}



	
	
	
}
