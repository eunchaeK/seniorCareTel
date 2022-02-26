package com.project.semi.guest.service;

import com.project.semi.guest.dto.GuestMemberDTO;

public interface GuestMemberService {
	public void memberJoin(GuestMemberDTO member) throws Exception;
	
	public int idCheck(String id);
}
