package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huutuan.project.Repository.VideoRepository;

@Controller
public class VideoController {
	@Autowired
	private VideoRepository videoRepository;

	@GetMapping("/videos")
	public String getVideos(Model model) {
		model.addAttribute("videos", videoRepository.findAll());
		return "videos";
	}
}
