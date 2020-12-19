package com.prakash;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	//configuring default locale  
	@Bean  
	public  LocaleResolver localeResolver()  
	{  
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();  
		localeResolver.setDefaultLocale(Locale.US);  
		return localeResolver;   
	}  
}
