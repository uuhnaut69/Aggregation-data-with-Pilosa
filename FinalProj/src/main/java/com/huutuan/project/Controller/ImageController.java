package com.huutuan.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huutuan.project.Entity.ImageInfo;
import com.huutuan.project.Service.PilosaService;

/**
 * @author uuhnaut
 *
 */
@Controller
public class ImageController {
	@Autowired
	private PilosaService pilosaService;

	@GetMapping("/dashboard")
	public String getImages(Model model) {
		List<ImageInfo> list = pilosaService.getAll().getList();
		model.addAttribute("images", list);
		return "dashboard";
	}

	@GetMapping("/")
	public String returnLandingPage() {
		return "landingpage";
	}
}
