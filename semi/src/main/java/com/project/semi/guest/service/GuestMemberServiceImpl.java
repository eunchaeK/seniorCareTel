package com.project.semi.guest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.project.semi.guest.dao.GuestDAO;
import com.project.semi.guest.dto.GuestMemberDTO;
import com.project.semi.member.controller.MemberController;

@Service
@SpringBootApplication(scanBasePackages={"com.project.semi.guest.mapper"})
@ComponentScan({"com.project.semi.guest.mapper"})
public class GuestMemberServiceImpl implements GuestMemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	GuestDAO membermapper;
	
	@Override
	public void memberJoin(GuestMemberDTO member) throws Exception {
		logger.info("memberJoin진입");
		membermapper.memberJoin(member);
	}
	
	@Override
	public int idCheck(String id) {
		return membermapper.idCheck(id);
	}
}
