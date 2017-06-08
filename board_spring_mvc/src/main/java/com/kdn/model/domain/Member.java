package com.kdn.model.domain;

import java.io.Serializable;

public class Member implements Serializable{
	private int mno;
	private char grade = 'N';
	private String password;
	private String mname;
	private String phone;
	private String email;
	private int pno;

	public Member(){
		
	}
	public Member(int mno, String password, String mname, String phone, String email) {
		super();
		this.mno = mno;
		this.password = password;
		this.mname = mname;
		this.phone = phone;
		this.email = email;
	}
	
	public Member(int mno, String password, String mname, String phone, String email, int pno) {
		super();
		this.mno = mno;
		this.password = password;
		this.mname = mname;
		this.phone = phone;
		this.email = email;
		this.pno = pno;
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	@Override
	public String toString() {
		return "Member [mno=" + mno + ", grade=" + grade + ", password="
				+ password + ", mname=" + mname + ", phone=" + phone
				+ ", email=" + email + "]";
	}
}
