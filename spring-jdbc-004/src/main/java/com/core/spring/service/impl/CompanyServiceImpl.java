package com.core.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.core.spring.dao.CompanyDao;
import com.core.spring.entity.Company;
import com.core.spring.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao dao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveCompanyOneObj() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("START---" + methodName);

		Company company = new Company();
		company.setName("GIC");
		company.setAddress("Tokyo, Japan ");
		company.setPhone("0123456789");

		this.dao.save(company);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public void saveCompanyFiveObj() throws Exception {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		List<Company> companies = new ArrayList<Company>();
		for (int id = 0; id <= 5; id++) {

			Company company = new Company();
			company.setName("GIC");
			company.setAddress("Tokyo, Japan ");
			company.setPhone("0123456789");

			companies.add(company);

		}

		this.dao.saveAll(companies);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void update(Company company) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("START---" + methodName);

		this.dao.save(company);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteById(Integer id) {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		this.dao.deleteById(id);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteAll() {

		String methodName = this.getClass().getEnclosingClass().getName();
		System.out.println("START---" + methodName);

		this.dao.deleteAll();

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

	@Override
	public Company findById(Integer id) {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		Company company = this.dao.findById(id).orElse(null);
		System.out.println(company);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);

		return company;
	}

	@Override
	public List<Company> findAll() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		List<Company> list = (List<Company>) this.dao.findAll();
		if (null != list) {
			list.forEach(System.out::println);
		}

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);

		return list;
	}

}