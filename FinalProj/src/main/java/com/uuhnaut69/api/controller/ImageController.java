package com.uuhnaut69.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uuhnaut69.api.entity.view.ImageView;
import com.uuhnaut69.api.service.PilosaQueryService;

/**
 * @author uuhnaut
 *
 */
@Controller
public class ImageController {

	private final PilosaQueryService pilosaQueryService;

	public ImageController(PilosaQueryService pilosaQueryService) {
		this.pilosaQueryService = pilosaQueryService;
	}

	@GetMapping("/dashboard")
	public String getImages(Model model) throws Exception {
		List<ImageView> list = pilosaQueryService.getAll().getList();
		model.addAttribute("images", list);
		return "dashboard";
	}

	@GetMapping("/")
	public String returnLandingPage() {
		return "landingpage";
	}
}
