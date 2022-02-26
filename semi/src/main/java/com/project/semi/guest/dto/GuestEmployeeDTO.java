package com.project.semi.guest.dto;

import java.sql.Date;

public class GuestEmployeeDTO {
	public String id;
	public String password;
	public String member_name;
	public Date birth;
	public String address;
	public String phone;
	public String classification;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClassification() {
		return classification;
	}
	@Override
	public String toString() {
		return "GuestEmployeeDTO [id=" + id + ", password=" + password + ", member_name=" + member_name
				+ ", birth=" + birth + ", address=" + address + ", phone=" + phone + ", classification="
				+ classification + "]";
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
}
