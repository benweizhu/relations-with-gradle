package me.zeph.relations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RelationsController {

	@RequestMapping(value = "/")
	public String view() {
		return "index";
	}

}