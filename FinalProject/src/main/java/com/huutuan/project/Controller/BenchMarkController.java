package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huutuan.project.Entity.AjaxRespModel;
import com.huutuan.project.Repository.UsersImagesRepository;

@RestController
public class BenchMarkController {

	@Autowired
	private UsersImagesRepository usersImagesRepository;

	@GetMapping("/doBenchMark")
	public AjaxRespModel doBenchMark(Model model) {
		AjaxRespModel respModel = usersImagesRepository.doBenchMark();
		return respModel;
	}
}
