package com.project.semi.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.semi.member.dto.MemberDTO;
import com.project.semi.paging.dto.Criteria;

@Mapper
@Repository("memberDAO")
public interface MemberDAO {
	
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;
	public MemberDTO passwordCheck(MemberDTO memberDTO) throws Exception;
		
	public List<MemberDTO> selectMemberInfo(MemberDTO memberDTO) throws DataAccessException;
	public List<MemberDTO> selectSearchList(MemberDTO memberDTO) throws Exception; 
	
	public int updateInfo(MemberDTO memberDTO) throws Exception;
	public int updatePassword(MemberDTO memberDTO) throws Exception;
	
	public MemberDTO readReservationInfo(int visit_number) throws Exception;
	public int reservListCnt() throws Exception;
	
	public List<MemberDTO> selectAllReservationsList(MemberDTO memberDTO) throws DataAccessException;
	public int insertReservation(MemberDTO memberDTO) throws Exception;
	public int updateReservation(MemberDTO memberDTO) throws Exception;
	public void deleteReservation(int visit_number) throws Exception;
	
}
