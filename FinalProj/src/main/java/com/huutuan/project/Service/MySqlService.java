package com.huutuan.project.Service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huutuan.project.Entity.BenchMarkAllRespModel;
import com.huutuan.project.Entity.BenchMarkByIdRespModel;
import com.huutuan.project.Entity.ImageInfo;
import com.huutuan.project.Repository.ImageRepository;

/**
 * @author uuhnaut
 *
 */
@Service
public class MySqlService {
	@Autowired
	private ImageRepository imageRepository;

	public BenchMarkByIdRespModel getById(int id) {
		BenchMarkByIdRespModel respModel = new BenchMarkByIdRespModel();
		long mySqlStart = new DateTime().getMillis();
		ImageInfo imageInfo = imageRepository.getImageInfoById(id);
		respModel.setImageInfo(imageInfo);
		long mySqlEnd = new DateTime().getMillis();
		long runTime = mySqlEnd - mySqlStart;
		respModel.setRunTime(runTime);
		return respModel;
	}

	public BenchMarkAllRespModel getAll() {
		BenchMarkAllRespModel respModel = new BenchMarkAllRespModel();
		long mySqlStart = new DateTime().getMillis();
		List<ImageInfo> list = imageRepository.getImagesInfo();
		respModel.setList(list);
		long mySqlEnd = new DateTime().getMillis();
		long runTime = mySqlEnd - mySqlStart;
		respModel.setRunTime(runTime);
		return respModel;
	}

}
