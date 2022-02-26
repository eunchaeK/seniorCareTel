package com.project.semi.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.semi.employee.dto.EmployeeDTO;
import com.project.semi.employee.service.EmployeeService;
import com.project.semi.paging.dto.Criteria;
import com.project.semi.paging.dto.Paging;

@Controller("employeeController")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/* 요양사 로그아웃 */
	@RequestMapping("/employee/logout")
	public String employeeLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/member/memberLogin";
	}

	/* 환자 검색 기능 */
	@GetMapping("/getPatientList")
	@ResponseBody
	private List<EmployeeDTO> getPatientList(@RequestParam("type") String type, @RequestParam("keyword") String keyword) throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setType(type);
		dto.setKeyword(keyword);
		List<EmployeeDTO> list = employeeService.getPatientList(dto);
		return list;
	}
	

	/* 면회 검색 기능 */
	@GetMapping("/getEmployeeReservList")
	@ResponseBody
	private List<EmployeeDTO> getSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword)
			throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setType(type);
		dto.setKeyword(keyword);
		List<EmployeeDTO> list = employeeService.getSearchList(dto);

		return list; // AdminDTO속성의 원소들을 담은 list array를 result로서 ajax에 보낸다.
	}

	/* 요양 보호사 메인 페이지 */
	@GetMapping("/employee/employeeMain")
	public String memberMain() {
		return "employee/employeeMain";
	}
	
	@GetMapping("/employee/employeeSearchRooms")
	public String searchRooms() {
		return "employee/employeeSearchRooms";
	}

	/* 환자 조회 */
	@GetMapping("/employee/searchPatients")
	public ModelAndView searchPatients(Criteria cri, ModelAndView mav) throws Exception {// 전체 예약 수(Paging)
		int patientsListCnt = employeeService.patientsListCnt();

		// 페이징 객체
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(patientsListCnt);

		mav = new ModelAndView("employee/searchPatients");

		List<EmployeeDTO> patientsList = employeeService.selectPatients(cri);
		mav.addObject("patientsList", patientsList);
		mav.addObject("paging", paging);

		return mav;
	}

	/* 면회 예약 조회 */
	@GetMapping("/employee/searchReservations")
	public ModelAndView searchReservations(Criteria cri, ModelAndView mav) throws Exception {

		// 전체 예약 수(Paging)
		int reservListCnt = employeeService.reservListCnt();

		// 페이징 객체
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(reservListCnt);

		mav = new ModelAndView("employee/searchReservations");

		List<EmployeeDTO> reservationList = employeeService.searchReservations(cri);
		mav.addObject("reservationList", reservationList);
		mav.addObject("paging", paging);
		return mav;
	}
	
	/* 면회 신청 기능 */
	@GetMapping("/employee/employeeInsertPatients")
	public String employeeInsertPatients() {
		return "employee/employeeInsertPatients";
	}
	
	@PostMapping("/employee/employeeInsertPatients")
	public String reservationInsertPost(@ModelAttribute EmployeeDTO employeeDTO) throws Exception {
		int patientResult = employeeService.insertPatient(employeeDTO);
		return "redirect:/employee/searchPatients";
	}

}
