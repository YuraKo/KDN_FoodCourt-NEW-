package com.kdn.model.domain;

public class Review {
	private int rno;			//리뷰 넘버
	private int mno;			//사원 넘버
	private String regdate;		//등록일
	private int spoint;			//별점 점수
	private String comments;	//남길 말
	private int fno;
	private int fmno;			//음식 번호
	private String fname;		//음식 이름
	
	public Review(){}
	
	public Review(int rno, int mno, String regdate, int spoint,
			String comments, int fmno, String fname) {
		super();
		this.rno = rno;
		this.mno = mno;
		this.regdate = regdate;
		this.spoint = spoint;
		this.comments = comments;
		this.fmno = fmno;
		this.fname = fname;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getSpoint() {
		return spoint;
	}
	public void setSpoint(int spoint) {
		this.spoint = spoint;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getFmno() {
		return fmno;
	}
	public void setFmno(int fmno) {
		this.fmno = fmno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}

	public Review(int no, int mno, String regdate, int spoint, String comments,
			int fno, int fmno, String fname) {
		super();
		this.rno = no;
		this.mno = mno;
		this.regdate = regdate;
		this.spoint = spoint;
		this.comments = comments;
		this.fno = fno;
		this.fmno = fmno;
		this.fname = fname;
	}

	public int getNo() {
		return rno;
	}

	public void setNo(int no) {
		this.rno = no;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [no=").append(rno).append(", mno=").append(mno)
				.append(", regdate=").append(regdate).append(", spoint=")
				.append(spoint).append(", comments=").append(comments)
				.append(", fno=").append(fno).append(", fmno=").append(fmno)
				.append(", fname=").append(fname).append("]");
		return builder.toString();
	}
	
	
	
}
