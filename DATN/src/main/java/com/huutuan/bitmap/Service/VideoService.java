package com.huutuan.bitmap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huutuan.bitmap.Entity.Video;
import com.huutuan.bitmap.Entity.VideoRespModel;
import com.huutuan.bitmap.Repository.VideoRepository;
import com.huutuan.bitmap.Utils.CalculateIndex;
import com.huutuan.bitmap.Utils.NumberUtils;

/**
 * @author uuhnaut
 *
 */
@Service
public class VideoService {
	@Autowired
	private VideoRepository videoRepo;

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public VideoRespModel getDataSearch(int pageNo, int pageSize) {
		VideoRespModel respModel = new VideoRespModel();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		Page<Video> videoPage = videoRepo.findAll(pageable);

		List<Video> listVideo = videoPage.getContent();
		respModel.setListVideo(listVideo);
		respModel.setPageNo(NumberUtils.nvl(pageNo, 0));
		respModel.setPageSize(NumberUtils.nvl(pageSize, 0));
		respModel.setTotalRecord(Math.toIntExact(videoPage.getTotalElements()));
		respModel.setTotalPage(videoPage.getTotalPages());
		CalculateIndex.calculateIndexInPage(respModel);

		return respModel;
	}
}