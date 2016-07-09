package br.com.control.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/panel/")
@SessionAttributes("roles")
public class HomeController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String indexPage () {
		return "home";
	}
	
}
