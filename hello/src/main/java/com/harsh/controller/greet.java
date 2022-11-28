package com.harsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class greet {

	@GetMapping("/harsh")
	public String Harsh()
	{
		return "hello";
	}
}