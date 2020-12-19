/**
 * 
 */
package com.prakash.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Prakash
 *
 */
//@RestController
public class InternationalizationController {
	
	@Autowired   
	private MessageSource messageSource;
	
	//internationalization  
	@GetMapping(path="/internationalized")  
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)  
	{  
	return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());  
	}  

}
