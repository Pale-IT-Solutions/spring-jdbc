package com.core.spring.dao;

import java.util.List;

import com.core.spring.entity.Company;

public interface CompanyDao {

	Integer save(Company company);

	void update(Company company);

	Company findById(Integer id);

	void deleteById(Integer id);

	void deleteAll();

	List<Company> findAll();
}