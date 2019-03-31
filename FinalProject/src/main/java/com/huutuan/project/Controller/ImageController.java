package com.huutuan.project.Controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huutuan.project.Repository.ImageRepository;
import com.huutuan.project.Repository.UsersImagesRepository;

/**
 * @author uuhnaut
 *
 */
@Controller
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private UsersImagesRepository usersImagesRepository;

	@GetMapping("/")
	public String getData(Model model) {
		model.addAttribute("images", imageRepository.findAll());
		return "dashboard";
	}

	@GetMapping("/doBenchMark")
	public String doBenchMark(Model model) {
		Long startTime = new DateTime().getMillis();
		System.out.println(usersImagesRepository.doBenchMark());
		Long endTime = new DateTime().getMillis();
		Long runTime = endTime - startTime;
		model.addAttribute("runTime", runTime);
		model.addAttribute("respBenchMark", usersImagesRepository.doBenchMark());
		return "dashboard";
	}
}
