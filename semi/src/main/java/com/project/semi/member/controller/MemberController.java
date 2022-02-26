package com.project.semi.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.semi.member.dto.MemberDTO;
import com.project.semi.member.service.MemberService;

@Controller("memberController")
@RequestMapping(value = "/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberDTO memberDTO;

	@RequestMapping("/memberMain")
	public String memberMain() {
		return "memberMain";
	}

	@RequestMapping("/memberCovid")
	public String covid() {
		return "memberCovid";
	}

	@RequestMapping("/memberMenu")
	public String memberMenu() {
		return "memberMenu";
	}

	@RequestMapping("/memberGuideInfo")
	public String memberGuideInfo() {
		return "memberGuideInfo";
	}

	@RequestMapping("/memberGuideInfoCost")
	public String memberGuideInfoCost() {
		return "memberGuideInfoCost";
	}

	@RequestMapping("/memberMap")
	public String memberMap() {
		return "memberMap";
	}

	@RequestMapping("/memberSignup")
	public String memberSignup() {
		return "member/memberSignup";
	}
	
	@RequestMapping("/memberFacilities")
	public String memberFacilities() {
		return "memberFacilities";
	}
	
	@RequestMapping("/memberStaff")
	public String memberStaff() {
		return "memberStaff";
	}

//	로그인

	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public String loginGET(MemberDTO member) throws Exception {
		logger.info("로그인 페이지 진입");
		return "memberLogin";
	}

	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberDTO memberDTO, RedirectAttributes rttr) throws Exception {
		logger.info("로그인 진입");
		System.out.println("전달된 데이터: " + memberDTO);
		HttpSession session = request.getSession();
		MemberDTO lvo = memberService.memberLogin(memberDTO);
		// 일치하는 아이디, 비밀번호가 아닐 경우
		if (lvo == null) {
			logger.info("일치하는 아이디, 비밀번호가 아닐 경우");
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/member/memberLogin";
		}
		// 일치하는 아이디 비밀번호가 있는 경우
		logger.info("일치하는 아이디, 비밀번호");
		// lvo.setPassword(""); //비밀번호는 보안상 ""처리
		session.setAttribute("member", lvo);
		session.setAttribute("id", lvo.getId());
		session.setAttribute("password", lvo.getPassword());
		session.setAttribute("member_name", lvo.getMember_name());
		session.setAttribute("patient_name", lvo.getPatient_name());
		session.setAttribute("isLogOn", true);
		
		logger.info("세션에 저장된 id: " + session.getAttribute("id"));
		logger.info("세션에 저장된 비밀번호 : " + session.getAttribute("password"));
		logger.info("세션에 저장된 member_name : " + session.getAttribute("member_name"));

		logger.info("로그인 Service 성공");
		return "redirect:/member/memberWho";
	}
	
	//회원 로그아웃 
		@GetMapping("/logout")
		public String memberLogout(HttpServletRequest req) {
			logger.info("회원 로그아웃 진입");
			HttpSession session = req.getSession();
			session.invalidate();
			
			return "redirect:/member/memberLogin";
		}

