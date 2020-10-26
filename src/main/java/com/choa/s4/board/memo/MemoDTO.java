package com.choa.s4.board.memo;

import java.sql.Date;

public class MemoDTO {
	
private long num;
private String Writer;
private String contents;
private Date regDate;


public long getNum() {
	return num;
}
public void setNum(long num) {
	this.num = num;
}
public String getWriter() {
	return Writer;
}
public void setWriter(String writer) {
	Writer = writer;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}



}
