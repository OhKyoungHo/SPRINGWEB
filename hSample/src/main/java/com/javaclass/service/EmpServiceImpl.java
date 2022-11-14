package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.domain.EmpVO;
import com.javaclass.repository.EmpDAO;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public List<EmpVO> empSelect(){
		return empDAO.empSelect();
	}
	
	public List<HashMap> empDept(){
		return empDAO.empDept();
	}

}
