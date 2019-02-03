package es.salesianos.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BaseController {

	@GetMapping("/index")
	private String goToIndex() {
		return "index";
	}

//	@GetMapping("/error")
//	private String getErrorPage() {
//		return "error";
//	}
}
