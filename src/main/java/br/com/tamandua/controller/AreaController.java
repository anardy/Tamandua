package br.com.tamandua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AreaController {

	@RequestMapping("/area")
	public String execute() {
		return "area";
	}
}
