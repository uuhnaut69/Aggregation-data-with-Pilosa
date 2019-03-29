package com.huutuan.bitmap.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huutuan.bitmap.Entity.Video;
import com.huutuan.bitmap.Entity.VideoRespModel;
import com.huutuan.bitmap.Repository.VideoRepository;
import com.huutuan.bitmap.Service.VideoService;

@Controller
public class VideoController {
	private final VideoRepository videoRepository;

	@Autowired
	public VideoController(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	@Autowired
	private VideoService videoService;

	@GetMapping("/videos")
	public String homePage(Model model, @RequestParam("pageNo") Optional<Integer> pageNo,
			@RequestParam("pageSize") Optional<Integer> pageSize) {
		final int currentPage = pageNo.orElse(1);
		final int size = pageSize.orElse(10);
		VideoRespModel respModel = videoService.getDataSearch(currentPage, size);
		model.addAttribute("searchRespModel", respModel);
		List<Video> listVideo = respModel.getListVideo();
		model.addAttribute("listVideo", listVideo);

		if (respModel.getTotalPage() > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(currentPage, size + 9).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "videoPage";
	}

}
