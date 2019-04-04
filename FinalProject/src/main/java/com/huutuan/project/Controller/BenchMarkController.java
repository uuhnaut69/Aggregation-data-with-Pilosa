package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huutuan.project.Entity.AjaxRespModel;
import com.huutuan.project.Repository.UsersImagesRepository;
import com.huutuan.project.Repository.UsersVideosRepository;

/**
 * @author uuhnaut
 *
 */
@RestController
public class BenchMarkController {

	@Autowired
	private UsersImagesRepository usersImagesRepository;
	@Autowired
	private UsersVideosRepository usersVideosRepository;

	@GetMapping("/doBenchMark/{type}")
	public AjaxRespModel doBenchMark(@PathVariable int type) {
		AjaxRespModel respModel = new AjaxRespModel();
//		type = 1: image bm, type = 2: video bm
		if (type == 1) {
			usersImagesRepository.doBenchMark(respModel);
		} else if (type == 2) {
			usersVideosRepository.doBenchMark(respModel);
		}
		return respModel;
	}

	@GetMapping("/singleBenchMark/{type}/{id}")
	public AjaxRespModel singleBenchMark(@PathVariable int type, @PathVariable int id) {
		AjaxRespModel respModel = new AjaxRespModel();
//		type = 1: single image bm, type = 2: single video bm
		if (type == 1) {
			usersImagesRepository.singleBenchMark(respModel, id);
		} else if (type == 2) {
			usersVideosRepository.singleBenchMark(respModel, id);
		}
		return respModel;
	}
}
