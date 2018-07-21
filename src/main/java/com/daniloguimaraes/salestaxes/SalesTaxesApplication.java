package com.daniloguimaraes.salestaxes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.daniloguimaraes.salestaxes.*")
public class SalesTaxesApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SpringApplication.run(SalesTaxesApplication.class, args);
	}

	@RequestMapping(path = "/docs" , method = RequestMethod.GET)
	public View docsRedirect(){
		return new RedirectView("swagger-ui.html");
	}
}
