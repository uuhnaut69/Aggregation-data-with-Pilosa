package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huutuan.project.Entity.Image;
import com.huutuan.project.Repository.ImageRepository;

@Controller
public class ImageController {
	private final ImageRepository imageRepository;

	@Autowired
	public ImageController(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	@GetMapping("/")
	public String showSignUpForm(Image image, Model model) {
		model.addAttribute("images", imageRepository.findAll());
		return "dashboard";
	}
}
