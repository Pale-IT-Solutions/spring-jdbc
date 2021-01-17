package com.core.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.core.spring.config.Config;
import com.core.spring.service.CompanyService;

@Component
public class App {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		CompanyService service = (CompanyService) ctx.getBean("companyServiceImpl");

		// service.saveCompanyOneObj();

		service.saveCompanyFiveObj();

		ctx.close();
	}

}
