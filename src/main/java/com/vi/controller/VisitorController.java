package com.vi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vi.entity.Visitor;
import com.vi.service.VisitorService;

@Controller
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("visitor", new Visitor());
		model.addAttribute("visitors", visitorService.getAllVisitors());
		return "index";
	}
	
	@PostMapping("/add-visitor")
	public String addVisitor(
//			@RequestParam("name") String name,
//			@RequestParam("address") String addrss,
//			@RequestParam("email") String email,
//			@RequestParam("time") String time
//This is an alternative for specific fields
			
			@ModelAttribute Visitor visitor
			) {
//		Visitor v = new Visitor();
//		v.setName(name);
//		v.setAddress(addrss);
//		v.setEmail(email);
//		v.setTime(time);
		
		visitorService.addVisitor(visitor);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delVisitor(@PathVariable("id") Integer i) {
		visitorService.deleteVisitorByID(i);
		return "redirect:/";
	}
}
