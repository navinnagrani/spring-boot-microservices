package com.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//VO stands for Value Objects. No duplication , just need some info from department. No need of POJO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
private Long departmentId;
	
	private String departmentName;
	
	private String departmentAddress;
	
	private String departmentCode;

}
