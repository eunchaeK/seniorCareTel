package com.project.semi.guest.dto;

import java.sql.Date;

public class GuestMemberDTO {
	public String id;
	public String password;
	public String member_name;
	public Date birth;
	public String address;
	public String phone;
	public String classification;
	public String patient_name;
	public Date patient_birth;
	
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
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public Date getPatient_birth() {
		return patient_birth;
	}
	public void setPatient_birth(Date patient_birth) {
		this.patient_birth = patient_birth;
	}

	@Override
	public String toString() {
		return "GuestMemberDTO [id=" + id + ", password=" + password + ", member_name=" + member_name
				+ ", birth=" + birth + ", address=" + address + ", phone=" + phone + ", classification="
				+ classification + ", patient_name=" + patient_name + ", patient_birth=" + patient_birth + "]";
	}
	
	

}
