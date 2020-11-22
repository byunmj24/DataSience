package com.project.medinote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "main/home";
	}
	@RequestMapping("/disease")
	public String disease() {
		return "main/disease";
	}
}
