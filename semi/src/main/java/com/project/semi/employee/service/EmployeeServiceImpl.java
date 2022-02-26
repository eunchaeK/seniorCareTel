package com.project.semi.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.semi.employee.dao.EmployeeDAO;
import com.project.semi.employee.dto.EmployeeDTO;
import com.project.semi.paging.dto.Criteria;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public List<EmployeeDTO> selectPatients(Criteria cri) throws Exception {
		List<EmployeeDTO> patientsList = null;
		patientsList = employeeDAO.selectAllPatientsList(cri);
		return patientsList;
	}

	@Override
	public List<EmployeeDTO> searchReservations(Criteria cri) throws Exception {
		List<EmployeeDTO> reservationsList = null;
		reservationsList = employeeDAO.selectAllReservationsList(cri);
		return reservationsList;
	}

	//ȯ�� �˻� ���
	@Override
	public List<EmployeeDTO> getPatientList(EmployeeDTO employeeDTO) throws Exception {
			return employeeDAO.selectPatientList(employeeDTO); // DAO�� mapper.xml�� �����ؼ� ������ ���� �� , AdminDTO�������� �̷���� List�� ���� �޴´�.
	}
	
	// ��ȸ �˻� ����
	@Override
	public List<EmployeeDTO> getSearchList(EmployeeDTO employeeDTO) throws Exception {
			return employeeDAO.selectSearchList(employeeDTO); // DAO�� mapper.xml�� �����ؼ� ������ ���� �� , AdminDTO�������� �̷���� List�� ���� �޴´�.
	}

	@Override
	public int patientsListCnt() throws Exception {
		return employeeDAO.patientsListCnt();
	}

	@Override
	public int reservListCnt() throws Exception {
		return employeeDAO.reservListCnt();
	}

	@Override
	public int insertPatient(EmployeeDTO employeeDTO) throws Exception {
		return employeeDAO.insertPatient(employeeDTO);
	}

	@Override
	public int updatePatient(EmployeeDTO employeeDTO) throws Exception {
		return employeeDAO.updatePatient(employeeDTO);
	}

	@Override
	public EmployeeDTO readPatientsInfo(int patient_number) throws Exception {
		return employeeDAO.readPatientsInfo(patient_number);
	}

	@Override
	public int deletePatient(int patient_number) throws Exception {
		return employeeDAO.deletePatient(patient_number);
	}


}
