package com.lyy.pojo;

import java.util.Date;

public class User {
   public int id;
   
   public String name;
   
   public String pwd;
   
   public String sexual;
   
   public Integer number;
   
   public Integer grade;
   
   public String zhunye;
   
   public String class_;
   
   public String gongyu;
   
   public String roomno;
   
   public Date lastDate;
   
   public Integer type;
   
   
   
    
   public Integer getType() {
	return type;
}

public void setType(Integer type) {
	this.type = type;
}

public Date getLastDate() {
	return lastDate;
}

public void setLastDate(Date lastDate) {
	this.lastDate = lastDate;
}

public User(){
	    
   }
   
   public User(String name,String pwd){
	   this.name=name;
	   this.pwd=pwd;
   }
   
   
   

public String getSexual() {
	return sexual;
}

public void setSexual(String sexual) {
	this.sexual = sexual;
}

 

public Integer getNumber() {
	return number;
}

public void setNumber(Integer number) {
	this.number = number;
}

public Integer getGrade() {
	return grade;
}

public void setGrade(Integer grade) {
	this.grade = grade;
}

public String getZhunye() {
	return zhunye;
}

public void setZhunye(String zhunye) {
	this.zhunye = zhunye;
}

public String getClass_() {
	return class_;
}

public void setClass_(String class_) {
	this.class_ = class_;
}

public String getGongyu() {
	return gongyu;
}

public void setGongyu(String gongyu) {
	this.gongyu = gongyu;
}

public String getRoomno() {
	return roomno;
}

public void setRoomno(String roomno) {
	this.roomno = roomno;
}


   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
   
}
