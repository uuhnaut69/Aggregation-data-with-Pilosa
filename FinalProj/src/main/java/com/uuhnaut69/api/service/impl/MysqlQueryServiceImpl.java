package com.uuhnaut69.api.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uuhnaut69.api.entity.view.ImageView;
import com.uuhnaut69.api.payload.BenchMarkAllResponse;
import com.uuhnaut69.api.payload.BenchMarkByIdResponse;
import com.uuhnaut69.api.repository.ImageViewRepository;
import com.uuhnaut69.api.service.MysqlQueryService;

import javassist.NotFoundException;

/**
 * @author uuhnaut
 *
 */
@Service
@Transactional(readOnly = true)
public class MysqlQueryServiceImpl implements MysqlQueryService {

	private final ImageViewRepository imageViewRepository;

	public MysqlQueryServiceImpl(ImageViewRepository imageViewRepository) {
		this.imageViewRepository = imageViewRepository;
	}

	@Override
	public BenchMarkByIdResponse getById(Long id) throws Exception {
		BenchMarkByIdResponse respModel = new BenchMarkByIdResponse();
		long mySqlStart = new DateTime().getMillis();
		ImageView imageView = imageViewRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not found !!!"));
		respModel.setImageInfo(imageView);
		long mySqlEnd = new DateTime().getMillis();
		long runTime = mySqlEnd - mySqlStart;
		respModel.setRunTime(runTime);
		return respModel;
	}

	@Override
	public BenchMarkAllResponse getAll() {
		BenchMarkAllResponse respModel = new BenchMarkAllResponse();
		long mySqlStart = new DateTime().getMillis();
		List<ImageView> imageViews = imageViewRepository.findAll();
		respModel.setList(imageViews);
		long mySqlEnd = new DateTime().getMillis();
		long runTime = mySqlEnd - mySqlStart;
		respModel.setRunTime(runTime);
		return respModel;
	}

}
