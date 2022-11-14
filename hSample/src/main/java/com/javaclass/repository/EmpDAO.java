package com.javaclass.repository;

import java.util.HashMap;
import java.util.List;

import com.javaclass.domain.EmpVO;

public interface EmpDAO {
	List<EmpVO> empSelect();
	
	List<HashMap> empDept();

}
