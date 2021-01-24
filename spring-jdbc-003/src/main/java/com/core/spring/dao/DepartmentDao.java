package com.core.spring.dao;

import java.util.List;

import com.core.spring.entity.Department;

public interface DepartmentDao {

	Integer save(Department dept);

	void update(Department dept);

	Department findById(Integer id);

	void deleteById(Integer id);

	void deleteAll();

	List<Department> findAll();
}