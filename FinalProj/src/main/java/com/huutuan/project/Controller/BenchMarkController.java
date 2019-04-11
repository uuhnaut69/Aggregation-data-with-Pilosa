package com.huutuan.project.Controller;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huutuan.project.Entity.AjaxRespModel;
import com.huutuan.project.Repository.VideoRepository;

/**
 * @author uuhnaut
 *
 */
@RestController
public class BenchMarkController {
	@Autowired
	private VideoRepository videoRepository;

	@GetMapping("/doBenchMark/{type}/{pageNo}/{pageSize}")
	public AjaxRespModel doBenchMark(@PathVariable int type, @PathVariable int pageNo, @PathVariable int pageSize) {
		AjaxRespModel respModel = new AjaxRespModel();
		Pageable pageRequest = PageRequest.of(pageNo, pageSize);
//	type = 1: image bm, type = 2: video bm
		if (type == 1) {
//			usersImagesRepository.doBenchMark(respModel);
		} else if (type == 2) {
			long mysqlStart = new DateTime().getMillis();
			Page<Object[]> pageVideo = videoRepository.getData(pageRequest);
			long mysqlEnd = new DateTime().getMillis();
			long mysqlRuntime = mysqlEnd - mysqlStart;
			List<Object[]> listVideo = pageVideo.getContent();
			respModel.setList(listVideo);
			respModel.setMysqlRunTime(mysqlRuntime);
		}
		return respModel;
	}

	@GetMapping("/singleBenchMark/{type}/{id}")
	public AjaxRespModel singleBenchMark(@PathVariable int type, @PathVariable int id) {
		AjaxRespModel respModel = new AjaxRespModel();
		// type = 1: single image bm, type = 2: single video bm
		if (type == 1) {
//			usersImagesRepository.singleBenchMark(respModel, id);
		} else if (type == 2) {
			long mysqlStart = new DateTime().getMillis();
			List<Object[]> listVideo = videoRepository.getOne(id);
			long mysqlEnd = new DateTime().getMillis();
			long mysqlRuntime = mysqlEnd - mysqlStart;
			respModel.setList(listVideo);
			respModel.setMysqlRunTime(mysqlRuntime);
		}
		return respModel;
	}
}
