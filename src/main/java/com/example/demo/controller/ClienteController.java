package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@RequestMapping("/cliente")
	public String index(Model model) {
		model.addAttribute("list", clienteService.getAll());
		return "inicio";
	}

}