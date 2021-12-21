package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.VO.Department;
import com.user.VO.ResponseTemplateVO;
import com.user.entity.User;
import com.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepo.save(user);
    }

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepo.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), 
				Department.class);
		
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
		
	}
}
