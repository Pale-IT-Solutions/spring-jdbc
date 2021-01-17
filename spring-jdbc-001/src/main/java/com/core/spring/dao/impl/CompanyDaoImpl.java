package com.core.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.core.spring.dao.CompanyDao;
import com.core.spring.dao.mapper.CompanyMapper;
import com.core.spring.entity.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public void save(Company company) {
		final String insert = "insert into company(id, name, address, phone) values(?, ?, ?, ?)";
		jdbcTemplate.update(insert, company.getId(), company.getName(), company.getAddress(), company.getPhone());
	}

	@Override
	public void update(Company company) {
		final String insert = "update company set name = ?, address = ?, phone = ? where id = ?";
		jdbcTemplate.update(insert, company.getName(), company.getAddress(), company.getPhone(), company.getId());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Company findById(Integer id) {

		final String sql = "select * from company where id = ?";
		Company company = jdbcTemplate.queryForObject(sql, new Object[] { id }, companyMapper);
		return company;
	}

	@Override
	public void deleteById(Integer id) {
		final String delete = "delete from company where id = ?";
		jdbcTemplate.update(delete, id);
	}

	@Override
	public void deleteAll() {
		final String delete = "delete from company";
		jdbcTemplate.update(delete);
	}

	@Override
	public List<Company> findAll() {
		final String sql = "select * from company";
		List<Company> list = jdbcTemplate.query(sql, companyMapper);
		return list;
	}

	@Override
	public Integer getCount() {
		final String sql = "select count(*) from company";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

}