//	로그인 후 멤버가 보호자인지 직원인지에 따라 경로를 다르게 해줌

	@RequestMapping(value = "/memberWho", method = RequestMethod.GET)
	public String classificationGET(HttpSession session, Model model) throws Exception {
		logger.info("회원 정보 수정 페이지 진입");
		// System.out.println("회원수정 전달된 데이터: " + session.getAttribute("member") );
		MemberDTO mem = (MemberDTO) session.getAttribute("member");
		String id = (String) session.getAttribute("id");
		String classification = mem.getClassification();
		logger.info("회원정보 수정 GET의 멤버DTO: " + mem);
		logger.info("회원정보 수정 GET의 아이디: " + id);
		logger.info("회원정보 수정 GET의 classification: " + classification);
		if (classification.equals("직원")) {
			return "redirect:/employee/employeeMain";
		} else if (classification.equals("보호자")) {
			return "redirect:/member/memberMain";
		} else {
			return "redirect:/member/memberLogin";
		}
	}

	// 보호자 수정페이지
	@RequestMapping(value = "/memberModify", method = RequestMethod.GET)
	public void modifyGET(HttpSession session, Model model) throws Exception {
		logger.info("보호자 정보 수정 페이지 진입");
		MemberDTO mem = (MemberDTO) session.getAttribute("member");
		logger.info("보호자 정보 수정 GET의 : " + mem);

	}

	/* 회원 정보 수정 기능 : 테이블 값 읽어오기 ( 비밀번호 ) */
	@GetMapping("/memberUpdatePassword")
	public ModelAndView memberUpdatePassword(ModelAndView mav, MemberDTO memberDTO, HttpSession session)
			throws Exception {

		mav = new ModelAndView("member/memberModifyPassword");
		String member_name = (String) session.getAttribute("member_name");

		memberDTO.setMember_name(member_name);
		List<MemberDTO> memberInfoList = memberService.searchMemberInfo(memberDTO);
		mav.addObject("memberInfoList", memberInfoList);

		return mav;
	}

	/* 회원 정보 수정 선택 페이지 이동 */
	@GetMapping("/memberModifySelection")
	public String memberModifySelection() {
		return "member/memberModifySelection";
	}

	/* 면회 예약 조회 */
	@GetMapping("/searchReservations")
	public ModelAndView searchReservations(ModelAndView mav, MemberDTO memberDTO, HttpSession session)
			throws Exception {
		mav = new ModelAndView("member/searchReservations");
		String member_name = (String) session.getAttribute("member_name");

		memberDTO.setMember_name(member_name);
		logger.info("DTO에 member_name 저장 완료 " + memberDTO.getMember_name());
		List<MemberDTO> reservationList = memberService.searchReservations(memberDTO);
		mav.addObject("reservationList", reservationList);

		return mav;
	}

	/* 면회 검색 기능 */
	@RequestMapping(value = "/getMemberReservList", method = RequestMethod.GET)
	@ResponseBody
	private List<MemberDTO> getPatientList(@RequestParam("type") String type, @RequestParam("keyword") String keyword)
			throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setType(type);
		dto.setKeyword(keyword);
		List<MemberDTO> list = memberService.getSearchList(dto);
		return list;
	}


	/* 면회 신청 페이지 이동 */
	@GetMapping("/memberCreateReservation")
	public String memberCreateReservation() {
		return "member/memberCreateReservation";
	}

	/* 면회 신청 기능 */
	@RequestMapping(value = "/reservationInsert", method = RequestMethod.POST)
	public String reservationInsert(@ModelAttribute MemberDTO memebrDTO) throws Exception {
		int result = memberService.insertReservation(memebrDTO);
		return "redirect:/member/searchReservations";
	}

	/* 면회 삭제 기능 */

	@RequestMapping("reservDelete")
	public ModelAndView reservationDelete(@RequestParam("visit_number") int visit_number) throws Exception {
		memberService.removeReservation(visit_number); // DB에서 삭제만 해주면 되는것. 별도로 어디에다가 정의할 필요가 없음.
		ModelAndView mav = new ModelAndView("redirect:/member/searchReservations");
		return mav;
	}

	/* 면회 수정 기능 : 테이블 값 읽어오기 */
	@RequestMapping(value = "/memberModReservation", method = RequestMethod.GET)
	public String reservationUpdate(HttpServletRequest req, Model model) throws Exception {
		int visit_number = Integer.parseInt(req.getParameter("visit_number"));
		model.addAttribute("reservation", memberService.readReservationInfo(visit_number)); // memberDTO형식으로 정보 담아옴->
																							// reservation으로 담아 jsp뿌림.
		return "member/memberModReservation";
		// visit_number 로 예약내역 가져오고 modForm 에서 바꾼값을 form으로 전송 . 컨트로럴로 post mapping받고 그걸로
		// service로 updateReservation하기.
	}

	/* 면회 수정 기능 : 값 변경하기. */
	@RequestMapping(value = "/memberModReservation", method = RequestMethod.POST)
	public String reservationUpdateSubmit(@ModelAttribute MemberDTO memebrDTO) throws Exception {
		// memberDTO 에 form값이 자동으로 저장되어서 그걸 그대로 서비스에 넣는다?..
		System.out.println(memberDTO.getMember_name());
		int result = memberService.updateReservation(memebrDTO);
		return "redirect:/member/searchReservations";
	}

	/* 회원 정보 수정 기능 : 테이블 값 읽어오기 ( 공통 ) */
	@GetMapping("/memberUpdate")
	public ModelAndView selectMemberInfo(ModelAndView mav, MemberDTO memberDTO, HttpSession session) throws Exception {
		
		logger.info("개인정보수정진입");
		mav = new ModelAndView("member/memberModify");
		String member_name = (String) session.getAttribute("member_name");
		logger.info("member_name : " + member_name);
		
		memberDTO.setMember_name(member_name);
		List<MemberDTO> memberInfoList = memberService.searchMemberInfo(memberDTO);
		mav.addObject("memberInfoList", memberInfoList);

		return mav;
	}

	/* 회원 정보 수정 기능 ( 비밀번호 제외 ) */
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updateInfo(HttpSession session, MemberDTO memberDTO, Model model) throws Exception {
		// String name = adminService.memberLogin(adminDTO);

		MemberDTO dto = null;
		try {
			dto = memberService.memberLogin(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(" 에러가발생");
		}

		if (dto != null) {

			// 이제 서비스에 updateInfo로 비밀번호만 바꿔보자.
			// 새로입력받은 비밀번호를 dto 에 set으로 저장하기.

			int result = memberService.updateInfo(memberDTO);

			session.setAttribute("member_name", memberDTO.getMember_name());
			session.setAttribute("phone", memberDTO.getPhone());
			session.setAttribute("address", memberDTO.getAddress());

			logger.info("회원 정보 수정 후 세션에 저장 완료");

			return "redirect:/member/memberMain";

		} else {
			model.addAttribute("msg", "failure");
			return "redirect:/member/memberLogin";
		}

	}

	/* 회원 정보 수정 기능 ( 비밀번호 ) */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String updatePassword(HttpSession session, MemberDTO memberDTO, Model model) throws Exception {
		// String name = adminService.memberLogin(adminDTO);
		logger.info("패스워드 체크 진입 : 아이디 : " + memberDTO.getId());
		logger.info("패스워드 체크 진입 : 기존 비번 : " + memberDTO.getPassword());
		logger.info("패스워드 체크 진입 : 새 비번  : " + memberDTO.getNewPassword());

		MemberDTO dto = null;
		try {
			dto = memberService.memberLogin(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (dto != null) {

			// 새로입력받은 비밀번호를 dto 에 set으로 저장하기.

			int result = memberService.updatePassword(memberDTO);

			session.setAttribute("password", memberDTO.getNewPassword());

			logger.info("회원 정보 수정 후 세션에 저장 완료 : ");
			String password = (String) session.getAttribute("password");
			logger.info("세션에 저장된 비밀번호 : " + password);

			return "redirect:/member/memberMain";

		} else {
			System.out.println("존재하지않는 아이디,비밀번호입니다.");
			model.addAttribute("msg", "failure");
			return "redirect:/member/memberLogin";
		}

	}

}