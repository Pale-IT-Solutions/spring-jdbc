package com.core.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.spring.dao.CompanyDao;
import com.core.spring.dao.DepartmentDao;
import com.core.spring.entity.Company;
import com.core.spring.entity.Department;
import com.core.spring.service.MyService;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private DepartmentDao deptDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveCompanyAndDept() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		Company company = new Company();
		company.setName("GIC");
		company.setAddress("Tokyo, Japan ");
		company.setPhone("0123456789");

		Integer companyId = this.companyDao.save(company);

		Department dept = new Department();
		dept.setName("DEPT-Name");
		dept.setCompanyId(companyId);

		this.deptDao.save(dept);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

}