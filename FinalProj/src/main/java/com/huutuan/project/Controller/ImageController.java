package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huutuan.project.Entity.ImageRespModel;
import com.huutuan.project.Service.PilosaService;

/**
 * @author uuhnaut
 *
 */
@Controller
public class ImageController {
	@Autowired
	private PilosaService pilosaService;

	@GetMapping("/")
	public String getImages(Model model) {
		ImageRespModel respModel = new ImageRespModel();
		respModel.setList(pilosaService.getAll());
		model.addAttribute("images", respModel.getList());
		return "dashboard";
	}
}
