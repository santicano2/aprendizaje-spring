package com.example.aprendizajespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.aprendizajespring.helpers.ViewRouteHelper;
import com.example.aprendizajespring.models.Degree;

@Controller
@RequestMapping("/degrees")
public class DegreeController {
	@GetMapping("/form")
	public String degree(Model model) {
		model.addAttribute("degree", new Degree());
		return ViewRouteHelper.DEGREE_FORM;
	}

	@PostMapping("/new")
	public ModelAndView newdegree(@ModelAttribute("degree") Degree degree) {
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.DEGREE_NEW);
		mV.addObject("degree", degree);
		return mV;
	}
}
