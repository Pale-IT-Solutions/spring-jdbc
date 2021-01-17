package com.core.spring.service.impl;

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

		Integer count = this.dao.getCount();
		Integer id = count + 1;

		Company company = new Company();
		company.setId(id);
		company.setName("GIC" + id);
		company.setAddress("Tokyo, Japan " + id);
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

		Integer count = this.dao.getCount();
		Integer id = count + 1;

		for (; id <= count + 5;) {

			Company company = new Company();
			company.setId(id);
			company.setName("GIC" + id);
			company.setAddress("Tokyo, Japan " + id);
			company.setPhone("0123456789");

			if (id == count + 3) {
				System.out.println(id + " == " + (count + 3) + " count :  Rollback ......");
				throw new Exception();
			}

			this.dao.save(company);

			id++;
		}

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void update(Company company) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("START---" + methodName);

		this.dao.update(company);

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

		Company company = this.dao.findById(id);

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);

		return company;
	}

	@Override
	public List<Company> findAll() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		List<Company> list = this.dao.findAll();

		System.out.println("Successfully......");
		System.out.println("END---" + methodName);

		return list;
	}

}