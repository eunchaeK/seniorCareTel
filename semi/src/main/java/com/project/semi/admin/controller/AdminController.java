package com.project.semi.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.semi.admin.dto.AdminDTO;
import com.project.semi.admin.service.AdminService;
import com.project.semi.paging.dto.Criteria;
import com.project.semi.paging.dto.Paging;

import lombok.extern.slf4j.Slf4j;


@Controller("adminController")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminDTO adminDTO;
	
	private static String admin = "admin";	// 관리자 구분 
	
	// 관리자 메인 페이지 (관리자 로그인 페이지 따로 구현)
	@GetMapping("admin/adminMain")
	public String adminMain(HttpSession session, HttpServletResponse resp) {
		String classification = (String)session.getAttribute("classification");	//session에서 사용자 등급 체크 
		System.out.println("classification="+classification);
		try {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			if(classification != admin) {
				writer.println("<script>alert('관리자만 접근 가능합니다.');");
				writer.println("history.back();</script>");
				writer.flush();
				writer.close();
			}	
		}catch(IOException e) {
			e.printStackTrace();
			return "/home";
		}
		return "admin/adminMain";	
	}

	// 회원(가족)/////////////////////////////////////////////////////////////////////////

	/* 회원 리스트 */
	@GetMapping("/admin/memlist")
	public String memList(Criteria cri, Model model) throws Exception {
		//전체 회원 수(Paging)
		int memListCnt = adminService.memListCnt();
		
		//페이징 객체
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(memListCnt);
		
		List<AdminDTO> membersList = adminService.selectMembers(cri);
		model.addAttribute("membersList", membersList);
		model.addAttribute("paging",paging);
		model.addAttribute("memListCnt", memListCnt);
		
		
		return "admin/memlist";
	}

	/* 회원 승인 전 정보 가져오기 */
	@GetMapping("/admin/memberapproval")
	public String memApproval(HttpServletRequest req, Model model) throws Exception {
		int number = Integer.parseInt(req.getParameter("number"));
		model.addAttribute("member", adminService.beforeMemApproval(number));
		
		return "admin/memapproval";
	}

	/* 회원 승인 후 회원 리스트로 redirect */
	@PostMapping("/admin/memberapproval")
	public String memApprovalSubmit(@ModelAttribute AdminDTO dto, HttpServletResponse resp) throws Exception {
		
		try {
			
			int familyResult = adminService.familyInsert(dto);		//family에 데이터 insert 
			if(familyResult!=0) {
				adminService.approvalUpdate(dto); 					//register approval true & 정보  변경 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			return "redirect:/admin/memlist";
	}

	/* 회원 정보 수정 전 정보 가져오기 */
	@GetMapping("/admin/membermod")
	public String memMod(HttpServletRequest req, Model model) throws Exception{
		int number = Integer.parseInt(req.getParameter("number"));
		model.addAttribute("member", adminService.readMemberInfo(number));
		
		return "admin/membermod";
	}

	/* 회원정보 수정(update) 후 회원리스트 화면으로 redirect */
	@PostMapping("/admin/membermod")
	public void memModSubmit(@ModelAttribute AdminDTO dto, HttpServletResponse resp) throws Exception{
		int result = adminService.updateMember(dto);		//수정된 회원 수
		String pageURL = "/admin/memlist";
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		if(result >= 1) {
			writer.println("<script>alert('회원 정보 수정이 완료되었습니다.');");
			writer.println("location.href='" + pageURL + "';</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script>alert('회원 정보 수정에 실패했습니다. 다시 시도해주세요.');");
			writer.println("history.back();</script>");
			writer.flush();
			writer.close();
		}
	}

	/* 회원 삭제 */
	@PostMapping("/admin/memdelete")
	public void memberDelete(@RequestParam("delete_numbers") String[] delete_numbers, HttpServletResponse resp) throws Exception{
	  int result = 0;	// 총 삭제 회원 수 
	  String pageURL = "/admin/memlist";	
	  for(String num : delete_numbers) { 
	  	int number = Integer.parseInt(num);
	  	int delete = adminService.deleteRegister(number); 
	  	result += delete;	
	  }
	  
	  resp.setContentType("text/html; charset=UTF-8");
	  PrintWriter writer = resp.getWriter();
		if(result == delete_numbers.length) {
			writer.println("<script>alert('회원 삭제가 완료되었습니다.');");
			writer.println("location.href='" + pageURL + "';</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script>alert('회원 삭제에 실패했습니다. 다시 시도해주세요.');");
			writer.println("history.back();</script>");
			writer.flush();
			writer.close();
		}
	}

	/* 회원 검색 필터 */
	@PostMapping("/admin/getSearchMemList")
	@ResponseBody
	public List<AdminDTO> getSearchMemList(@RequestParam("type") String type, 
							@RequestParam("keyword") String keyword) throws Exception{
		
		AdminDTO dto = new AdminDTO();
		dto.setType(type);
		dto.setKeyword(keywordSetting(type, keyword));
		List<AdminDTO> list = adminService.getSearchMemList(dto);
		
		return list;
	}

	// 직원(요양사)////////////////////////////////////////////////////////////////////////////////
	/* 직원 리스트 */
	@GetMapping("/admin/emplist")
	public String adminEmpList(Criteria cri, Model model) throws Exception {
		
		int empListCnt = adminService.empListCnt();
		
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(empListCnt);
		
		List<AdminDTO> empsList = adminService.selectEmps(cri);
		model.addAttribute("empsList", empsList);
		model.addAttribute("paging", paging);
		model.addAttribute("empListCnt", empListCnt);
				
		return "admin/emplist";
	} 

	@GetMapping("/admin/empapproval")
	public String empApproval(HttpServletRequest req, Model model) throws Exception {
		int number = Integer.parseInt(req.getParameter("number"));
		model.addAttribute("emp", adminService.beforeEmpApproval(number));
		
		return "admin/empapproval";
	}

	@PostMapping("/admin/empapproval")
	public String empApprovalSubmit(@ModelAttribute AdminDTO dto) throws Exception {
		
		
			int familyResult = adminService.caregiverInsert(dto);		//family에 데이터 insert 
			if(familyResult!=0) {
				adminService.approvalUpdate(dto); 					//register approval true & 정보  변경 
			}
		
			return "redirect:/admin/emplist";
		
	}

	@GetMapping("/admin/empmod")
	public String adminEmpMod(HttpServletRequest req, Model model) throws Exception {
		int number = Integer.parseInt(req.getParameter("number"));
		System.out.println("number:" + number);
		model.addAttribute("emp", adminService.readEmpInfo(number));
		
		return "admin/empmod";
	} 

	@PostMapping("/admin/empmod")
	public void adminEmpModSubmit(@ModelAttribute AdminDTO dto, HttpServletResponse resp) throws Exception {
		int result = adminService.updateEmp(dto);		//수정된 회원 수
		String pageURL = "/admin/emplist";
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		if(result >= 1) {
			writer.println("<script>alert('요양사 정보 수정이 완료되었습니다.');");
			writer.println("location.href='" + pageURL + "';</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script>alert('요양사 정보 수정에 실패했습니다. 다시 시도해주세요.');");
			writer.println("history.back();</script>");
			writer.flush();
			writer.close();
		}
	}

	// 요양사 삭제
	@PostMapping("/admin/empdelete")
	public void employeeDelete(@RequestParam("delete_numbers") String[] delete_numbers, HttpServletResponse resp) throws Exception{
		int result = 0;	// 총 삭제 요양사 수 
		  String pageURL = "/admin/emplist";	
		  for(String num : delete_numbers) { 
		  	int number = Integer.parseInt(num);
		  	int delete = adminService.deleteRegister(number); 
		  	result += delete;	
		  }
		  
		  resp.setContentType("text/html; charset=UTF-8");
		  PrintWriter writer = resp.getWriter();
			if(result == delete_numbers.length) {
				writer.println("<script>alert('요양사 삭제가 완료되었습니다.');");
				writer.println("location.href='" + pageURL + "';</script>");
				writer.flush();
				writer.close();
			}else {
				writer.println("<script>alert('회원 삭제에 실패했습니다. 다시 시도해주세요.');");
				writer.println("history.back();</script>");
				writer.flush();
				writer.close();
			}
	}
	
	/* 요양사 검색 필터 */
	@PostMapping("/admin/getSearchEmpList")
	@ResponseBody
	public List<AdminDTO> getSearchEmpList(@RequestParam("type") String type, 
							@RequestParam("keyword") String keyword) throws Exception{
		
		AdminDTO dto = new AdminDTO();
		dto.setType(type);
		dto.setKeyword(keywordSetting(type, keyword));
		List<AdminDTO> list = adminService.getSearchEmpList(dto);
		
		return list;
	}
	
	
	/* 승인 o x 로 검색 */
	public String keywordSetting(String type, String keyword) {
		//o(true) : 1 / x(false) : 0 
		if(type.equals("approval") && keyword.equalsIgnoreCase("O")) {keyword="1";}
		else if(type.equals("approval") && keyword.equalsIgnoreCase("X")) {keyword="0";}
		return keyword;
	}
	
	
	
	// 예약////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/admin/reserve")
	public String adminReserv(Model model) {
		return "admin/reserve";
	}

	
	// 로그인
	// //////////////////////////////////////////////////////////////////////////////////////

	// 1. 관리자 로그인페이지 매핑
	@RequestMapping("/admin/adminLogin")
	public String login() {
		return "admin/adminLogin";
	}

	// 2. 관리자 로그인 체크
	// https://taes-k.github.io/2019/06/12/spring-security-1/

	@PostMapping("/admin/loginCheck")
	public String loginCheck(HttpSession session, AdminDTO adminDTO) throws Exception {

		AdminDTO dto = null;
		dto = adminService.loginCheck(adminDTO);
		//https://velog.io/@max9106/JSP-Session%EC%84%B8%EC%85%98-j0k5ccyiub
		
		// 로그인 성공
		if (dto != null) {
			session.setAttribute("isLogOn", true);
			session.setAttribute("classification", admin);
		
			System.out.println("로그인 성공! 아이디 : " + dto.getAdmin_id() + " 비밀번호 : " + dto.getAdmin_password());
			return "redirect:/admin/adminMain";
			
			// 로그인 실패
		} else {
			System.out.println("로그인 실패");
			session.setAttribute("isLogOn", false);
			return "redirect:/admin/adminLogin";
		}
	}

	// 3. 관리자 로그아웃
	@RequestMapping("/admin/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("classification");
		session.setAttribute("isLogOn", false);
		
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminLogin");
		mav.addObject("msg", "logout");*/
		return "redirect:/admin/adminLogin";
	}

	// 예약 관리
	@RequestMapping("/admin/reservList")
	public String reservationList(Criteria cri, Model model) throws Exception {
		// 전체 예약 수(Paging)
		int reservListCnt = adminService.reservListCnt();

		// 페이징 객체
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(reservListCnt);

		List<AdminDTO> reservationList = adminService.selectReservation(cri);
		model.addAttribute("reservationList", reservationList);
		model.addAttribute("paging", paging);
		model.addAttribute("reservListCnt", reservListCnt);
		return "admin/reservList";
	}
	
	@GetMapping("/admin/adminModReservation")
	public String reservationUpdate(HttpServletRequest req, Model model) throws Exception {
		int visit_number = Integer.parseInt(req.getParameter("visit_number"));
		model.addAttribute("reservation", adminService.readReservationInfo(visit_number));
		return "admin/adminModReservation";
	}

	@PostMapping("/admin/adminModReservation")
	public String reservationUpdateSubmit(@ModelAttribute AdminDTO adminDTO) throws Exception {
		int result = adminService.updateReservation(adminDTO);
		return "redirect:/admin/reservList";
	}

	// 면회예약 삭제
	@PostMapping("/admin/reservDelete")
	public void reservationDelete(@RequestParam("delete_numbers") String[] delete_numbers, HttpServletResponse resp) throws Exception{
		int result = 0;	// 총 삭제 면회예약 수 
		  String pageURL = "/admin/reservList";	
		  for(String num : delete_numbers) { 
		  	int visit_number = Integer.parseInt(num);
		  	int delete = adminService.removeReservation(visit_number); 
		  	result += delete;	
		  }
		  
		  resp.setContentType("text/html; charset=UTF-8");
		  PrintWriter writer = resp.getWriter();
			if(result == delete_numbers.length) {
				writer.println("<script>alert('면회 예약 삭제가 완료되었습니다.');");
				writer.println("location.href='" + pageURL + "';</script>");
				writer.flush();
				writer.close();
			}else {
				writer.println("<script>alert('면회 예약 삭제에 실패했습니다. 다시 시도해주세요.');");
				writer.println("history.back();</script>");
				writer.flush();
				writer.close();
			}
	}

	@GetMapping("/getSearchList")
	@ResponseBody
	public List<AdminDTO> getSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword)
			throws Exception {
		System.out.println("type:" + type);
		System.out.println("keyword: " + keyword);

		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setType(type);
		// o(true) : 1 / x(false) : 0
		if (keyword.equalsIgnoreCase("O")) {
			adminDTO.setKeyword("1");
		} else if (keyword.equalsIgnoreCase("X")) {
			adminDTO.setKeyword("0");
		} else {
			adminDTO.setKeyword(keyword);
		}
		List<AdminDTO> list = adminService.getSearchReservationList(adminDTO);

		return list;
	}
}
