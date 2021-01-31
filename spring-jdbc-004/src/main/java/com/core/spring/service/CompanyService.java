package com.core.spring.service;

import java.util.List;

import com.core.spring.entity.Company;

public interface CompanyService {

	void saveCompanyOneObj();

	void saveCompanyFiveObj() throws Exception;

	void update(Company company);

	Company findById(Integer id);

	void deleteById(Integer id);

	void deleteAll();

	List<Company> findAll();
}