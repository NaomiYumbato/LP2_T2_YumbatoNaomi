package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@GetMapping("/")
	public String home (Model model) {
		List<EmpleadoEntity> listEmp = empleadoRepository.findAll();
		model.addAttribute("lstEmp",listEmp);
		return "home";
	}
}
