package kr.inflearn.model;

import java.util.Date;

public class BoardVO {
	/*
	게터 세터는 바구니에 데이터를 넣고 빼주기 위해서 
	 디폴트 생성자를 만드는 이유? 안만드는 이유?
	생성자를 만드는 것은 객체를 생성해주기 위해서 아닌가?
    toString을 쓰는 이유와 안쓰는 이유?
    */
	
	//Field
	private int boardnum;
	private String writer;
	private String title;
	private String contents;
	private int count;
	private Date regdate;
	private Date updatedate;
	
	
	//Getter Setter
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	 
	//Default Constructor
	public BoardVO() {
		super();
	}
	
	//Constructor
	public BoardVO(int boardnum, String writer, String title, String contents, int count, Date regdate,
			Date updatedate) {
		super();
		this.boardnum = boardnum;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.count = count;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [boardnum=" + boardnum + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", count=" + count + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
	 
}
