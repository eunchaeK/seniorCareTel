package com.project.semi.employee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.semi.employee.dto.EmployeeDTO;
import com.project.semi.paging.dto.Criteria;

@Mapper
@Repository("employeeDAO")
public interface EmployeeDAO {
	
		public List<EmployeeDTO> selectAllPatientsList(Criteria cri) throws DataAccessException;
		public List<EmployeeDTO> selectAllReservationsList(Criteria cri) throws DataAccessException;
		public List<EmployeeDTO> selectPatientList(EmployeeDTO employeeDTO)throws Exception;
		public List<EmployeeDTO> selectSearchList(EmployeeDTO employeeDTO) throws Exception; // 쿼리문 실행 후 나온 값들을 AdminDTO형식으로 받고 List에 담아준다.
		public int patientsListCnt() throws Exception;
		public int reservListCnt() throws Exception;
		
		public EmployeeDTO readPatientsInfo(int patient_number) throws Exception;
		public int insertPatient(EmployeeDTO employeeDTO) throws Exception;
		public int updatePatient(EmployeeDTO employeeDTO) throws Exception;
		public int deletePatient(int patient_number) throws Exception;
}
