package kr.inflearn.comment.model;

import java.util.Date;

public class ReCommentVO {
	
	private int reCommentId;
	private int commentId;
	private int boardnum;
	private int num;
	private String content;
	private String commentWriter;
	private Date regdate;
	
	
	public int getReCommentId() {
		return reCommentId;
	}
	public void setReCommentId(int reCommentId) {
		this.reCommentId = reCommentId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	public ReCommentVO() {}
	
	public ReCommentVO(int reCommentId, int commentId, int boardnum, int num, String content, String commentWriter,
			Date regdate) {
		this.reCommentId = reCommentId;
		this.commentId = commentId;
		this.boardnum = boardnum;
		this.num = num;
		this.content = content;
		this.commentWriter = commentWriter;
		this.regdate = regdate;
	}
	
	
	@Override
	public String toString() {
		return "ReCommentVO [reCommentId=" + reCommentId + ", commentId=" + commentId + ", boardnum=" + boardnum
				+ ", num=" + num + ", content=" + content + ", commentWriter=" + commentWriter + ", regdate=" + regdate
				+ "]";
	}
	
	
	

	
	
}
