package com.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.entity.Department;
import com.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;

	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepo.findByDepartmentId(departmentId);
    }
}
