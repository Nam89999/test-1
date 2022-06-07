package kr.inflearn.note.model;

import java.util.Date;

public class NoteVO {
	
	
	//Field 
	//담아줄 변수 생성
	private int noteId; // 쪽지 id
	private int senderNum; // 쪽지 발송인
	private int recipientNum; // 쪽지 수신인  (FK)
	private String title; // 쪽지제목
	private String content; // 쪽지 내용
	private Date regdate;// 쪽지 발송 시간
	private String senderMember;//발송인 Id
	private String recipientMember;//수신인Id
	private int readCheck;// 수신 유무확인
	
	//Getter Setter
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getSenderNum() {
		return senderNum;
	}
	public void setSenderNum(int senderNum) {
		this.senderNum = senderNum;
	}
	public int getRecipientNum() {
		return recipientNum;
	}
	public void setRecipientNum(int recipientNum) {
		this.recipientNum = recipientNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}	
	public int getReadCheck() {
		return readCheck;
	}
	public void setReadCheck(int readCheck) {
		this.readCheck = readCheck;
	}
	public String getSenderMember() {
		return senderMember;
	}
	public void setSenderMember(String senderMember) {
		this.senderMember = senderMember;
	}
	public String getRecipientMember() {
		return recipientMember;
	}
	public void setRecipientMember(String recipientMember) {
		this.recipientMember = recipientMember;
	}
	
	
	//Constructor
	
	public NoteVO() {}

	public NoteVO(int noteId, int senderNum, int recipientNum, String title, String content, Date regdate,
			String senderMember, String recipientMember, int readCheck) {
		super();
		this.noteId = noteId;
		this.senderNum = senderNum;
		this.recipientNum = recipientNum;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.senderMember = senderMember;
		this.recipientMember = recipientMember;
		this.readCheck = readCheck;
	}
	//toString

	@Override
	public String toString() {
		return "NoteVO [noteId=" + noteId + ", senderNum=" + senderNum + ", recipientNum=" + recipientNum + ", title="
				+ title + ", content=" + content + ", regdate=" + regdate + ", senderMember=" + senderMember
				+ ", recipientMember=" + recipientMember + ", readCheck=" + readCheck + "]";
	}
	
	



	
	
	
	
	
	
	
}
