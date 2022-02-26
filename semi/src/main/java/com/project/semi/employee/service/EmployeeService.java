package com.project.semi.employee.service;

import java.util.List;

import com.project.semi.employee.dto.EmployeeDTO;
import com.project.semi.paging.dto.Criteria;

public interface EmployeeService {

	
	public List<EmployeeDTO> selectPatients(Criteria cri) throws Exception;
	public List<EmployeeDTO> searchReservations(Criteria cri) throws Exception;
	public List<EmployeeDTO> getPatientList(EmployeeDTO employeeDTO) throws Exception;
	public List<EmployeeDTO> getSearchList(EmployeeDTO employeeDTO) throws Exception;
	
	public int patientsListCnt() throws Exception;
	public int reservListCnt() throws Exception;
	
	public EmployeeDTO readPatientsInfo(int patient_number) throws Exception;
	public int insertPatient(EmployeeDTO employeeDTO) throws Exception;
	public int updatePatient(EmployeeDTO employeeDTO) throws Exception;
	public int deletePatient(int patient_number) throws Exception;
}
