package com.project.semi.admin.service;

import java.util.List;

import com.project.semi.admin.dto.AdminDTO;
import com.project.semi.paging.dto.Criteria;

public interface AdminService {

	// 회원
	public int memListCnt() throws Exception;
	public List<AdminDTO> selectMembers(Criteria cri) throws Exception;
	public List<AdminDTO> getSearchMemList(AdminDTO adminDTO) throws Exception;
	public AdminDTO beforeMemApproval(int number) throws Exception;
	public int approvalUpdate(AdminDTO dto) throws Exception;
	public int familyInsert(AdminDTO dto) throws Exception;
	public AdminDTO readMemberInfo(int number) throws Exception;
	public int updateMember(AdminDTO dto) throws Exception;
	public int deleteRegister(int number) throws Exception;

	// 직원
	public int empListCnt() throws Exception;
	public List<AdminDTO> selectEmps(Criteria cri) throws Exception;
	public List<AdminDTO> getSearchEmpList(AdminDTO dto) throws Exception;
	public AdminDTO beforeEmpApproval(int number) throws Exception;
	public int caregiverInsert(AdminDTO dto) throws Exception;
	public AdminDTO readEmpInfo(int number) throws Exception;
	public int updateEmp(AdminDTO dto) throws Exception;

	// 로그인
	public AdminDTO loginCheck(AdminDTO adminDTO) throws Exception;

	// 예약
	public List<AdminDTO> selectReservation(Criteria cri) throws Exception;
	public AdminDTO readReservationInfo(int visit_number) throws Exception;
	public int updateReservation(AdminDTO adminDTO) throws Exception;
	public int removeReservation(int visit_number) throws Exception;
	public int reservListCnt() throws Exception;
	public List<AdminDTO> getSearchReservationList(AdminDTO adminDTO) throws Exception;

}
