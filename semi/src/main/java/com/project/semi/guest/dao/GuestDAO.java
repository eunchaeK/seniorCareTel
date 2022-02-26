package com.project.semi.guest.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project.semi.guest.dto.GuestEmployeeDTO;
import com.project.semi.guest.dto.GuestMemberDTO;

@Mapper
public interface GuestDAO {
	//보호자 회원가입
	public void memberJoin(GuestMemberDTO member);
	//요양보호사 회원가입
	public void employeeJoin(GuestEmployeeDTO member);
	//회원가입 시 아이디 중복 체크 
	public int idCheck(String id);
}
