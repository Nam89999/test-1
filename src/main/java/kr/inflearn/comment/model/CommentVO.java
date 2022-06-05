package kr.inflearn.comment.model;

import java.util.Date;
import java.util.List;

public class CommentVO {

    private int commentId;
    private int boardnum;
    private int num;
    private String content;
    private String commentWriter;
    private Date regdate;
    private boolean isBoardWriter; //글쓴이 댓글 분류를 위해 추가
    private List<ReCommentVO> recommentList; //대댓글 목록 불러오기를 위해 추가 


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

    public List<ReCommentVO> getRecommentList() {
		return recommentList;
	}

	public void setRecommentList(List<ReCommentVO> recommentList) {
		this.recommentList = recommentList;
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
