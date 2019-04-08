package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huutuan.project.Repository.ImageRepository;

/**
 * @author uuhnaut
 *
 */
@Controller
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;

	@GetMapping("/")
	public String getData(Model model) {
		model.addAttribute("images", imageRepository.getData());
		return "dashboard-image";
	}
}
