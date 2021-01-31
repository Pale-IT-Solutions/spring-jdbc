package com.core.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.spring.entity.Company;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

}
