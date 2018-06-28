package com.qxd.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PaginaInicialController {
	
	@RequestMapping("/ac-sport")
	public String paginaInicial() {
		return "index";
	}
	@RequestMapping("/Contact")
	public String contato() {
		return "Contact";
	}
	
	@RequestMapping("/about")
	public String sobre() {
		return "about";
	}

}
