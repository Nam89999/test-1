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
	private int num; // 외부키
	private String title;
	private String contents;
	private int count;
	private Date regdate;
	private Date updatedate;
	private String writer;
	
	//Getter Setter
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	 
	//Default Constructor
	public BoardVO(){}
	
	//Constructor
	public BoardVO(int boardnum, int num, String title, String contents, int count, Date regdate,
			Date updatedate, String writer) {
		
		this.boardnum = boardnum;
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.count = count;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.writer = writer;

	}

	

	@Override
	public String toString() {
		return "BoardVO [boardnum=" + boardnum + ", num=" + num + ", title=" + title + ", contents=" + contents
				+ ", count=" + count + ", regdate=" + regdate + ", updatedate=" + updatedate + ", writer=" + writer
				+ "]";
	}

	
	 
}
