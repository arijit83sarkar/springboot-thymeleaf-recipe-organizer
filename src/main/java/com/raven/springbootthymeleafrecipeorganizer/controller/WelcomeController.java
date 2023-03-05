package com.raven.springbootthymeleafrecipeorganizer.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/welcome")
	public String welcome(Model _model) {
		_model.addAttribute("name", new Date());

		return "welcome";
	}
}
