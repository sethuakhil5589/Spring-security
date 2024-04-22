package com.akhil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Students {
	@Id
	private Integer sId;
	private String sName;
	private String sCourse;
	public Students() {
		super();
	}
	public Students(Integer sId, String sName, String sCourse) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sCourse = sCourse;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsCourse() {
		return sCourse;
	}
	public void setsCourse(String sCourse) {
		this.sCourse = sCourse;
	}
	@Override
	public String toString() {
		return "Students [sId=" + sId + ", sName=" + sName + ", sCourse=" + sCourse + "]";
	}
}
