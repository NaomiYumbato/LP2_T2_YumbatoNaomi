package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.*;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private AreaRepository areaRepository;

	@GetMapping("/")
	public String home(Model model) {
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		model.addAttribute("empleado", empleadoEntity);
		List<EmpleadoEntity> listEmp = empleadoRepository.findAll();
		model.addAttribute("lstEmp", listEmp);
		return "home";
	}

	@GetMapping("/registrarEmp")
	public String viewRegistro(Model model) {
		model.addAttribute("user", new EmpleadoEntity());
		List<AreaEntity> listArea = areaRepository.findAll();
		model.addAttribute("listArea", listArea);
		return "registrar";
	}

	@PostMapping("/registrarEmp")
	public String registrarEmpleado(@ModelAttribute EmpleadoEntity emp, Model model) {
		if (empleadoRepository.findByDniEmpleado(emp.getDniEmpleado()) != null) {
			model.addAttribute("errorMessage", "El DNI escrito ya está registrado");
			model.addAttribute("user", new EmpleadoEntity());
			List<AreaEntity> listArea = areaRepository.findAll();
			model.addAttribute("listArea", listArea);
			return "registrar";
		}
		empleadoRepository.save(emp);
		return "redirect:/";
	}

	@GetMapping("/editarEmp/{dniEmpleado}")
	public String actualizarEmp(Model model, @PathVariable("dniEmpleado") String dniEmpleado) {
		EmpleadoEntity empencotrado = empleadoRepository.findByDniEmpleado(dniEmpleado);
		List<AreaEntity> listArea = areaRepository.findAll();
		model.addAttribute("listArea", listArea);
		model.addAttribute("user", empencotrado);
		return "actualizar";
	}

	@PostMapping("/editarEmp")
	public String actualizarEmpleado(EmpleadoEntity emp, Model model) {
		model.addAttribute("user", new EmpleadoEntity());
		List<AreaEntity> listArea = areaRepository.findAll();
		model.addAttribute("listArea", listArea);
		empleadoRepository.save(emp);
		return "redirect:/";
	}

	@GetMapping("/eliminarEmp/{dniEmpleado}")
	public String eliminarEmp(@PathVariable("dniEmpleado") String dniEmpleado) {
		empleadoRepository.deleteById(dniEmpleado);
		return "redirect:/";
	}

}
