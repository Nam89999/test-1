package kr.inflearn.comment.model;

import java.util.Date;

public class CommentVO {

    private int commentId;
    private int boardnum;
    private int num;
    private String content;
    private String commentWriter;
    private Date regdate;
    private boolean isBoardWriter;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public boolean getIsBoardWriter() {
        return isBoardWriter;
    }
    // 이건 뭐지? 왜이렇게 했나?
    public void setIsBoardWriter(boolean isBoardWriter) {
       this.isBoardWriter = isBoardWriter;
    }
    
    /*public void setBoardWriter(boolean boardWriter) {
       isBoardWriter = BoardWriter;
    }
     * 
     * */



    public CommentVO(int commentId, int boardnum, int num, String content, String commentWriter, Date regdate,
    		boolean isBoardWriter) {
        this.commentId = commentId;
        this.boardnum = boardnum;
        this.num = num;
        this.content = content;
        this.commentWriter = commentWriter;
        this.regdate = regdate;
        this.isBoardWriter = isBoardWriter;


    }

    @Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", boardnum=" + boardnum + ", num=" + num + ", content=" + content
				+ ", commentWriter=" + commentWriter + ", regdate=" + regdate + ", isBoardWriter=" + isBoardWriter
				+ "]";
	}

	public CommentVO() {
        // TODO Auto-generated constructor stub
    }


}
