package com.vandu.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vandu.editor.LocalDateEditor;
import com.vandu.editor.LocalTimeEditor;
import com.vandu.entity.Crickter;
import com.vandu.service.ICrickterMgmtService;

@Controller
public class CrickterController {
	@Autowired
	private ICrickterMgmtService service;

	@GetMapping("/")
	public String showFormPage(@ModelAttribute("ckt") Crickter ckt) {
		System.out.println("CustomerController.showcustomerRegistrationForm()");
		return "register";
	}

	@PostMapping("ckt_register")
	public String registerCustomer(Map<String, Object> map, @ModelAttribute("ckt") Crickter ckt) {
		System.out.println("CrickterController.registerCustomer()");
		// use service
		String resultMsg = service.registerCrickter(ckt);
		map.put("resulMsg", resultMsg);
		return "result";
	}
	
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		System.out.println("CrickterController.myInitBinder()");
		binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(LocalDateTime.class, new LocalTimeEditor());
		
		
	}
}
