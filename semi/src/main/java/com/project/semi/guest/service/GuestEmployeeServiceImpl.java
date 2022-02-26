package com.project.semi.guest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.project.semi.guest.dao.GuestDAO;
import com.project.semi.guest.dto.GuestEmployeeDTO;
import com.project.semi.member.controller.MemberController;

@Service
public class GuestEmployeeServiceImpl implements GuestEmployeeService{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	GuestDAO guestDAO;
	
	@Override
	public void employeeJoin(GuestEmployeeDTO member) throws Exception {
		logger.info("employeeJoin진입");
		guestDAO.employeeJoin(member);
		
	}
}
