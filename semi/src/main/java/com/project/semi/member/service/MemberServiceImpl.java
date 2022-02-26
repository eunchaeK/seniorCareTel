package com.project.semi.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.semi.member.dao.MemberDAO;
import com.project.semi.member.dto.MemberDTO;
import com.project.semi.paging.dto.Criteria;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;

	/* 회원 정보 수정 기능 : 비밀번호 변경 */
	@Override
	public int updatePassword(MemberDTO memberDTO) throws Exception {
		return memberDAO.updatePassword(memberDTO);
	}

	/* 회원 정보 수정 기능 : 현재 비밀번호 맞게 썼는지 체크 */
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberLogin(memberDTO);
	}

	/* ��ȸ ���� ��ȸ */
	@Override
	public List<MemberDTO> searchReservations(MemberDTO memberDTO) throws Exception {
		List<MemberDTO> reservationsList = null;
		reservationsList = memberDAO.selectAllReservationsList(memberDTO);
		return reservationsList;
	}

	/* 회원 정보 수정 시 회원 정보 불러오기 */
	@Override
	public List<MemberDTO> searchMemberInfo(MemberDTO memberDTO) throws Exception {
		List<MemberDTO> memberInfoList = null;
		memberInfoList = memberDAO.selectMemberInfo(memberDTO);
		return memberInfoList;
	}

	/* ��ȸ �˻� ���� */
	@Override
	public List<MemberDTO> getSearchList(MemberDTO memberDTO) throws Exception {
		return memberDAO.selectSearchList(memberDTO); // DAO�� mapper.xml�� �����ؼ� ������ ���� �� , AdminDTO��������
														// �̷���� List�� ���� �޴´�.
	}

	/* ��ȸ ���� */

	@Override
	public void removeReservation(int visit_number) throws Exception {
		memberDAO.deleteReservation(visit_number);
	}

	/* ���� ���� �ҷ�����. */
	@Override
	public MemberDTO readReservationInfo(int visit_number) throws Exception {
		System.out.println("ServiceImpl" + memberDAO.readReservationInfo(visit_number));
		return memberDAO.readReservationInfo(visit_number);
	}

	/* ��ȸ ���� ���� */
	@Override
	public int updateReservation(MemberDTO memberDTO) throws Exception {
		return memberDAO.updateReservation(memberDTO);
	}

	/* 회원 정보 수정 기능 : 일단 비번부터. */
	@Override
	public int updateInfo(MemberDTO memberDTO) throws Exception {
		return memberDAO.updateInfo(memberDTO);
	}

	/* ��ȸ ���� �߰� */
	@Override
	public int insertReservation(MemberDTO memberDTO) throws Exception {
		return memberDAO.insertReservation(memberDTO);
	}

	@Override
	public MemberDTO passwordCheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reservListCnt() throws Exception {
		return memberDAO.reservListCnt();
	}

}
