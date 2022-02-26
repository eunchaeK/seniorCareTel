package com.project.semi.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.semi.admin.dao.AdminDAO;
import com.project.semi.admin.dto.AdminDTO;
import com.project.semi.paging.dto.Criteria;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	public AdminServiceImpl(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	// https://dalpaeng00.tistory.com/83
	@Override
	public List<AdminDTO> selectMembers(Criteria cri) throws Exception {
		return adminDAO.selectAllMemberList(cri);
	}

	// 검색 필터
	@Override
	public List<AdminDTO> getSearchMemList(AdminDTO adminDTO) throws Exception {
		return adminDAO.selectSearchMemList(adminDTO);
	}

	@Override
	public AdminDTO beforeMemApproval(int number) throws Exception {
		return adminDAO.beforeMemApproval(number);
	}

	@Override
	public int approvalUpdate(AdminDTO dto) throws Exception {
		return adminDAO.approvalUpdate(dto);
	}

	@Override
	public int familyInsert(AdminDTO dto) throws Exception {
		return adminDAO.familyInsert(dto);
	}

	@Override
	public AdminDTO readMemberInfo(int number) throws Exception {
		return adminDAO.readMemberInfo(number);
	}

	@Override
	public int updateMember(AdminDTO dto) throws Exception {
		return adminDAO.updateMember(dto);
	}

	@Override
	public int deleteRegister(int number) throws Exception {
		return adminDAO.deleteRegister(number);
	}

	@Override
	public AdminDTO loginCheck(AdminDTO adminDTO) throws Exception {
		return adminDAO.loginCheck(adminDTO);
	}

	@Override
	public int memListCnt() throws Exception {
		return adminDAO.memListCnt();
	}

	@Override
	public int empListCnt() throws Exception {
		return adminDAO.empListCnt();
	}

	@Override
	public List<AdminDTO> selectEmps(Criteria cri) throws Exception {
		return adminDAO.selectAllEmpList(cri);
	}
	
	@Override
	public List<AdminDTO> getSearchEmpList(AdminDTO dto) throws Exception {
		return adminDAO.selectSearchEmpList(dto);
	}

	@Override
	public AdminDTO beforeEmpApproval(int number) throws Exception {
		return adminDAO.beforeEmpApproval(number);
	}

	@Override
	public int caregiverInsert(AdminDTO dto) throws Exception {
		return adminDAO.caregiverInsert(dto);
	}

	@Override
	public AdminDTO readEmpInfo(int number) throws Exception {
		return adminDAO.readEmpInfo(number);
	}

	@Override
	public int updateEmp(AdminDTO dto) throws Exception {
		return adminDAO.updateEmp(dto);
	}

	// 예약
	@Override
	public List<AdminDTO> selectReservation(Criteria cri) throws Exception {
		List<AdminDTO> reservationList = null;
		reservationList = adminDAO.selectAllReservationList(cri);
		return reservationList;
	}

	@Override
	public AdminDTO readReservationInfo(int visit_number) throws Exception {
		System.out.println("ServiceImpl" + adminDAO.readReservationInfo(visit_number));
		return adminDAO.readReservationInfo(visit_number);
	}

	@Override
	public int updateReservation(AdminDTO adminDTO) throws Exception {
		return adminDAO.updateReservation(adminDTO);
	}

	@Override
	public int removeReservation(int visit_number) throws Exception {
		return adminDAO.deleteReservation(visit_number);
	}

	@Override
	public int reservListCnt() throws Exception {
		return adminDAO.reservListCnt();
	}

	// 검색 필터
	@Override
	public List<AdminDTO> getSearchReservationList(AdminDTO adminDTO) throws Exception {
		return adminDAO.selectSearchReservationList(adminDTO);
	}
}
