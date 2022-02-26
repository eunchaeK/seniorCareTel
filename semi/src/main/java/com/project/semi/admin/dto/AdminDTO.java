package com.project.semi.admin.dto;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("adminDTO")
public class AdminDTO {
	// 공통
	private int number;
	private String id;
	private String password;
	private String member_name;
	private Date birth;
	private String address;
	private String phone;
	private String classification;
	private boolean approval;
	// private String approval;

	// 환자
	private int patient_number;
	private String patient_name;
	private Date patient_birth;
	private String patient_address;
	private String patient_phone;
	private Date hospitalization_date;
	private Date discharge_date;
	private String application;

	// 직원
	private int room_number;
	private Date start_date;
	private Date resignation_date;

	// 관리자
	private String admin_id;
	private String admin_password;

	// 예약
	private int visit_number;
	private String visit_meeting;
	private Date visit_date;
	private Time visit_time;

	// 보호자
	private int family_number;

	// 검색 필터
	private String type;
	private String keyword;

	public AdminDTO() {
		System.out.println("AdminDTO");
	}

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

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public int getPatient_number() {
		return patient_number;
	}

	public void setPatient_number(int patient_number) {
		this.patient_number = patient_number;
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

	public String getPatient_address() {
		return patient_address;
	}

	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}

	public String getPatient_phone() {
		return patient_phone;
	}

	public void setPatient_phone(String patient_phone) {
		this.patient_phone = patient_phone;
	}

	public Date getHospitalization_date() {
		return hospitalization_date;
	}

	public void setHospitalization_date(Date hospitalization_date) {
		this.hospitalization_date = hospitalization_date;
	}

	public Date getDischarge_date() {
		return discharge_date;
	}

	public void setDischarge_date(Date discharge_date) {
		this.discharge_date = discharge_date;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getResignation_date() {
		return resignation_date;
	}

	public void setResignation_date(Date resignation_date) {
		this.resignation_date = resignation_date;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
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

}
