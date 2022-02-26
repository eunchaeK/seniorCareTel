package com.project.semi.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.semi.admin.dto.AdminDTO;
import com.project.semi.paging.dto.Criteria;

@Mapper
@Repository("adminDAO")
public interface AdminDAO {
	// 회원
	public List<AdminDTO> selectAllMemberList(Criteria cri) throws DataAccessException;
	public int memListCnt() throws Exception;
	public List<AdminDTO> selectSearchMemList(AdminDTO adminDTO) throws Exception;
	public AdminDTO beforeMemApproval(int number) throws Exception;
	public int approvalUpdate(AdminDTO dto) throws Exception;
	public int familyInsert(AdminDTO dto) throws Exception;
	public AdminDTO readMemberInfo(int number) throws Exception;
	public int updateMember(AdminDTO dto) throws Exception;
	public int deleteRegister(int number) throws Exception;

	// 직원
	public int empListCnt() throws Exception; // 총 직원 수
	public List<AdminDTO> selectAllEmpList(Criteria cri) throws DataAccessException; // 직원 리스트
	public List<AdminDTO> selectSearchEmpList(AdminDTO dto) throws Exception;
	public AdminDTO beforeEmpApproval(int number) throws Exception;
	public int caregiverInsert(AdminDTO dto) throws Exception;
	public AdminDTO readEmpInfo(int number) throws Exception;
	public int updateEmp(AdminDTO dto) throws Exception;

	// 로그인
	public AdminDTO loginCheck(AdminDTO adminDTO) throws Exception;

	// 예약
	public List<AdminDTO> selectAllReservationList(Criteria cri) throws DataAccessException;
	public AdminDTO readReservationInfo(int visit_number) throws Exception;
	public int updateReservation(AdminDTO adminDTO) throws Exception;
	public int deleteReservation(int visit_number) throws Exception;
	public int reservListCnt() throws Exception;
	public List<AdminDTO> selectSearchReservationList(AdminDTO adminDTO) throws Exception;
}
