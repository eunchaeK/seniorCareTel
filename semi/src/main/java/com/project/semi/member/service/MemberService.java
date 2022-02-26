package com.project.semi.member.service;

import java.util.List;

import com.project.semi.member.dto.MemberDTO;
import com.project.semi.paging.dto.Criteria;


public interface MemberService {
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;
	public MemberDTO passwordCheck(MemberDTO memberDTO) throws Exception;
	public List<MemberDTO> searchMemberInfo(MemberDTO memberDTO) throws Exception;
	public List<MemberDTO> getSearchList(MemberDTO memberDTO) throws Exception;
	
	public int updateInfo(MemberDTO memberDTO) throws Exception;
	public int updatePassword(MemberDTO memberDTO) throws Exception;
	
	public MemberDTO readReservationInfo(int visit_number) throws Exception;
	public int reservListCnt() throws Exception;
	
	public List<MemberDTO> searchReservations(MemberDTO memberDTO) throws Exception;
	public int insertReservation(MemberDTO memberDTO) throws Exception;
	public int updateReservation(MemberDTO memberDTO) throws Exception;
	public void removeReservation(int visit_number) throws Exception;
	
	
}
