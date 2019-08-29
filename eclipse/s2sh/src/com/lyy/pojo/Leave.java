package com.lyy.pojo;

import java.util.Date;

public class Leave {

	private int id;
	private String name;
	private Integer number;
	private String package_;
	private String reason;
	private Date leaveDate;
	
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPackage_() {
		return package_;
	}
	public void setPackage_(String package_) {
		this.package_ = package_;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	@Override
	public String toString() {
		return "Leave [ name=" + name + ", number=" + number + ", package_=" + package_ + ", reason="
				+ reason + ", leaveDate=" + leaveDate + "]";
	}
	
	
}
