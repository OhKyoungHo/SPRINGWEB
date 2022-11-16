package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data : 모든 인자를 인식할 수는 없음
@Setter
@Getter
@NoArgsConstructor
//모든 인자를 인식할 수 있는 @AllArgsConstructor 필요
@AllArgsConstructor
public class SampleVO {
	
	private String name;
	private Integer age;
	private String message;

	
	

}
