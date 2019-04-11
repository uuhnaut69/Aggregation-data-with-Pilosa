package com.huutuan.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huutuan.project.Entity.BaseRespModel;
import com.huutuan.project.Repository.VideoRepository;
import com.huutuan.project.Utils.PagingUtils;

/**
 * @author uuhnaut
 *
 */
@Controller
public class VideoController {
	@Autowired
	private VideoRepository videoRepository;

	@GetMapping("/videos")
	public String getVideos(Model model,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		BaseRespModel baseModel = new BaseRespModel();
		Pageable pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Object[]> pageVideo = videoRepository.getData(pageRequest);
		baseModel.setTotalRecord(pageVideo.getTotalElements());
		baseModel.setPageNo(pageNo);
		baseModel.setPageSize(pageSize);
		List<Object[]> listVideo = pageVideo.getContent();

		// caculate Page Index
		PagingUtils.calculateIndexInPage(baseModel);
		model.addAttribute("videos", listVideo);
		model.addAttribute("totalRecord", baseModel.getTotalRecord());
		model.addAttribute("pageNo", baseModel.getPageNo());
		model.addAttribute("pageSize", baseModel.getPageSize());
		model.addAttribute("fromRecord", baseModel.getFromRecord());
		model.addAttribute("toRecord", baseModel.getToRecord());
		model.addAttribute("prevPage", pageVideo.previousPageable().getPageNumber());
		model.addAttribute("nextPage", pageVideo.nextPageable().getPageNumber());
		return "dashboard-video";
	}
}
