package com.thymleaf.thymleafProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controllers {

	
	private static List<Person>list= new ArrayList<Person>();
	
	static {
		
		
		list.add(new Person("robel", "shanbel"));
		list.add(new Person("abrham", "fname") );
		
	}
	
	@GetMapping({"/","index"})
	
	public String index(Model model) {
		String message="Welcome to thymleaf";
		model.addAttribute("message", message);
		
		return "index";
		
	}
	@GetMapping("/personlist")
	
	public String personlist( Model model ) {
		
		model.addAttribute("listofperson", list);
		
		return "personlist";
	}
	
	
	@GetMapping("/personform")
	
	public String personform( Model model) {
		
		Person person= new Person();
		
		model.addAttribute("personobj", person);
		
		return "form";
		
	}
	
	@PostMapping("/register")
	
	public String register(@ModelAttribute ("personobj") Person person  ) {
		
		String fname= person.getFirstName();
		String lname= person.getLastName();
		
		Person obj= new Person(fname, lname);
		
		list.add(obj);
		
		return "redirect:/personlist";
		
		
	}
	
}
