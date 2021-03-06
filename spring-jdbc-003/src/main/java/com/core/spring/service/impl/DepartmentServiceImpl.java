package com.core.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.spring.dao.DepartmentDao;
import com.core.spring.entity.Department;
import com.core.spring.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao dao;

	@Override
	public Department findById(Integer id) {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		Department company = this.dao.findById(id);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);

		return company;
	}

}