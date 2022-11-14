package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import com.javaclass.domain.EmpVO;

public interface EmpService {
	
	List<EmpVO> empSelect();
	
	public List<HashMap> empDept();

}
