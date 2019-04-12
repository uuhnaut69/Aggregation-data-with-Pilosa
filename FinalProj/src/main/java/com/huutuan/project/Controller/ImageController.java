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
import com.huutuan.project.Repository.ImageRepository;
import com.huutuan.project.Utils.PagingUtils;

/**
 * @author uuhnaut
 *
 */
@Controller
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;

	@GetMapping("/images")
	public String getImages(Model model,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		BaseRespModel baseModel = new BaseRespModel();
		Pageable pageRequest = PageRequest.of(0, pageSize);
		Page<Object[]> pageImage = imageRepository.getData(pageRequest);
		baseModel.setTotalRecord(pageImage.getTotalElements());
		baseModel.setPageNo(pageNo);
		baseModel.setPageSize(pageSize);
		List<Object[]> listImage = pageImage.getContent();

		// caculate Page Index
		PagingUtils.calculateIndexInPage(baseModel);
		model.addAttribute("images", listImage);
		model.addAttribute("totalRecord", baseModel.getTotalRecord());
		model.addAttribute("pageNo", baseModel.getPageNo());
		model.addAttribute("pageSize", baseModel.getPageSize());
		model.addAttribute("fromRecord", baseModel.getFromRecord());
		model.addAttribute("toRecord", baseModel.getToRecord());
//		model.addAttribute("prevPage", pageImage.previousPageable().getPageNumber());
//		model.addAttribute("nextPage", pageImage.nextPageable().getPageNumber());
		return "dashboard-image";
	}
}
