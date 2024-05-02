package com.example.aprendizajespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.aprendizajespring.helpers.ViewRouteHelper;
import com.example.aprendizajespring.models.DegreeModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/degrees")
public class DegreeController {
	@GetMapping("/form")
	public String degree(Model model) {
		model.addAttribute("degree", new DegreeModel());
		return ViewRouteHelper.DEGREE_FORM;
	}

	@PostMapping("/new")
	public ModelAndView newdegree(@Valid @ModelAttribute("degree") DegreeModel degree, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelper.DEGREE_FORM);
		} else {
			mV.setViewName(ViewRouteHelper.DEGREE_NEW);
			mV.addObject("degree", degree);
		}
		return mV;
	}
}
