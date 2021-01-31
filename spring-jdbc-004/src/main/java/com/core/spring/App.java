package com.core.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.core.spring.config.Config;
import com.core.spring.service.CompanyService;

public class App {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		CompanyService service = (CompanyService) ctx.getBean("companyServiceImpl");

		service.saveCompanyOneObj();
//		service.saveCompanyFiveObj();

//		Company company = service.findById(1);
//
//		company.setName(company.getName() + "XXXXXXXX");
//
//		service.update(company);
//
//		company = service.findById(1);
//		System.out.println(company);

		ctx.close();
	}

}
