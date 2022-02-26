package com.project.semi.guest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.semi.guest.dto.GuestEmployeeDTO;
import com.project.semi.guest.dto.GuestMemberDTO;
import com.project.semi.guest.service.GuestEmployeeService;
import com.project.semi.guest.service.GuestMemberService;
import com.project.semi.member.controller.MemberController;

@Controller("guestController")
public class GuestController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private GuestMemberService memberservice;
	
	@Autowired
	private GuestEmployeeService employeeservice;
	
	@RequestMapping("/home")
	public String main() {
		return "home"; 
	}
	
	@RequestMapping(value="/memberSignup", method=RequestMethod.GET)
	public String joinGET(GuestMemberDTO member) throws Exception{
		logger.info("보호자 회원가입페이지 진입");
		return "memberSignup";
	}
	
	
	@ResponseBody
	@PostMapping("/idCheck")
	public String idCheck(@RequestParam("id") String id) {
		logger.info("userIdCheck 진입");
		logger.info("id:" + id);
		int cnt = memberservice.idCheck(id);
		logger.info("확인 결과: " + cnt);
		if(cnt != 0) {
			return "fail";
		}else {
			return "success";
		}
	}
	
	@RequestMapping(value="memberSignup", method=RequestMethod.POST)
	public String joinPOST(GuestMemberDTO member) throws Exception{
		logger.info("보호자 join진입");
		//회원가입 서비스 실행
		memberservice.memberJoin(member);
		logger.info("join Service 성공");
		return "redirect:/home";
	}
	
	@RequestMapping(value="/employeeSignup", method=RequestMethod.GET)
	public String hireGET(GuestEmployeeDTO member) throws Exception{
		logger.info("요양보호사 회원가입페이지 진입");
		return "employeeSignup";
	}
	
	@RequestMapping(value="employeeSignup", method=RequestMethod.POST)
	public String hirePOST(GuestEmployeeDTO member) throws Exception{
		logger.info("요양보호사 join진입");
		//회원가입 서비스 실행
		employeeservice.employeeJoin(member);
		logger.info("join Service 성공");
		return "redirect:/home";
	}
	
	
}