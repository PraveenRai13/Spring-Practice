package com.harsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Greet {

	@GetMapping("/harsh")
	public String greet() {
		return "hello";
		}
	}
