package com.core.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.core.spring.config.Config;
import com.core.spring.entity.Company;
import com.core.spring.entity.Department;
import com.core.spring.service.CompanyService;
import com.core.spring.service.DepartmentService;
import com.core.spring.service.MyService;

public class App {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		MyService service = (MyService) ctx.getBean("myServiceImpl");
		CompanyService companyService = ctx.getBean(CompanyService.class);
		DepartmentService departmentService = ctx.getBean(DepartmentService.class);

		service.saveCompanyAndDept();

		Company company = companyService.findById(1);
		System.out.println(company);

		Department dept = departmentService.findById(1);
		System.out.println(dept);

		ctx.close();
	}

}
