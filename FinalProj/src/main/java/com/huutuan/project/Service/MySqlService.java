package com.huutuan.project.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huutuan.project.Repository.ImageRepository;

/**
 * @author uuhnaut
 *
 */
@Service
public class MySqlService {
	@Autowired
	private ImageRepository imageRepository;

	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> respModel = new ArrayList<Map<String, Object>>();
		List<Object[]> listImages = imageRepository.getData();
		for (Object[] item : listImages) {
			Map<String, Object> mapItem = new HashMap<String, Object>();
			mapItem.put("id", item[0]);
			mapItem.put("title", item[1]);
			mapItem.put("description", item[2]);
			mapItem.put("url", item[3]);
			mapItem.put("totalLikes", item[4]);
			mapItem.put("totalShares", item[5]);
			respModel.add(mapItem);
		}
		return respModel;
	}

	public Map<String, Object> getById(int id) {
		long PqlStart = new DateTime().getMillis();
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		Map<String, Object> respModel = new HashMap<String, Object>();
		List<Object[]> images = imageRepository.getOne(id);

		for (Object[] item : images) {
			Map<String, Object> mapItem = new HashMap<String, Object>();
			mapItem.put("id", item[0]);
			mapItem.put("title", item[1]);
			mapItem.put("description", item[2]);
			mapItem.put("url", item[3]);
			mapItem.put("totalLikes", item[4]);
			mapItem.put("totalShares", item[5]);
			listData.add(mapItem);
		}

		respModel = listData.get(0);
		long PqlEnd = new DateTime().getMillis();
		long PqlRuntime = PqlEnd - PqlStart;
		respModel.put("runTime", PqlRuntime);
		return respModel;
	}
}
