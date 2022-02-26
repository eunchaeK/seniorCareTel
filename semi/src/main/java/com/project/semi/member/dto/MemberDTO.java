package com.project.semi.member.dto;

import java.sql.Time;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberDTO")
public class MemberDTO {
	// 공통
	private int number;
	private String id;
	private String password;
	private String member_name;
	private Date birth;
	private String address;
	private String phone;
	private String classification;

	// 환자
	private String patient_name;
	private Date patient_birth;
	private int patient_number;

	// 면회 예약
	private int visit_number;
	private String visit_meeting;
	private Date visit_date;
	private Time visit_time;
	private int family_number;

	// 면회 예약 검색 필터
	private String type;
	private String keyword;

	// 회원 정보 수정 시 새로운 비밀번호
	private String newPassword;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

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

	public int getPatient_number() {
		return patient_number;
	}

	public void setPatient_number(int patient_number) {
		this.patient_number = patient_number;
	}

	public int getVisit_number() {
		return visit_number;
	}

	public void setVisit_number(int visit_number) {
		this.visit_number = visit_number;
	}

	public String getVisit_meeting() {
		return visit_meeting;
	}

	public void setVisit_meeting(String visit_meeting) {
		this.visit_meeting = visit_meeting;
	}

	public Date getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}

	public Time getVisit_time() {
		return visit_time;
	}

	public void setVisit_time(Time visit_time) {
		this.visit_time = visit_time;
	}

	public int getFamily_number() {
		return family_number;
	}

	public void setFamily_number(int family_number) {
		this.family_number = family_number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
